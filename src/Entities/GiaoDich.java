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
public class GiaoDich {
    private String maGiaoDich;
    private long ngayGiaoDich;
    private long soTien;
    private String maDotTT;
    private String maNhanVien;
    private String tenNhanVien;
    private String maHopDong;
    private String maKhachHang;

    public GiaoDich() {
    }

    public GiaoDich(String maGiaoDich, long ngayGiaoDich, long soTien, String maDotTT, String maNhanVien, String tenNhanVien, String maHopDong, String maKhachHang) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.soTien = soTien;
        this.maDotTT = maDotTT;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maHopDong = maHopDong;
        this.maKhachHang = maKhachHang;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public long getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public long getSoTien() {
        return soTien;
    }

    public String getMaDotTT() {
        return maDotTT;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public void setNgayGiaoDich(long ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setSoTien(long soTien) {
        this.soTien = soTien;
    }

    public void setMaDotTT(String maDotTT) {
        this.maDotTT = maDotTT;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    
    
}
