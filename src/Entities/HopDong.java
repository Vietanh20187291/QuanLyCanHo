/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



public class HopDong {
    private String maHopDong;
    private String tenKH;
    private String ngayGiaoDich;
    private String diaChiKhachHang;
    private String maCuDan;
    private String maCanHo;
    private long gia;
    private long daThanhToan;
    private String thoiHan;
    private String maNhanVien;
    private int soDot;
    private long coc;

    public HopDong() {
    }

    public HopDong(String maHopDong, String tenKH, String ngayGiaoDich, String diaChiKhachHang, String maCuDan, String maCanHo, long gia, long daThanhToan, String thoiHan, String maNhanVien, int soDot, long coc) {
        this.maHopDong = maHopDong;
        this.tenKH = tenKH;
        this.ngayGiaoDich = ngayGiaoDich;
        this.diaChiKhachHang = diaChiKhachHang;
        this.maCuDan = maCuDan;
        this.maCanHo = maCanHo;
        this.gia = gia;
        this.daThanhToan = daThanhToan;
        this.thoiHan = thoiHan;
        this.maNhanVien = maNhanVien;
        this.soDot = soDot;
        this.coc = coc;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getDiaChiKhachHang() {
        return diaChiKhachHang;
    }

    public String getMaCuDan() {
        return maCuDan;
    }

    public String getMaCanHo() {
        return maCanHo;
    }

    public long getGia() {
        return gia;
    }

    public long getDaThanhToan() {
        return daThanhToan;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public int getSoDot() {
        return soDot;
    }

    public long getCoc() {
        return coc;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setDiaChiKhachHang(String diaChiKhachHang) {
        this.diaChiKhachHang = diaChiKhachHang;
    }

    public void setMaCuDan(String maCuDan) {
        this.maCuDan = maCuDan;
    }

    public void setMaCanHo(String maCanHo) {
        this.maCanHo = maCanHo;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public void setDaThanhToan(long daThanhToan) {
        this.daThanhToan = daThanhToan;
    }

    public void setThoiHan(String thoiHan) {
        this.thoiHan = thoiHan;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setSoDot(int soDot) {
        this.soDot = soDot;
    }

    public void setCoc(long coc) {
        this.coc = coc;
    }

    @Override
    public String toString() {
        return "HopDong{" + "maHopDong=" + maHopDong + ", tenKH=" + tenKH + ", ngayGiaoDich=" + ngayGiaoDich + ", diaChiKhachHang=" + diaChiKhachHang + ", maCuDan=" + maCuDan + ", maCanHo=" + maCanHo + ", gia=" + gia + ", daThanhToan=" + daThanhToan + ", thoiHan=" + thoiHan + ", maNhanVien=" + maNhanVien + ", soDot=" + soDot + ", coc=" + coc + '}';
    }





    
}
