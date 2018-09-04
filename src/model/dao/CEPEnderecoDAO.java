package model.dao;

import connection.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.CEPEndereco;
import utils.Enumeradors;

public class CEPEnderecoDAO {

    private List<CEPEndereco> GetByAll(int Limite, String CEP_or_Logradouro, int id) {
        List<CEPEndereco> enderecosCEP = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();
            String CmdSQL
                    = "select\n"
                    + "lg.Id\n"
                    + ", lg.CEP\n"
                    + ", lg.Logradouro\n"
                    + ", lg.Complemento\n"
                    + ", br.Id\n"
                    + ", br.Bairro\n"
                    + ", cd.Id\n"
                    + ", cd.UF\n"
                    + ", cd.Cidade\n"
                    + ", cd.Latitude\n"
                    + ", cd.Longitude\n"
                    + "from CEPLogradouro lg\n"
                    + "left join CEPBairro br on lg.CEPBairro = br.Id\n"
                    + "left join CEPCidade cd on br.CEPCidade = cd.Id\n";
            String OrderByAndLimit
                    = "order by cd.UF, cd.Cidade, br.Bairro, lg.Logradouro, lg.Complemento, lg.CEP \n"
                    + (Limite > 0 ? " limit ".concat(String.valueOf(Limite)).concat(" ") : "");
            if (id > 0) {
                CmdSQL += "where lg.Id = ? \n".concat(OrderByAndLimit);
                stmt = con.prepareStatement(CmdSQL);
                stmt.setInt(1, id);
            } else {
                CmdSQL += "where lg.CEP = ? or lg.CEPBkp = ? or lg.Logradouro like ? \n".concat(OrderByAndLimit);
                stmt = con.prepareStatement(CmdSQL);
                stmt.setString(1, CEP_or_Logradouro);
                stmt.setString(2, CEP_or_Logradouro);
                stmt.setString(3, ("%").concat(CEP_or_Logradouro.concat("%")));
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                enderecosCEP.add(
                        new CEPEndereco(
                                rs.getInt("Id"),
                                rs.getString("CEP"),
                                rs.getString("Logradouro"),
                                rs.getString("Complemento"),
                                rs.getString("Bairro"),
                                Enumeradors.UF.valueOf(rs.getString("UF")),
                                rs.getString("Cidade"),
                                rs.getDouble("Latitude"),
                                rs.getDouble("Longitude")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CEPEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao tentar buscar CEP Enderecos: " + ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return enderecosCEP;
    }

    public List<CEPEndereco> GetByCEP_or_Logradouro(int Limite, String CEP_or_Logradouro) {
        return this.GetByAll(Limite, CEP_or_Logradouro, 0);
    }

    public CEPEndereco GetById(int id) {
        return this.GetByAll(0, "", id).get(0);
    }
}
