package model.dao;

import connection.DataConnection;
import controller.StatusCTRL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Fornecedor;
import utils.Enumeradors;
import utils.Utilitarios;

public class FornecedorDAO {

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private List<Fornecedor> GetAll(int Limite, int ID, String Nome, boolean ApenasUltimoRegistro) {
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            con = DataConnection.getConnection();
            String SelectCMD = "select Id\n"
                    + " , NomeFantasia\n"
                    + " , RazaoSocial\n"
                    + " , CNPJ\n"
                    + " , IE\n"
                    + " , IM\n"
                    + " , Status\n"
                    + " , CEP\n"
                    + " , Logradouro\n"
                    + " , Complemento\n"
                    + " , EnderecoNumero\n"
                    + " , Bairro\n"
                    + " , Cidade\n"
                    + " , UF\n"
                    + " , Fone\n"
                    + " , Email\n"
                    + " from Fornecedor \n";
            if (ID > 0) {
                SelectCMD += " where Id = ? ";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setInt(1, ID);
            } else if (Nome.length() > 0) {
                SelectCMD += " where NomeFantasia like ? or RazaoSocial like ? or CNPJ like ? order by NomeFantasia, RazaoSocial, CNPJ ";
                stmt = con.prepareStatement(SelectCMD);
                stmt.setString(1, "%" + Nome + "%");
                stmt.setString(2, "%" + Nome + "%");
                stmt.setString(3, "%" + Nome + "%");
            } else if (ApenasUltimoRegistro) {
                SelectCMD += " order by Id desc";
                stmt = con.prepareStatement(SelectCMD);
            } else {
                stmt = con.prepareStatement(SelectCMD);
            }
            SelectCMD += Limite > 0 ? " limit " + Limite : "";

            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("Id"));
                fornecedor.setNomeFantasia(rs.getString("NomeFantasia"));
                fornecedor.setRazaoSocial(rs.getString("RazaoSocial"));
                fornecedor.setCNPJ(rs.getString("CNPJ"));
                fornecedor.setIE(rs.getString("IE"));
                fornecedor.setIM(rs.getString("IM"));
                fornecedor.setStatus(StatusCTRL.BuscaPorId(rs.getInt("Status")));
                fornecedor.setCEP(rs.getString("CEP"));
                fornecedor.setLogradouro(rs.getString("Logradouro"));
                fornecedor.setComplemento(rs.getString("Complemento"));
                fornecedor.setEnderecoNumero(rs.getString("EnderecoNumero"));
                fornecedor.setBairro(rs.getString("Bairro"));
                fornecedor.setCidade(rs.getString("Cidade"));
                fornecedor.setUF(Enumeradors.UF.valueOf(rs.getString("UF")));
                fornecedor.setFone(rs.getString("Fone"));
                fornecedor.setEmail(rs.getString("Email"));
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar buscar Fornecedor: " + e);
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return fornecedores;
    }

    public Fornecedor GetById(int i) {
        return this.GetAll(0, i, "", false).get(0);
    }

    public List<Fornecedor> GetByName(String name, int limite) {
        return this.GetAll(limite, 0, name, false);
    }

    public Fornecedor GetLastRecord() {
        return this.GetAll(0, 0, "", true).get(0);
    }

    public void Delete(int id) {
        Utilitarios.ExcluirObjetos(id, Fornecedor.class);
    }

    public Fornecedor Persists(Fornecedor fornecedor) {

        try {
            con = DataConnection.getConnection();
            String CmdSQL
                    = fornecedor.IsNew()
                    ? "insert into Fornecedor\n"
                    + "set NomeFantasia = ?\n"
                    + " , RazaoSocial = ?\n"
                    + " , CNPJ = ?\n"
                    + " , IE = ?\n"
                    + " , IM = ?\n"
                    + " , Status = ?\n"
                    + " , CEP = ?\n"
                    + " , Logradouro = ?\n"
                    + " , Complemento = ?\n"
                    + " , EnderecoNumero = ?\n"
                    + " , Bairro = ?\n"
                    + " , Cidade = ?\n"
                    + " , UF = ?\n"
                    + " , Fone = ?\n"
                    + " , Email = ?"
                    : "update Fornecedor\n"
                    + "set NomeFantasia = ?\n"
                    + " , RazaoSocial = ?\n"
                    + " , CNPJ = ?\n"
                    + " , IE = ?\n"
                    + " , IM = ?\n"
                    + " , Status = ?\n"
                    + " , CEP = ?\n"
                    + " , Logradouro = ?\n"
                    + " , Complemento = ?\n"
                    + " , EnderecoNumero = ?\n"
                    + " , Bairro = ?\n"
                    + " , Cidade = ?\n"
                    + " , UF = ?\n"
                    + " , Fone = ?\n"
                    + " , Email = ?\n"
                    + " where Id = ?";
            stmt = con.prepareStatement(CmdSQL);
            int ii = 1;
            stmt.setString(ii++, fornecedor.getNomeFantasia());
            stmt.setString(ii++, fornecedor.getRazaoSocial());
            stmt.setString(ii++, fornecedor.getCNPJ());
            stmt.setString(ii++, fornecedor.getIE());
            stmt.setString(ii++, fornecedor.getIM());
            stmt.setInt(ii++, fornecedor.getStatus().getId());
            stmt.setString(ii++, fornecedor.getCEP());
            stmt.setString(ii++, fornecedor.getLogradouro());
            stmt.setString(ii++, fornecedor.getComplemento());
            stmt.setString(ii++, fornecedor.getEnderecoNumero());
            stmt.setString(ii++, fornecedor.getBairro());
            stmt.setString(ii++, fornecedor.getCidade());
            stmt.setString(ii++, fornecedor.getUF().toString());
            stmt.setString(ii++, fornecedor.getFone());
            stmt.setString(ii++, fornecedor.getEmail());
            if (!fornecedor.IsNew()) {
                stmt.setInt(ii++, fornecedor.getId());
            }
            stmt.executeUpdate();
            Utilitarios.MsgSucesso();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao tentar Persistir (" + (fornecedor.IsNew() ? "insert" : "update") + ") Fornecedor: " + e);
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        return fornecedor.IsNew() ? this.GetLastRecord() : fornecedor;
    }
}
