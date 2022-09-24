/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Vanh
 */
public class DotThanhToan {

    private String maDot;
    private int DotSo;
    private long soTienDuKien;
    private long thoiHan;
    private long soTienDaTra;
    private String maHopDong;
    private long soTienThieu;
    private String maNhanVien;
    private String tenNhanVien;
    private String maKhachHang;
    private long phiNopMuon;

    public DotThanhToan() {
    }

    public DotThanhToan(String maDot, int DotSo, long soTienDuKien, long thoiHan, long soTienDaTra, String maHopDong, long soTienThieu, String maNhanVien, String tenNhanVien, String maKhachHang, long phiNopMuon) {
        this.maDot = maDot;
        this.DotSo = DotSo;
        this.soTienDuKien = soTienDuKien;
        this.thoiHan = thoiHan;
        this.soTienDaTra = soTienDaTra;
        this.maHopDong = maHopDong;
        this.soTienThieu = soTienThieu;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maKhachHang = maKhachHang;
        this.phiNopMuon = phiNopMuon;
    }

    public String getMaDot() {
        return maDot;
    }

    public int getDotSo() {
        return DotSo;
    }

    public long getSoTienDuKien() {
        return soTienDuKien;
    }

    public long getThoiHan() {
        return thoiHan;
    }

    public long getSoTienDaTra() {
        return soTienDaTra;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public long getSoTienThieu() {
        return soTienThieu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public long getPhiNopMuon() {
        return phiNopMuon;
    }

    public void setMaDot(String maDot) {
        this.maDot = maDot;
    }

    public void setDotSo(int DotSo) {
        this.DotSo = DotSo;
    }

    public void setSoTienDuKien(long soTienDuKien) {
        this.soTienDuKien = soTienDuKien;
    }

    public void setThoiHan(long thoiHan) {
        this.thoiHan = thoiHan;
    }

    public void setSoTienDaTra(long soTienDaTra) {
        this.soTienDaTra = soTienDaTra;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public void setSoTienThieu(long soTienThieu) {
        this.soTienThieu = soTienThieu;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setPhiNopMuon(long phiNopMuon) {
        this.phiNopMuon = phiNopMuon;
    }

   
    

}
