package model.dao;

import connection.DataConnection;
import controller.ConsumoEnergeticoCTRL;
import controller.EnderecoCTRL;
import controller.StatusCTRL;
import controller.TipoPessoaCTRL;
import controller.UnidadeConsumidoraCTRL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.ConsumoEnergetico;
import model.bean.Endereco;
import model.bean.NecessidadeEnergeticaCliente;
import model.bean.UnidadeConsumidora;
import utils.Utilitarios;

public class ClienteDAO {

    public ClienteDAO() {
        Connection con = null;
        try {
            con = DataConnection.getConnection();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar pegar conexção: " + ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> GetAll(int pMaxResultRecord, int pId, String pNome, boolean OnlyLastRecord) {
        List<Cliente> clientes = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();

            String SelectCMD = "SELECT Id, NomeFantasia_Apelido, RazaoSocial_Nome, CNPJ_CPF, IE_RG, IM, DataNascimento, Status, TipoPessoa FROM Cliente ";
            String Limite = pMaxResultRecord > 0 ? " limit ".concat(String.valueOf(pMaxResultRecord)) : "";

            if (OnlyLastRecord) {
                stmt = con.prepareStatement(SelectCMD.concat(" order by Id desc limit 1 "));
            } else if (pId > 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" where Id = ? ").concat(Limite));
                stmt.setInt(1, pId);
            } else if (pNome.trim().length() > 0) {
                stmt = con.prepareStatement(SelectCMD.concat(" where NomeFantasia_Apelido like ? or RazaoSocial_Nome like ? ").concat(Limite));
                stmt.setString(1, ("%").concat(pNome).concat("%"));
                stmt.setString(2, ("%").concat(pNome).concat("%"));
//            } else if (pCPF.trim().length() > 0) {
//                stmt = con.prepareStatement(SelectCMD.concat(" where CNPJ_CPF = ? "));
//                stmt.setString(1, pCPF);
            } else {
                stmt = con.prepareStatement(SelectCMD.concat(Limite));
            }

            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("Id"));
                c.setNomeFantasia_Apelido(rs.getString("nomeFantasia_Apelido"));
                c.setRazaoSocial_Nome(rs.getString("razaoSocial_Nome"));
                c.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                c.setIE_RG(rs.getString("IE_RG"));
                c.setIM(rs.getString("IM"));
                c.setDataNascimento(rs.getDate("dataNascimento"));
                c.setStatus(StatusCTRL.BuscaPorId(rs.getInt("Status")));
                c.setTipoPessoa(TipoPessoaCTRL.BuscaPorId(rs.getInt("TipoPessoa")));
//                c.setEnderecos(EnderecoCTRL.BuscarPorCliente(new Cliente(rs.getInt("Id"))));
//                c.setContatos(ContatoCTRL.BuscarPorCliente(new Cliente(rs.getInt("Id"))));
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Cliente: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

