/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

public class NhanVien {

    private String maNhanVien;
    private String matKhau;
    private boolean vaiTro;
    private String hoTen;
    private String diaChi;
    private String SDT;
    private String email;

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String matKhau, boolean vaiTro, String hoTen, String diaChi, String SDT, String email) {
        this.maNhanVien = maNhanVien;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", SDT=" + SDT + ", email=" + email + '}';
    }

    


}
