package model.dao;

import connection.DataConnection;
import controller.IrradiacaoGlobalMesCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Endereco;
import utils.Enumeradors;
import utils.Utilitarios;

public class EnderecoDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    /**
     *
     *
     * @param cli Objeto Cliente (Obrigatório)
     * @param IdEndereco int (informe 0 para buscar todos endereços do cliente)
     * @param OnlyLastRecord setar verdadeiro para retornar último registro
     * inserido
     * @return coleção de Enderecos
     */
    private List<Endereco> GetAll(Cliente cli, int IdEndereco, boolean OnlyLastRecord) {
        List<Endereco> enderecos = new ArrayList<>();

        try {
            con = DataConnection.getConnection();
            String CmdSelect = "select Id, Logradouro, Complemento, Numero, CEP, UF, IrradiacaoGlobalMes, Cliente, Cidade, Bairro, Latitude, Longitude from Endereco ";
            String UltimoRegistro = OnlyLastRecord ? " order by Id desc limit 1 " : "";
            if (cli == null && IdEndereco > 0) {
                stmt = con.prepareStatement(CmdSelect.concat(" where Id = ? "));
                stmt.setInt(1, IdEndereco);
            } else if (!cli.IsNew() && IdEndereco > 0) {
                stmt = con.prepareStatement(CmdSelect.concat(" where Cliente = ? and Id = ? "));
                stmt.setInt(1, cli.getId());
                stmt.setInt(2, IdEndereco);
            } else {
                stmt = con.prepareStatement(CmdSelect.concat(" where Cliente = ? ").concat(UltimoRegistro));
                stmt.setInt(1, cli.getId());
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                Endereco ender = new Endereco();
                ender.setId(rs.getInt("Id"));
                ender.setCEP(rs.getString("CEP"));
                ender.setCidade(rs.getString("Cidade"));
                ender.setCliente(cli);
                ender.setComplemento(rs.getString("Complemento"));

                int igm = rs.getInt("IrradiacaoGlobalMes");
                if (igm > 0) {
                    ender.setIrradiacaoGlobalMes(IrradiacaoGlobalMesCTRL.BuscarPorId(rs.getInt("IrradiacaoGlobalMes")));
                }

                ender.setLogradouro(rs.getString("Logradouro"));
                ender.setNumero(rs.getString("Numero"));
                ender.setBairro(rs.getString("Bairro"));
                ender.setLatitude(rs.getDouble("Latitude"));
                ender.setLongitude(rs.getDouble("Longitude"));
                ender.setUF(Enumeradors.UF.valueOf(rs.getString("UF")));
                enderecos.add(ender);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Endereço: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

//        if (enderecos.isEmpty()) {
//            enderecos.add(new Endereco());
//        }
        return enderecos;
    }

    public List<Endereco> GetByCliente(Cliente cli) {
        return this.GetAll(cli, 0, false);
    }

    public Endereco GetById(int pId) {
        return this.GetAll(null, pId, false).get(0);
    }

    public void Delete(Endereco e) {
        Utilitarios.ExcluirObjetos(e.getId(), Endereco.class);
    }

    public Endereco Persist(Endereco endereco) {

        try {
            con = DataConnection.getConnection();

            String CmdSQL
                    = endereco.IsNew()
                    ? "insert into Endereco set "
                    + "Logradouro = ?"
                    + ", Complemento = ?"
                    + ", Numero = ?"
                    + ", CEP = ?"
                    + ", UF = ?"
                    + (endereco.getIrradiacaoGlobalMes() != null ? ", IrradiacaoGlobalMes = ?" : "")
                    + ", Cliente = ?"
                    + ", Cidade  = ?"
                    + ", Bairro = ?"
                    + ", Latitude = ?"
                    + ", Longitude = ?"
                    + ";"
                    : "update Endereco set "
                    + "Logradouro = ?"
                    + ", Complemento = ?"
                    + ", Numero = ?"
                    + ", CEP = ?"
                    + ", UF = ?"
                    + (endereco.getIrradiacaoGlobalMes() != null ? ", IrradiacaoGlobalMes = ?" : "")
                    + ", Cliente = ?"
                    + ", Cidade  = ?"
                    + ", Bairro = ?"
                    + ", Latitude = ?"
                    + ", Longitude = ?"
                    + "where Id = ?;";

            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setString(ii++, endereco.getLogradouro());
            stmt.setString(ii++, endereco.getComplemento());
            stmt.setString(ii++, endereco.getNumero());
            stmt.setString(ii++, endereco.getCEP());
            stmt.setString(ii++, String.valueOf(endereco.getUF()));
            if (endereco.getIrradiacaoGlobalMes() != null) {
                stmt.setInt(ii++, endereco.getIrradiacaoGlobalMes().getId());
            }
            stmt.setInt(ii++, endereco.getCliente().getId());
            stmt.setString(ii++, endereco.getCidade());
            stmt.setString(ii++, endereco.getBairro());
            stmt.setDouble(ii++, endereco.getLatitude());
            stmt.setDouble(ii++, endereco.getLongitude());
            if (!endereco.IsNew()) {
                stmt.setInt(ii++, endereco.getId());
            }
            System.out.println(CmdSQL);
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (endereco.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + Endereco.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return endereco.IsNew() ? this.GetAll(endereco.getCliente(), 0, true).get(0) : endereco;
    }
}