//        if (clientes.isEmpty()) {
//            clientes.add(new Cliente());
//        }
        return clientes;
    }

    public static boolean AlreadyExistingCNPJorCPF(Cliente clnt_) {
        boolean resultado = false;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("select c.Id from Cliente c where c.CNPJ_CPF = ?;");
            stmt.setString(1, clnt_.getCNPJ_CPF());
            rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("Id") != clnt_.getId();
                if (resultado) {
                    break;
                }
            }
        } catch (SQLException e) {
            Utilitarios.MsgExcecao(e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
        return resultado;
    }

    public Cliente GetById(int Limite, int pId) {
        return this.GetAll(Limite, pId, "", false).get(0);
    }

    public List<Cliente> GetByNome(int Limite, String pNome) {
        return this.GetAll(Limite, 0, pNome, false);
    }

    public void Delete(int pId) {
        Utilitarios.ExcluirObjetos(pId, Cliente.class);
    }

    /**
     * Inclui ou Atualiza
     *
     * @param cliente
     * @return
     */
    public Cliente Persist(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean NovoCliente = cliente.IsNew();
//        boolean tpPF = TipoPessoaCTRL.BuscaPorDescricao("f%sic%").get(0).equals(cliente.getTipoPessoa());
        try {
            con = DataConnection.getConnection();
            String CmdSQL = cliente.IsNew()
                    ? "insert into Cliente set "
                    + "NomeFantasia_Apelido = ?"
                    + ", RazaoSocial_Nome = ?"
                    + ", CNPJ_CPF = ?"
                    + ", IE_RG = ?"
                    + ", IM = ?"
                    + (cliente.getDataNascimento() != null ? ", DataNascimento = ?" : "")
                    + ", Status = ?"
                    + ", TipoPessoa = ?"
                    : "update Cliente set "
                    + "NomeFantasia_Apelido = ?"
                    + ", RazaoSocial_Nome = ?"
                    + ", CNPJ_CPF = ?"
                    + ", IE_RG = ?"
                    + ", IM = ?"
                    + (cliente.getDataNascimento() != null ? ", DataNascimento = ? " : "")
                    + ", Status = ?"
                    + ", TipoPessoa = ? "
                    + "where Id  = ?";
            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setString(ii++, cliente.getNomeFantasia_Apelido());
            stmt.setString(ii++, cliente.getRazaoSocial_Nome());
            stmt.setString(ii++, cliente.getCNPJ_CPF());
            stmt.setString(ii++, cliente.getIE_RG());
            stmt.setString(ii++, cliente.getIM());
//            if (tpPF) {
            if (cliente.getDataNascimento() != null) {
//                stmt.setDate(ii++, new Date(cliente.getDataNascimento().getYear(), cliente.getDataNascimento().getMonth(), cliente.getDataNascimento().getDay()));
                stmt.setDate(ii++, new Date(cliente.getDataNascimento().getTime()));
            }
            stmt.setInt(ii++, cliente.getStatus().getId());
            stmt.setInt(ii++, cliente.getTipoPessoa().getId());
            if (!cliente.IsNew()) {
                stmt.setInt(ii++, cliente.getId());
            }
            stmt.executeUpdate();

            Utilitarios.MsgSucesso();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, (cliente.IsNew() ? "INCLUINDO " : "ATUALIZANDO ") + Cliente.class.getSimpleName() + "\r\n " + ex, "<<< Comportamento não previsto >>>", 2);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }
//        if (cliente.IsNew()) {
//            cliente.setId(this.GetAll(0, 0, "", true).get(0).getId());
//            cliente.getEnderecos().forEach((Endereco ender) -> {
//                if (ender.getCEP() != null) {
//                    ender.setCliente(cliente);
//                    EnderecoCTRL.Gravar(ender);
//                }
//            });
//            cliente.getContatos().forEach((Contato cntt) -> {
//                if (cntt.getDescricao() != null) {
//                    cntt.setCliente(cliente);
//                    ContatoCTRL.Gravar(cntt);
//                }
//            });
//            return this.GetById(0, cliente.getId());
//        } else {
//            return cliente;
//        }
        return NovoCliente ? this.GetAll(0, 0, "", true).get(0) : cliente;
    }

