/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author 20002 Dec 16, 2021 12:36:55 PM
 */
public class MonHoc {

    private String maMH;
    private String tenMH;
    private String maChuyenNganh;
    private String hocKy;
    private String soTinChi;
    private String hinhThucThi;
    private String batBuoc;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, String maChuyenNganh, String hocKy, String soTinChi, String hinhThucThi,
            String batBuoc) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.maChuyenNganh = maChuyenNganh;
        this.hocKy = hocKy;
        this.soTinChi = soTinChi;
        this.hinhThucThi = hinhThucThi;
        this.batBuoc = batBuoc;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getMaChuyenNganh() {
        return maChuyenNganh;
    }

    public void setMaChuyenNganh(String maChuyenNganh) {
        this.maChuyenNganh = maChuyenNganh;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public String getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(String soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getBatBuoc() {
        return batBuoc;
    }

    public void setBatBuoc(String batBuoc) {
        this.batBuoc = batBuoc;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        this.hinhThucThi = hinhThucThi;
    }

    @Override
    public String toString() {
        return "MonHoc:" + maMH + ", " + tenMH + ", " + maChuyenNganh + ", " + hocKy + ", " + soTinChi + ", "
                + hinhThucThi + ", " + batBuoc;
    }

}
