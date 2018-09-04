package model.dao;

import connection.DataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.IrradiacaoGlobalMes;
import utils.Utilitarios;

public class IrradiacaoGlobalMesDAO {

    private boolean onlyLastRecord = false;

    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public boolean isOnlyLastRecord() {
        return onlyLastRecord;
    }

    public void setOnlyLastRecord(boolean onlyLastRecord) {
        this.onlyLastRecord = onlyLastRecord;
    }

    public List<IrradiacaoGlobalMes> GetAll(int pMaxRecordResult, double pLatitude, double pLongitude, int pID) {
        List<IrradiacaoGlobalMes> IGMs = new ArrayList<>();

        try {
            con = DataConnection.getConnection();
            String SelectCMD = "select "
                    + "Id"
                    + ", Latitude"
                    + ",  Longitude"
                    + ",  Janeiro"
                    + ",  Fevereiro"
                    + ",  Marco"
                    + ",  Abril"
                    + ",  Maio"
                    + ",  Junho"
                    + ",  Julho"
                    + ",  Agosto"
                    + ",  Setembro"
                    + ",  Outubro"
                    + ",  Novembro"
                    + ",  Dezembro"
                    + ",  Anual"
                    + ",  Primavera"
                    + ",  Verao"
                    + ",  Outono"
                    + ",  Inverno"
                    + ",  Ano "
                    + "from IrradiacaoGlobalMes "
                    + "where Id > 0 ";

            if (pLatitude != 0 && pLongitude != 0) {
//                SelectCMD += "and igm.Latitude between ? and ?\n"
//                        + "and igm.Longitude between ? and ?\n";
//                stmt.setDouble(1, pLatitude - 1);
//                stmt.setDouble(2, pLatitude + 1);
//                stmt.setDouble(3, pLongitude - 1);
//                stmt.setDouble(4, pLongitude + 1);

//                SelectCMD += " and Latitude >= ? and Longitude >= ? ";
                SelectCMD += " and Latitude >= " + pLatitude + " and Longitude >= " + pLongitude + " ";
                SelectCMD += " order by Latitude, Longitude ";
                stmt = con.prepareStatement(SelectCMD);
//                stmt.setDouble(1, pLatitude);
//                stmt.setDouble(2, pLongitude);
            } else if (this.isOnlyLastRecord()) {
                stmt = con.prepareStatement(SelectCMD.concat(" order by Id desc limit 1 "));
            } else if (pID > 0) {
                SelectCMD += " and Id = " + pID + " ";
                stmt = con.prepareStatement(SelectCMD);
            }
            SelectCMD += pMaxRecordResult > 0 ? " limit " + pMaxRecordResult : "";
            stmt = con.prepareStatement(SelectCMD);
//            System.out.println(SelectCMD + " ! Param(1): " + pLatitude + "  Param(2): " + pLongitude);
            rs = stmt.executeQuery();
            while (rs.next()) {
                IGMs.add(
                        new IrradiacaoGlobalMes(
                                rs.getInt("Id"),
                                rs.getDouble("Latitude"),
                                rs.getDouble("Longitude"),
                                rs.getDouble("Janeiro"),
                                rs.getDouble("Fevereiro"),
                                rs.getDouble("Marco"),
                                rs.getDouble("Abril"),
                                rs.getDouble("Maio"),
                                rs.getDouble("Junho"),
                                rs.getDouble("Julho"),
                                rs.getDouble("Agosto"),
                                rs.getDouble("Setembro"),
                                rs.getDouble("Outubro"),
                                rs.getDouble("Novembro"),
                                rs.getDouble("Dezembro"),
                                rs.getDouble("Anual"),
                                rs.getDouble("Primavera"),
                                rs.getDouble("Verao"),
                                rs.getDouble("Outono"),
                                rs.getDouble("Inverno"),
                                rs.getInt("Ano")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar IrradiacaoGlobalMes: " + e);
        } finally {
            DataConnection.closeConnection(con, stmt, rs);
        }

        if (IGMs.isEmpty()) {
            IGMs.add(new IrradiacaoGlobalMes());
        }

        return IGMs;
    }

    public IrradiacaoGlobalMes GetByID(int pId) {
        return this.GetAll(0, 0, 0, pId).get(0);
    }

    public IrradiacaoGlobalMes Insert(IrradiacaoGlobalMes igm) {
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("insert into IrradiacaoGlobalMes set Latitude = ?,  Longitude = ?,  Janeiro = ?,  Fevereiro = ?,  Marco = ?,  Abril = ?,  Maio = ?,  Junho = ?,  Julho = ?,  Agosto = ?,  Setembro = ?,  Outubro = ?,  Novembro = ?,  Dezembro = ?,  Anual = ?,  Primavera = ?,  Verao = ?,  Outono = ?,  Inverno = ?,  Ano = ?;");
            int i = 1;
            stmt.setDouble(i++, igm.getLatitude());
            stmt.setDouble(i++, igm.getLongitude());
            stmt.setDouble(i++, igm.getJaneiro());
            stmt.setDouble(i++, igm.getFevereiro());
            stmt.setDouble(i++, igm.getMarco());
            stmt.setDouble(i++, igm.getAbril());
            stmt.setDouble(i++, igm.getMaio());
            stmt.setDouble(i++, igm.getJunho());
            stmt.setDouble(i++, igm.getJulho());
            stmt.setDouble(i++, igm.getAgosto());
            stmt.setDouble(i++, igm.getSetembro());
            stmt.setDouble(i++, igm.getOutubro());
            stmt.setDouble(i++, igm.getNovembro());
            stmt.setDouble(i++, igm.getDezembro());
            stmt.setDouble(i++, igm.getAnual());
            stmt.setDouble(i++, igm.getPrimavera());
            stmt.setDouble(i++, igm.getVerao());
            stmt.setDouble(i++, igm.getOutono());
            stmt.setDouble(i++, igm.getInverno());
            stmt.setInt(i++, igm.getAno());
            stmt.execute();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao incluir IrradiacaoGlobalMes: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }

        this.setOnlyLastRecord(true);
        return this.GetAll(1, 0, 0, 0).get(0);
    }

    public IrradiacaoGlobalMes Update(IrradiacaoGlobalMes igm) {
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("update IrradiacaoGlobalMes set Latitude = ?,  Longitude = ?,  Janeiro = ?,  Fevereiro = ?,  Marco = ?,  Abril = ?,  Maio = ?,  Junho = ?,  Julho = ?,  Agosto = ?,  Setembro = ?,  Outubro = ?,  Novembro = ?,  Dezembro = ?,  Anual = ?,  Primavera = ?,  Verao = ?,  Outono = ?,  Inverno = ?,  Ano = ? where Id = ?;");
            int i = 1;
            stmt.setDouble(i++, igm.getLatitude());
            stmt.setDouble(i++, igm.getLongitude());
            stmt.setDouble(i++, igm.getJaneiro());
            stmt.setDouble(i++, igm.getFevereiro());
            stmt.setDouble(i++, igm.getMarco());
            stmt.setDouble(i++, igm.getAbril());
            stmt.setDouble(i++, igm.getMaio());
            stmt.setDouble(i++, igm.getJunho());
            stmt.setDouble(i++, igm.getJulho());
            stmt.setDouble(i++, igm.getAgosto());
            stmt.setDouble(i++, igm.getSetembro());
            stmt.setDouble(i++, igm.getOutubro());
            stmt.setDouble(i++, igm.getNovembro());
            stmt.setDouble(i++, igm.getDezembro());
            stmt.setDouble(i++, igm.getAnual());
            stmt.setDouble(i++, igm.getPrimavera());
            stmt.setDouble(i++, igm.getVerao());
            stmt.setDouble(i++, igm.getOutono());
            stmt.setDouble(i++, igm.getInverno());
            stmt.setDouble(i++, igm.getAno());
            stmt.setInt(i++, igm.getId());
        } catch (SQLException e) {
            Utilitarios.MsgExcecao("Erro ao Atualizar IrradiacaoGlobalMes: " + e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
        return igm;
    }

    public IrradiacaoGlobalMes GetByCoordenadas(double pLatitude, double pLongitude) {
        IrradiacaoGlobalMes i = this.GetAll(0, pLatitude, pLongitude, 0).get(0);
        return i.getId() > 0 ? i : null;
    }
}