//    public NecessidadeEnergeticaCliente GetNessecidadeEnergetica(int idCliente) {
//        NecessidadeEnergeticaCliente nec = new NecessidadeEnergeticaCliente();
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            con = DataConnection.getConnection();
//            String CmdSQL = "create temporary table Consumo\n"
//                    + "select coalesce(count(ce.Id),0) Qtde, coalesce(sum(ce.Consumo),0) Total  from Cliente clnt\n"
//                    + "inner join Endereco ender on clnt.Id = ender.Cliente\n"
//                    + "inner join UnidadeConsumidora uc on ender.Id = uc.Endereco\n"
//                    + "inner join ConsumoEnergetico ce on uc.Id = ce.UnidadeConsumidora\n"
//                    + "where clnt.Id = ?;\n"
//                    + "\n"
//                    + "create temporary table IrradiacaoEndereco\n"
//                    + "select coalesce(sum(igm.Anual),0) Irradiacao from Cliente clnt\n"
//                    + "inner join Endereco ender on clnt.Id = ender.Cliente\n"
//                    + "inner join IrradiacaoGlobalMes igm on ender.IrradiacaoGlobalMes = igm.Id\n"
//                    + "where clnt.Id = ?;\n"
//                    + "\n"
//                    + "/* Código padrão abaixo */\n"
//                    + "set @TotalComsuno = (select c.Total from Consumo c);\n"
//                    + "set @QtdeComsuno = (select c.Qtde from Consumo c);\n"
//                    + "set @MediaConsumoMes = (@TotalComsuno / @QtdeComsuno) * 1000;\n"
//                    + "set @MediaConsumoDia = @MediaConsumoMes / 30 ;\n"
//                    + "set @IrradiacaoDoLocal = (select ie.Irradiacao from IrradiacaoEndereco ie);\n"
//                    + "set @Calc1 = @MediaConsumoDia / @IrradiacaoDoLocal;\n"
//                    + "set @Calc2 = @Calc1 / 0.8;\n"
//                    + "\n"
//                    + "drop temporary table Consumo;\n"
//                    + "drop temporary table IrradiacaoEndereco;\n"
//                    + "select \n"
//                    + "@TotalComsuno TotalComsuno\n"
//                    + ", @QtdeComsuno QtdeComsuno\n"
//                    + ", @MediaConsumoMes MediaConsumoMes\n"
//                    + ", @MediaConsumoDia MediaConsumoDia\n"
//                    + ", @IrradiacaoDoLocal IrradiacaoDoLocal\n"
//                    + ", @Calc1 Calc1\n"
//                    + ", @Calc2 Calc2\n"
//                    + ";";
//            stmt = con.prepareStatement(CmdSQL);
//            stmt.setInt(1, idCliente);
//            stmt.setInt(2, idCliente);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                NecessidadeEnergeticaCliente x = new NecessidadeEnergeticaCliente();
//                x.setCalc1(rs.getDouble("Calc1"));
//                x.setCalc2(rs.getDouble("Calc2"));
////                x.setCliente();
//                x.setIrradiacaoDoLocal(rs.getDouble("IrradiacaoEndereco"));
//                x.setMediaConsumoDia(rs.getDouble("MediaConsumoDia"));
//                x.setMediaConsumoMes(rs.getDouble("MediaConsumoMes"));
//                x.setQtdeConsumo(rs.getDouble("QtdeConsumo"));
//                x.setTotalConsumo(rs.getDouble("TotalConsumo"));
//                nec = x;
//            }
//        } catch (SQLException e) {
//            Utilitarios.MsgExcecao("Erro ao tentar retornar Necessidade Energética: " + e);
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            DataConnection.closeConnection(con, stmt, rs);
//        }
//        return nec;
//    }
    public NecessidadeEnergeticaCliente GetNecessidadeEnergetica(Cliente c) {
        double IrradiacaoAnual = 0;
        double TotalConsumo = 0;
        int QtdeConsumo = 0;

        List<Endereco> enders = EnderecoCTRL.BuscarPorCliente(c);
        if (enders != null) {
            for (Endereco e : enders) {
                IrradiacaoAnual += e.getIrradiacaoGlobalMes().getAnual();

                List<UnidadeConsumidora> UCs = UnidadeConsumidoraCTRL.BuscarPorEndereco(e);
                if (UCs != null) {
                    for (UnidadeConsumidora uc : UCs) {
                        List<ConsumoEnergetico> CEs = ConsumoEnergeticoCTRL.BuscaPorUnidadeConsumidora(uc);
                        if (CEs != null) {
                            for (ConsumoEnergetico ce : CEs) {
                                TotalConsumo += ce.getConsumo();
                                QtdeConsumo++;
                            }
                        }
                    }
                }
            }
        }
        return new NecessidadeEnergeticaCliente(c, TotalConsumo, QtdeConsumo, IrradiacaoAnual);
    }
}
