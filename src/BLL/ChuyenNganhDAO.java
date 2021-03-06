/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DataAccess.DBConnect;
import Entity.ChuyenNganh;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20002 Dec 16, 2021 12:43:24 PM
 */
public class ChuyenNganhDAO implements IChuyenNganhDAO {

    @Override
    public ArrayList<ChuyenNganh> getAll() {
        ArrayList<ChuyenNganh> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from tblChuyenNganh");
                rs = ps.executeQuery();
                list = new ArrayList<ChuyenNganh>();
                while (rs.next()) {
                    ChuyenNganh cn = new ChuyenNganh();
                    cn.setMaChuyenNganh(rs.getString(1));
                    cn.setTenChuyenNganh(rs.getString(2));
                    cn.setMaKhoa(rs.getString(3));
                    list.add(cn);
                    try {
                        FileWriter writer = new FileWriter("chuyenNganh.csv");
                        for (ChuyenNganh chuyenNganh1 : list) {
                            writer.write(chuyenNganh1.toString() + "\n");
                        }
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("An error occured");
                        e.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }

        }
        return list;
    }

    @Override
    public ChuyenNganh addNew(ChuyenNganh ChuyenNganh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO tblChuyenNganh values (?,?,?)");
                ps.setString(1, ChuyenNganh.getMaChuyenNganh());
                ps.setString(2, ChuyenNganh.getTenChuyenNganh());
                ps.setString(3, ChuyenNganh.getMaKhoa());
                int row = ps.executeUpdate();
                if (row < 1) {
                    ChuyenNganh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
                ChuyenNganh = null;
            } finally {
                DBConnect.close(ps);
            }
        }
        return ChuyenNganh;
    }

    @Override
    public ChuyenNganh updateByID(ChuyenNganh ChuyenNganh) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement(
                        "update tblChuyenNganh set fldTenChuyenNganh =?, fldMaKhoa = ? where fldMaChuyenNganh = ?");

                ps.setString(1, ChuyenNganh.getTenChuyenNganh());
                ps.setString(2, ChuyenNganh.getMaKhoa());
                ps.setString(3, ChuyenNganh.getMaChuyenNganh());
                int row = ps.executeUpdate();
                if (row < 1) {
                    ChuyenNganh = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
                ChuyenNganh = null;
            } finally {
                DBConnect.close();
            }
        }
        return ChuyenNganh;
    }

    public void deleteChuyenNganh(String ChuyenNganhID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from tblChuyenNganh where fldMaChuyenNganh = ?");
            ps.setString(1, ChuyenNganhID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<ChuyenNganh> checkID(String maChuyenNganh) {
        ArrayList<ChuyenNganh> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from tblChuyenNganh where fldMaChuyenNganh = ?");
                psCheck.setString(1, maChuyenNganh);
                rs = psCheck.executeQuery();
                list = new ArrayList<ChuyenNganh>();
                while (rs.next()) {
                    ChuyenNganh k = new ChuyenNganh();
                    k.setMaChuyenNganh(rs.getString(1));
                    list.add(k);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenNganhDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }

        }
        return list;
    }

}
