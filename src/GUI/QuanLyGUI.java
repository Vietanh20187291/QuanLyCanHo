/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.KhuCanHoBLL;
import BLL.*;
import DAL.QuanLyCuDanDAL;
import DAL.QuanLyHopDongDAL;
import DAL.ThongTinCanHoDAL;
import Entities.CanHo;
import Entities.CuDan;
import Entities.HopDong;
import Entities.NhanVien;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class QuanLyGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyGUI
     */
    DefaultTableModel dtmCuDan = new DefaultTableModel();
    public static QuanLyGUI it;

    public QuanLyGUI() {

        initComponents();
        it = this; //Sử dụng biến static trỏ đến đối tượng của QuanLyGUI
        show_KhuCanHo();
        show_CanHo();
        showCuDan();
        showThongTinMuaBan();
        showCanHoDaBan();
        show_TaiKhoan();
        showDTT();
        showGiaoDich();
        pnChange.setVisible(false);

    }

    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table

    public void enabledFrame() {
        this.setEnabled(true);
    }// hàm cho phép thao tác trên frame này

    public void clearAllControl_KhuCanHo() {
        txbSoTang.setText("");
        txbSoCanTT.setText("");
        txbDiaChi.setText("");
        txbTenKhu.setText("");
    }

    public void clearAllControl_CanHo() {
        txbSoPhong.setText("");
        txbGia.setText("");
        txbDienTich.setText("");
        txbMaCuDan.setText("");
        txbTenKhu_CanHo.setText("");
    }

    public void clearAllControl_TaiKhoanNV() {
        txtMaNV.setText("");
        txtHoTenNV.setText("");
        txtEmailNV.setText("");
        txtDiaChiNV.setText("");
        txtSDTNV.setText("");
        txtEmailNV.setText("");
    }

    public void clearAllControl_TaiKhoanQL() {
        txbTenTK_QL_New.setText("");
        txbMK_QL_New.setText("");
        txbMK_QL_Confirm.setText("");
    }

    public void show_KhuCanHo() {

        tbKhu.setModel(KhuCanHoBLL.show()); // load data to table
        renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
        tbKhu.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String

        cbbMaKhu.setModel(KhuCanHoBLL.cbb_show()); //load data to combobox
    }

    public void showDTT() throws ParseException {
        renderer.setHorizontalAlignment(JLabel.CENTER);//
        BLL.DotThanhToanBLL.show(tblDotThanhToan);
        tblDotThanhToan.setDefaultRenderer(Object.class, renderer);

    }

    public void showGiaoDich() {
        renderer.setHorizontalAlignment(JLabel.CENTER);//
        BLL.GiaoDichBLL.show(tblGiaoDich);
        tblGiaoDich.setDefaultRenderer(Object.class, renderer);
    }

    public void show_CanHo() {

        tbCanHo.setModel(CanHoBLL.show());
        renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
        tbCanHo.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String

        cbbMaCanHo.setModel(CanHoBLL.cbb_show());
    }

    private void show_TaiKhoan() {

        tbTaiKhoan.setModel(NhanVienBLL.show());
        renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
        tbTaiKhoan.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String
    }

    private void showCuDan() {
        try {

            renderer.setHorizontalAlignment(JLabel.CENTER);//
            tblCuDan.setModel(new DefaultTableModel(null, new String[]{}));
            BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblCuDan);
            tblCuDan.setDefaultRenderer(Object.class, renderer);

        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showThongTinMuaBan() {
        try {
            renderer.setHorizontalAlignment(JLabel.CENTER);//
            HopDongBLL thongTinMuaBan = new HopDongBLL();
            thongTinMuaBan.HienThongTinMuaBan(tblMuaBan);
            cbbMaCuDanMuaBan.setModel(QuanLyCuDanBLL.cbbMaCuDan());
            cbbMaCanHoMuaBan.removeAllItems();
            cbbMaCanHoMuaBan.setModel(ThongTinCanHoBLL.cbbMaCanHo());

        } catch (Exception ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showCanHoDaBan() {
        try {
            renderer.setHorizontalAlignment(JLabel.CENTER);//
            ThongTinCanHoBLL thongTinCanHo = new ThongTinCanHoBLL();
            thongTinCanHo.hienThiCanHoDaBan(tblDsCanHoDaBan);
            txtTongDoanhThu.setText(convertMoney(HopDongBLL.doanhThu()).trim() + "\tVND");
            txtTongGiaCH.setText(convertMoney(HopDongBLL.tongGiaTriCH()).trim() + "\tVND");
            txtSoCanDaBan.setText(String.valueOf(tblMuaBan.getRowCount()));
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txbTenKhu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txbSoTang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txbSoCanTT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txbDiaChi = new javax.swing.JTextField();
        btThem_Khu = new javax.swing.JButton();
        btSua_Khu = new javax.swing.JButton();
        btXoa_Khu = new javax.swing.JButton();
        txbTimKiem1 = new javax.swing.JTextField();
        cbbMaKhu = new javax.swing.JComboBox<>();
        btViewAllArea = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCanHo = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbbMaCanHo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txbDienTich = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txbGia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txbMaCuDan = new javax.swing.JTextField();
        txbTenKhu_CanHo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txbSoPhong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btSua_CanHo = new javax.swing.JButton();
        btViewAllApartment = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btTim_CanHo = new javax.swing.JButton();
        cbTrangThai = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        cbbDienTich = new javax.swing.JComboBox<>();
        cbbGia = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTablePanel2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        btThem_NV = new javax.swing.JButton();
        btXoa_NV = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtHoTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        btSua_NV = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtDiaChiNV = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        pnChangeInfo = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btTiepTuc = new javax.swing.JButton();
        pnChange = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txbTenTK_QL_New = new javax.swing.JTextField();
        txbMK_QL_New = new javax.swing.JPasswordField();
        txbMK_QL_Confirm = new javax.swing.JPasswordField();
        btLuu_QL = new javax.swing.JButton();
        btThoat_QL = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTaiKhoan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtMaHopDong = new javax.swing.JTextField();
        txtNgayGiaoDich = new javax.swing.JTextField();
        txtDiaChiKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        cbbMaCanHoMuaBan = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        cbbMaCuDanMuaBan = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        txtDaThanhToan = new javax.swing.JTextField();
        jButtonMoHD = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMuaBan = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextFieldTimMuaBan = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnThongTin = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMaCuDan = new javax.swing.JTextField();
        txtTenCuDan = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCMT = new javax.swing.JTextField();
        txtQueQuan = new javax.swing.JTextField();
        cbbGioiTinh = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCuDan = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTaiLai = new javax.swing.JButton();
        BtnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButtonXoacd = new javax.swing.JButton();
        tblCanHoDaBan = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDsCanHoDaBan = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        txtTongDoanhThu = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtSoCanDaBan = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtTongGiaCH = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        tabDotThanhToan = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDotThanhToan = new javax.swing.JTable();
        jButtonIncomming = new javax.swing.JButton();
        jButtonlate = new javax.swing.JButton();
        jButtonReload = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jTextFieldTimDtt = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        tabGiaoDich = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblGiaoDich = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        jTextFieldGD = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtMaGD = new javax.swing.JTextField();
        jButtonMoGD = new javax.swing.JButton();
        btDangXuat = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Quản Lý");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/managerIcon.png"))); // NOI18N

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 162));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 162));
        jLabel2.setText("Mã Khu");

        txbTenKhu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 162));
        jLabel3.setText("Tên Khu");

        txbSoTang.setEditable(false);
        txbSoTang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 162));
        jLabel4.setText("Số Tầng");

        txbSoCanTT.setEditable(false);
        txbSoCanTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbSoCanTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbSoCanTTActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 162));
        jLabel5.setText("Số Căn/tầng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 162));
        jLabel6.setText("Loại Căn Hộ");

        txbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btThem_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btThem_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add_ql.png"))); // NOI18N
        btThem_Khu.setToolTipText("Thêm khu mới");
        btThem_Khu.setPreferredSize(new java.awt.Dimension(24, 24));
        btThem_Khu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThem_KhuActionPerformed(evt);
            }
        });

        btSua_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btSua_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit_ql.png"))); // NOI18N
        btSua_Khu.setToolTipText("Sửa thông tin khu");
        btSua_Khu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSua_KhuActionPerformed(evt);
            }
        });

        btXoa_Khu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btXoa_Khu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/remove_ql.png"))); // NOI18N
        btXoa_Khu.setToolTipText("Xóa khu");
        btXoa_Khu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoa_KhuActionPerformed(evt);
            }
        });

        txbTimKiem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txbTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbTimKiem1ActionPerformed(evt);
            }
        });
        txbTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbTimKiem1KeyReleased(evt);
            }
        });

        cbbMaKhu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbMaKhu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaKhuActionPerformed(evt);
            }
        });

        btViewAllArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btViewAllArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/viewAll_ql.png"))); // NOI18N
        btViewAllArea.setToolTipText("Xem thông tin tất cả các khu");
        btViewAllArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewAllAreaActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 162));
        jLabel31.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txbTenKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMaKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txbSoTang, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbSoCanTT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSua_Khu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btXoa_Khu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThem_Khu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txbTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addComponent(btViewAllArea, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txbTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btViewAllArea))
                .addGap(66, 66, 66)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btThem_Khu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbMaKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txbSoTang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txbSoCanTT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btSua_Khu)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txbTenKhu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btXoa_Khu))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        tbKhu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbKhu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khu", "Tên Khu", "Số Tầng", "Số căn/tầng", "Loại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhu.setToolTipText("");
        tbKhu.getTableHeader().setReorderingAllowed(false);
        tbKhu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhu);
        if (tbKhu.getColumnModel().getColumnCount() > 0) {
            tbKhu.getColumnModel().getColumn(0).setResizable(false);
            tbKhu.getColumnModel().getColumn(1).setResizable(false);
            tbKhu.getColumnModel().getColumn(2).setResizable(false);
            tbKhu.getColumnModel().getColumn(3).setResizable(false);
            tbKhu.getColumnModel().getColumn(4).setResizable(false);
            tbKhu.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khu Căn Hộ", jPanel2);

        tbCanHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Căn Hộ", "Diện Tích", "Giá", "Trạng Thái", "Số Phòng", "Mã Cư Dân", "Khu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbCanHo.setVerifyInputWhenFocusTarget(false);
        tbCanHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCanHoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbCanHo);

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 162));
        jLabel7.setText("Mã Căn Hộ");

        cbbMaCanHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbMaCanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaCanHoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 162));
        jLabel8.setText("Diện Tích");

        txbDienTich.setEditable(false);
        txbDienTich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 162));
        jLabel9.setText("Giá");

        txbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 162));
        jLabel10.setText("Mã Cư Dân");

        txbMaCuDan.setEditable(false);
        txbMaCuDan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txbTenKhu_CanHo.setEditable(false);
        txbTenKhu_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 162));
        jLabel11.setText("Khu");

        txbSoPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 162));
        jLabel12.setText("Số Phòng");

        btSua_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btSua_CanHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit_ql.png"))); // NOI18N
        btSua_CanHo.setToolTipText("Sửa thông tin căn hộ");
        btSua_CanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSua_CanHoActionPerformed(evt);
            }
        });

        btViewAllApartment.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btViewAllApartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        btViewAllApartment.setToolTipText("Xem thông tin tất cả các căn hộ");
        btViewAllApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewAllApartmentActionPerformed(evt);
            }
        });

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btTim_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btTim_CanHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search_ql.png"))); // NOI18N
        btTim_CanHo.setToolTipText("Tìm căn hộ theo chỉ tiêu");
        btTim_CanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTim_CanHoActionPerformed(evt);
            }
        });

        cbTrangThai.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 162));
        jLabel13.setText("Diện tích");

        cbbDienTich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbDienTich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dưới 50m²", "Từ 50m² - 100 m²", "Trên 100m²" }));
        cbbDienTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDienTichActionPerformed(evt);
            }
        });

        cbbGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dưới 1 tỷ", "Từ 1 tỷ - 2 tỷ", "Trên 2 tỷ" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 162));
        jLabel15.setText("Giá");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 162));
        jLabel35.setText("Đã bán");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cbbGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTrangThai)
                .addGap(75, 75, 75)
                .addComponent(btTim_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btTim_CanHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTrangThai)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btViewAllApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txbSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(70, 70, 70)
                                .addComponent(txbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txbTenKhu_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txbMaCuDan, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(329, 329, 329))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txbGia)
                            .addComponent(cbbMaCanHo, 0, 217, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSua_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btViewAllApartment))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btSua_CanHo))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(3, 3, 3))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cbbMaCanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbGia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txbMaCuDan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txbSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(txbTenKhu_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Căn Hộ", jPanel3);

        jTablePanel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btThem_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btThem_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adduser.png"))); // NOI18N
        btThem_NV.setToolTipText("Thêm tài khoản mới");
        btThem_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThem_NVActionPerformed(evt);
            }
        });

        btXoa_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btXoa_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/removeuser.png"))); // NOI18N
        btXoa_NV.setToolTipText("Xóa");
        btXoa_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoa_NVActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 162));
        jLabel19.setText("Mã Nhân Viên:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 162));
        jLabel20.setText("Họ Tên:");

        txtHoTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEmailNV.setEditable(false);
        txtEmailNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btSua_NV.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btSua_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edituser.png"))); // NOI18N
        btSua_NV.setToolTipText("Sửa mật khẩu");
        btSua_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSua_NVActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 162));
        jLabel43.setText("Địa Chỉ :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 162));
        jLabel44.setText("SĐT:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 162));
        jLabel45.setText("Email:");

        txtDiaChiNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaNVKeyReleased(evt);
            }
        });

        txtSDTNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btXoa_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(55, 217, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDTNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(btThem_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btSua_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(259, 259, 259))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel44)
                                            .addComponent(jLabel45))
                                        .addGap(64, 64, 64)
                                        .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(19, 19, 19))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btXoa_NV)
                .addGap(9, 9, 9)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addGap(47, 47, 47)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSua_NV)
                    .addComponent(btThem_NV))
                .addGap(52, 281, Short.MAX_VALUE))
        );

        jTablePanel2.addTab("Nhân Viên", jPanel10);

        jLabel33.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 51, 51));
        jLabel33.setText("THAY ĐỔI TÀI KHOẢN ADMIN");

        btTiepTuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/continue_ql.png"))); // NOI18N
        btTiepTuc.setToolTipText("Tiếp tục");
        btTiepTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTiepTucActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 162));
        jLabel16.setText("Xác nhận mật khẩu mới");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 162));
        jLabel32.setText("Mật khẩu mới");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 162));
        jLabel34.setText("Tên tài khoản mới");

        txbTenTK_QL_New.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txbMK_QL_New.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txbMK_QL_Confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btLuu_QL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btLuu_QL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_ql.png"))); // NOI18N
        btLuu_QL.setToolTipText("Lưu");
        btLuu_QL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuu_QLActionPerformed(evt);
            }
        });

        btThoat_QL.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btThoat_QL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel_ql.png"))); // NOI18N
        btThoat_QL.setToolTipText("Hủy");
        btThoat_QL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoat_QLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChangeLayout = new javax.swing.GroupLayout(pnChange);
        pnChange.setLayout(pnChangeLayout);
        pnChangeLayout.setHorizontalGroup(
            pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel16)
                    .addComponent(jLabel34))
                .addGap(61, 61, 61)
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txbMK_QL_New, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txbTenTK_QL_New, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txbMK_QL_Confirm))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btLuu_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btThoat_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        pnChangeLayout.setVerticalGroup(
            pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbTenTK_QL_New, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txbMK_QL_New, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txbMK_QL_Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLuu_QL)
                    .addComponent(btThoat_QL))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnChangeInfoLayout = new javax.swing.GroupLayout(pnChangeInfo);
        pnChangeInfo.setLayout(pnChangeInfoLayout);
        pnChangeInfoLayout.setHorizontalGroup(
            pnChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangeInfoLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(pnChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeInfoLayout.createSequentialGroup()
                        .addComponent(pnChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeInfoLayout.createSequentialGroup()
                        .addComponent(btTiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChangeInfoLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(84, 84, 84))))
        );
        pnChangeInfoLayout.setVerticalGroup(
            pnChangeInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangeInfoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btTiepTuc)
                .addGap(58, 58, 58)
                .addComponent(pnChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChangeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChangeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTablePanel2.addTab("Quản Lý", jPanel11);

        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Tài Khoản", "Mật Khẩu"
            }
        ));
        tbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbTaiKhoanMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbTaiKhoan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTablePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jTablePanel2)
        );

        jTabbedPane1.addTab("Tài Khoản", jPanel4);

        jLabel25.setText("Mã hợp đồng");

        jLabel26.setText("Ngày giao dịch");

        jLabel27.setText("Giá thỏa thuận");

        jLabel29.setText("Mã căn hộ");

        jLabel30.setText("Tên khách hàng");

        txtMaHopDong.setEditable(false);
        txtMaHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHopDongActionPerformed(evt);
            }
        });

        txtNgayGiaoDich.setEditable(false);
        txtNgayGiaoDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayGiaoDichActionPerformed(evt);
            }
        });

        txtDiaChiKhachHang.setEditable(false);

        txtTenKhachHang.setEditable(false);

        cbbMaCanHoMuaBan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaCanHoMuaBan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaCanHoMuaBanItemStateChanged(evt);
            }
        });
        cbbMaCanHoMuaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbMaCanHoMuaBanMouseClicked(evt);
            }
        });

        jLabel38.setText("Mã cư dân");

        cbbMaCuDanMuaBan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel40.setText("Đã Trả");

        txtDaThanhToan.setEditable(false);
        txtDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaThanhToanActionPerformed(evt);
            }
        });

        jButtonMoHD.setText("Mở Hợp Đồng");
        jButtonMoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(50, 50, 50))
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaCanHoMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiaChiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(cbbMaCuDanMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayGiaoDich, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButtonMoHD)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaCanHoMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jButtonMoHD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbMaCuDanMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(txtDiaChiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel27)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblMuaBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMuaBan.getTableHeader().setReorderingAllowed(false);
        tblMuaBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMuaBanMouseClicked(evt);
            }
        });
        tblMuaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMuaBanKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(tblMuaBan);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/viewAll_ql.png"))); // NOI18N
        jButton2.setText("Tải Lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextFieldTimMuaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimMuaBanActionPerformed(evt);
            }
        });
        jTextFieldTimMuaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMuaBanKeyReleased(evt);
            }
        });

        jLabel41.setText("Tìm Kiếm :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel41)
                .addGap(68, 68, 68)
                .addComponent(jTextFieldTimMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jButton2)
                .addContainerGap(419, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimMuaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Mua Bán", jPanel5);

        jLabel14.setText("Mã cư dân");
        jLabel14.setToolTipText("");

        jLabel17.setText("Tên cư dân");

        jLabel18.setText("Ngày sinh");

        jLabel21.setText("Giới tính");

        jLabel22.setText("Số điện thoại");

        jLabel23.setText("Số chứng minh thư");

        jLabel24.setText("Quê quán");

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));

        tblCuDan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCuDan.getTableHeader().setReorderingAllowed(false);
        tblCuDan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuDanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCuDanMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblCuDan);

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel42.setText("Tìm Kiếm Cư Dân : ");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CuDanKeyReleased(evt);
            }
        });

        btnTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        BtnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adduser.png"))); // NOI18N
        BtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edituser.png"))); // NOI18N
        btnSua.setToolTipText("Sửa thông tin cư dân");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jButtonXoacd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/removeuser.png"))); // NOI18N
        jButtonXoacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoacdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThongTinLayout.createSequentialGroup()
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenCuDan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaCuDan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnTaiLai)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCMT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQueQuan)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinLayout.createSequentialGroup()
                        .addComponent(BtnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonXoacd)
                        .addContainerGap())))
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMaCuDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtTenCuDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtCMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonXoacd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnThem, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTaiLai)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Cư Dân", jPanel6);

        tblDsCanHoDaBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tblDsCanHoDaBan);

        jLabel37.setText("Số tiền đã nhận");

        txtTongDoanhThu.setEditable(false);
        txtTongDoanhThu.setForeground(new java.awt.Color(255, 0, 102));
        txtTongDoanhThu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel39.setText("Tổng căn hộ đã bán");

        txtSoCanDaBan.setEditable(false);
        txtSoCanDaBan.setForeground(new java.awt.Color(255, 0, 102));
        txtSoCanDaBan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoCanDaBan.setAutoscrolls(false);
        txtSoCanDaBan.setFocusable(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("DANH SÁCH CĂN HỘ ĐÃ BÁN");

        txtTongGiaCH.setEditable(false);
        txtTongGiaCH.setForeground(new java.awt.Color(255, 0, 102));
        txtTongGiaCH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTongGiaCH.setAutoscrolls(false);
        txtTongGiaCH.setFocusable(false);
        txtTongGiaCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongGiaCHActionPerformed(evt);
            }
        });

        jLabel48.setText("Tổng giá trị căn hộ");

        javax.swing.GroupLayout tblCanHoDaBanLayout = new javax.swing.GroupLayout(tblCanHoDaBan);
        tblCanHoDaBan.setLayout(tblCanHoDaBanLayout);
        tblCanHoDaBanLayout.setHorizontalGroup(
            tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
            .addGroup(tblCanHoDaBanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(txtSoCanDaBan)
                    .addComponent(txtTongGiaCH))
                .addContainerGap())
            .addGroup(tblCanHoDaBanLayout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tblCanHoDaBanLayout.setVerticalGroup(
            tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tblCanHoDaBanLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel28)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tblCanHoDaBanLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel39))
                    .addGroup(tblCanHoDaBanLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtSoCanDaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongGiaCH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(24, 24, 24)
                .addGroup(tblCanHoDaBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống Kê Doanh Thu", tblCanHoDaBan);

        tblDotThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        tblDotThanhToan.setForeground(new java.awt.Color(0, 0, 0));
        tblDotThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDotThanhToan.setAlignmentY(1.0F);
        tblDotThanhToan.setGridColor(new java.awt.Color(204, 204, 204));
        tblDotThanhToan.setRowHeight(35);
        tblDotThanhToan.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblDotThanhToan.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblDotThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDotThanhToanMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(tblDotThanhToan);

        jButtonIncomming.setBackground(new java.awt.Color(221, 255, 236));
        jButtonIncomming.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jButtonIncomming.setLabel("Sắp Tới Hạn");
        jButtonIncomming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncommingActionPerformed(evt);
            }
        });

        jButtonlate.setBackground(new java.awt.Color(221, 255, 236));
        jButtonlate.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jButtonlate.setText("Quá Hạn");
        jButtonlate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlateActionPerformed(evt);
            }
        });

        jButtonReload.setBackground(new java.awt.Color(204, 255, 255));
        jButtonReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        jButtonReload.setBorder(null);
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 204));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("DANH SÁCH ĐỢT THANH TOÁN");

        jTextFieldTimDtt.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jTextFieldTimDtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTimDttActionPerformed(evt);
            }
        });
        jTextFieldTimDtt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTimDttKeyReleased(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel47.setText("Tìm Kiếm :");

        javax.swing.GroupLayout tabDotThanhToanLayout = new javax.swing.GroupLayout(tabDotThanhToan);
        tabDotThanhToan.setLayout(tabDotThanhToanLayout);
        tabDotThanhToanLayout.setHorizontalGroup(
            tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDotThanhToanLayout.createSequentialGroup()
                .addGap(0, 209, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addComponent(jScrollPane9)
            .addGroup(tabDotThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTimDtt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonlate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIncomming)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReload)
                .addGap(28, 28, 28))
        );
        tabDotThanhToanLayout.setVerticalGroup(
            tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDotThanhToanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDotThanhToanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonIncomming)
                            .addComponent(jButtonlate)
                            .addComponent(jButtonReload)))
                    .addGroup(tabDotThanhToanLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTimDtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Đợt Thanh Toán", tabDotThanhToan);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(83, 58, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("DANH SÁCH GIAO DỊCH");

        tblGiaoDich.setBackground(new java.awt.Color(255, 255, 255));
        tblGiaoDich.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tblGiaoDich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGiaoDich.setRowHeight(40);
        tblGiaoDich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGiaoDichMousePressed(evt);
            }
        });
        jScrollPane10.setViewportView(tblGiaoDich);

        jLabel53.setText("Tìm Kiếm :");

        jTextFieldGD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldGDKeyReleased(evt);
            }
        });

        jLabel49.setText("Mã Giao Dịch :");

        jButtonMoGD.setText("Mở Biên Bản");
        jButtonMoGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoGDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabGiaoDichLayout = new javax.swing.GroupLayout(tabGiaoDich);
        tabGiaoDich.setLayout(tabGiaoDichLayout);
        tabGiaoDichLayout.setHorizontalGroup(
            tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldGD, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(34, 34, 34)
                .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGiaoDichLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGiaoDichLayout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGiaoDichLayout.createSequentialGroup()
                        .addComponent(jButtonMoGD)
                        .addContainerGap())))
        );
        tabGiaoDichLayout.setVerticalGroup(
            tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextFieldGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(txtMaGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMoGD)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Các Giao Dịch", tabGiaoDich);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(370, 370, 370)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btDangXuat.setForeground(new java.awt.Color(0, 0, 162));
        btDangXuat.setText("Đăng Xuất");
        btDangXuat.setToolTipText("Đăng xuất");
        btDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDangXuat)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangXuatActionPerformed
        this.dispose();
        DangNhapUI dn = new DangNhapUI("Quản lý căn hộ");
        dn.showWindow();
    }//GEN-LAST:event_btDangXuatActionPerformed

    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed
        showCuDan();
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnTaiLaiActionPerformed

    private void tblCuDanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuDanMouseClicked
        txtMaCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 0).toString());
        txtTenCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 1).toString());
        txtNgaySinh.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 2).toString());
        cbbGioiTinh.setSelectedItem(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 3).toString());
        txtSoDienThoai.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 4).toString());
        txtCMT.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 5).toString());
        txtQueQuan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tblCuDanMouseClicked

    private void tblMuaBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMuaBanMouseClicked
        txtMaHopDong.setText((String) (tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 0)));
        txtTenKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 1) + "");
        cbbMaCanHoMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 2) + "");
        cbbMaCuDanMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 3) + "");
        txtDiaChiKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 4) + "");
        txtDaThanhToan.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 5).toString().trim() + "\tVND");
        txtNgayGiaoDich.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 7) + "");
    }//GEN-LAST:event_tblMuaBanMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        showThongTinMuaBan();
        jTextFieldTimMuaBan.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldTimMuaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimMuaBanActionPerformed
        // TODO add your handling code here:
        try {
            HopDongBLL.TimKiem_BLL(tblMuaBan, jTextFieldTimMuaBan.getText());
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextFieldTimMuaBanActionPerformed

    private void txtDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaThanhToanActionPerformed

    private void cbbMaCanHoMuaBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbMaCanHoMuaBanMouseClicked

    }//GEN-LAST:event_cbbMaCanHoMuaBanMouseClicked

    private void cbbMaCanHoMuaBanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaCanHoMuaBanItemStateChanged

    }//GEN-LAST:event_cbbMaCanHoMuaBanItemStateChanged

    private void txtNgayGiaoDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayGiaoDichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayGiaoDichActionPerformed

    private void txtMaHopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHopDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHopDongActionPerformed

    private void tbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoanMouseClicked

        txtMaNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 0)).toString().trim());
        txtHoTenNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 1)).toString().trim());
        txtDiaChiNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 2)).toString().trim());
        txtSDTNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 3)).toString().trim());
        txtEmailNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 4)).toString().trim());
    }//GEN-LAST:event_tbTaiKhoanMouseClicked

    private void btThoat_QLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoat_QLActionPerformed
        pnChange.setVisible(false);
        btTiepTuc.setVisible(true);
    }//GEN-LAST:event_btThoat_QLActionPerformed

    private void btLuu_QLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuu_QLActionPerformed

        String newPassWord = new String(txbMK_QL_New.getPassword()); //get String from passWord
        String confirmPassWord = new String(txbMK_QL_Confirm.getPassword());

        //        if(!RegexExpression.checkUserName(txbTenTK_QL_New.getText())){
        //            JOptionPane.showMessageDialog(null,"Tên tài khoản không hợp lệ!");
        //        }else if(!RegexExpression.checkPassWord(newPassWord)){
        //            JOptionPane.showMessageDialog(null,"Mật khẩu không hợp lệ!");
        //        }else
        if (!newPassWord.equals(confirmPassWord)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng nhau !");
        } else {
            if (NhanVienBLL.update(txbTenTK_QL_New.getText(), confirmPassWord, true)) {
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
                clearAllControl_TaiKhoanQL();

            } else {
                JOptionPane.showMessageDialog(null, "Không sửa được!");
            }
            pnChange.setVisible(false);
            btTiepTuc.setVisible(true);
        }
    }//GEN-LAST:event_btLuu_QLActionPerformed

    private void btTiepTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTiepTucActionPerformed
        XacNhanTTTKGUI xn = new XacNhanTTTKGUI(this, true);
        xn.setVisible(true);
        if (xn.checkAccountManager() && xn.checkEvent) { // neu dung
            pnChange.setVisible(true);
            btTiepTuc.setVisible(false);
        }
    }//GEN-LAST:event_btTiepTucActionPerformed

    private void btSua_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSua_NVActionPerformed
        try {
            NhanVien nv1 = NhanVienBLL.findByID(txtMaNV.getText());
            NhanVien nv = getInfoNV();
            nv.setMatKhau(nv1.getMatKhau());
            if (NhanVienBLL.update(nv)) {
                show_TaiKhoan();
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại dữ liệu."
                        + " Lưu ý : Không thể sửa Mã Nhân Viên đã cấp ");
            }
        } catch (Exception e) {
            System.out.println("ERROR in btnSuaNV" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Không sửa được!");
        }
    }//GEN-LAST:event_btSua_NVActionPerformed
    private NhanVien getInfoNV() {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(txtMaNV.getText());
        nv.setHoTen(txtHoTenNV.getText());
        nv.setDiaChi(txtDiaChiNV.getText());
        nv.setDiaChi(txtDiaChiNV.getText());
        nv.setSDT(txtSDTNV.getText());
        nv.setEmail(txtEmailNV.getText());

        return nv;
    }
    private void btXoa_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoa_NVActionPerformed
        if (NhanVienBLL.checkEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa có tài khoản nào!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (txtMaNV.getText().length() > 25 && txtMaNV.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Chọn dòng trước khi xóa!");
            } else {
                if (NhanVienBLL.delete(txtMaNV.getText())) {
                    show_TaiKhoan();
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                    clearAllControl_TaiKhoanNV();
                } else {
                    JOptionPane.showMessageDialog(null, "Không xóa được!");
                }
            }
        }
    }//GEN-LAST:event_btXoa_NVActionPerformed

    private void btThem_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThem_NVActionPerformed
        NhanVien nv = getInfoNV();
        try {
            if (!RegexExpression.checkUserName(txtMaNV.getText())) {
                if (txtMaNV.getText().equals("") || txtEmailNV.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
                } else if (NhanVienBLL.insert(nv)) {
                    show_TaiKhoan();
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    clearAllControl_TaiKhoanNV();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin!");
                }
            } else {
                if (NhanVienBLL.insert(nv)) {
                    show_TaiKhoan();
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    clearAllControl_TaiKhoanNV();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin!");
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng không nhập trùng!");
        }
    }//GEN-LAST:event_btThem_NVActionPerformed

    private void cbbDienTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDienTichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDienTichActionPerformed

    private void btTim_CanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTim_CanHoActionPerformed
        try {
            float tuDienTich = 0;
            float denDienTich = 0;
            long tuGia = 0;
            long denGia = 0;
            switch (cbbDienTich.getSelectedIndex()) {
                case 0:
                    tuDienTich = 0;
                    denDienTich = 51;
                    break;
                case 1:
                    tuDienTich = 51;
                    denDienTich = 101;
                    break;
                default:
                    tuDienTich = 101;
            }

            switch (cbbGia.getSelectedIndex()) {
                case 0:
                    denGia = 1000000000;
                    break;
                case 1:
                    tuGia = 1000000000;
                    denGia = 2000000000;
                    break;
                default:
                    tuGia = 2000000000;
            }

            tbCanHo.setModel(CanHoBLL.search(cbTrangThai.isSelected(), tuGia, denGia, tuDienTich, denDienTich));
        } catch (NullPointerException ex) {
            // do nothing
        }
    }//GEN-LAST:event_btTim_CanHoActionPerformed

    private void btViewAllApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewAllApartmentActionPerformed
        show_CanHo();
    }//GEN-LAST:event_btViewAllApartmentActionPerformed

    private void btSua_CanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSua_CanHoActionPerformed

        try {

            if (txbGia.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Giá không được bỏ trống!");
            } else if (removeDelimitor(txbGia.getText().trim()) < 1) {
                JOptionPane.showMessageDialog(null, "Vui lòng giá là số dương!");
            } else if (txbSoPhong.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Số phòng không được bỏ trống");
            } else if (Integer.parseInt(txbSoPhong.getText()) < 1) {
                JOptionPane.showMessageDialog(null, "Vui lòng số phòng là số dương!");
            } else {
                boolean check = CanHoBLL.update(cbbMaCanHo.getSelectedItem().toString(), removeDelimitor(txbGia.getText().trim()), Integer.parseInt(txbSoPhong.getText()));

                if (check) {
                    show_CanHo();
                    JOptionPane.showMessageDialog(null, "Sửa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Không sửa được!");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số");
        }

    }//GEN-LAST:event_btSua_CanHoActionPerformed

    private void cbbMaCanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaCanHoActionPerformed

        try {
            Object[] o = CanHoBLL.showControlWithCombobox(cbbMaCanHo.getSelectedItem().toString());
            txbDienTich.setText(o[0].toString());
            txbGia.setText(o[1].toString());
            txbMaCuDan.setText(o[2].toString());
            txbSoPhong.setText(o[3].toString());
            txbTenKhu_CanHo.setText(o[4].toString());
        } catch (NullPointerException ex) {
            //do noting
        }
    }//GEN-LAST:event_cbbMaCanHoActionPerformed

    private void btViewAllAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewAllAreaActionPerformed
        show_KhuCanHo();
    }//GEN-LAST:event_btViewAllAreaActionPerformed

    private void cbbMaKhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaKhuActionPerformed

        try {
            Object[] obj = KhuCanHoBLL.showControlWithCombobox(cbbMaKhu.getSelectedItem().toString());
            txbDiaChi.setText(obj[0].toString());
            txbSoCanTT.setText(obj[1].toString());
            txbSoTang.setText(obj[2].toString());
            txbTenKhu.setText(obj[3].toString());
        } catch (NullPointerException e) {
            // do nothing :3
        }
    }//GEN-LAST:event_cbbMaKhuActionPerformed

    private void txbTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbTimKiem1KeyReleased
        try {
            tbKhu.setModel(KhuCanHoBLL.search(txbTimKiem1.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txbTimKiem1KeyReleased

    private void txbTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbTimKiem1ActionPerformed
        //JOptionPane.showMessageDialog(rootPane,"Changed!");//khi nhấn enter
        try {
            tbKhu.setModel(KhuCanHoBLL.search(txbTimKiem1.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txbTimKiem1ActionPerformed

    private void btXoa_KhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoa_KhuActionPerformed
        if (KhuCanHoBLL.checkEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa có khu căn hộ nào!", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[] items = {"Xác nhận", "Hủy"};
            int rs = JOptionPane.showOptionDialog(null, "Xóa khu và tất cả thông tin liên quan!", "Xóa khu căn hộ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, items, items[0]);
            if (rs == JOptionPane.YES_OPTION) {
                this.setEnabled(false);
                XacNhanTTTKGUI xn = new XacNhanTTTKGUI(this, true);
                xn.setVisible(true);
                if (xn.checkAccountManager() && xn.checkEvent) {
                    if (KhuCanHoBLL.delete(cbbMaKhu.getSelectedItem().toString())) {
                        show_KhuCanHo();
                        show_CanHo();
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        clearAllControl_KhuCanHo();
                        clearAllControl_CanHo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể xóa khu đã có hợp đồng mua bán!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btXoa_KhuActionPerformed

    private void btSua_KhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSua_KhuActionPerformed

        if (txbTenKhu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tên khu không được bỏ trống!");
        } else if (txbDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được bỏ trống!");
        } else {
            if (KhuCanHoBLL.update(cbbMaKhu.getSelectedItem().toString(), RegexExpression.toUpperCaseFirstCharacter(txbTenKhu.getText()), RegexExpression.toUpperCaseFirstCharacter(txbDiaChi.getText()))) {
                show_KhuCanHo();
                show_CanHo();
                JOptionPane.showMessageDialog(null, "Sửa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không sửa được!");
            }
        }
    }//GEN-LAST:event_btSua_KhuActionPerformed

    private void btThem_KhuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThem_KhuActionPerformed
        this.setEnabled(false);
        ThemKhu_PhongGUI fr = new ThemKhu_PhongGUI(this, true);
        fr.setVisible(true);
    }//GEN-LAST:event_btThem_KhuActionPerformed

    private void jTextFieldMuaBanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMuaBanKeyReleased
        // TODO add your handling code here:
        try {
            BLL.HopDongBLL.TimKiem_BLL(tblMuaBan, jTextFieldTimMuaBan.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldMuaBanKeyReleased

    private void CuDanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CuDanKeyReleased
        // TODO add your handling code here:
        try {
            BLL.QuanLyCuDanBLL.TimKiemCD_BLL(tblCuDan, txtTimKiem.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CuDanKeyReleased

    private void jButtonMoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoHDActionPerformed
        // TODO add your handling code here:
        try {
            String text = "HopDongMuaBanCanHo_" + txtMaHopDong.getText() + ".docx";
            String input = text.replaceAll("\\s+", "");

            Desktop.getDesktop().open(new File(input));
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Hợp đồng đã bị xóa");

        }
    }//GEN-LAST:event_jButtonMoHDActionPerformed

    private void txbSoCanTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbSoCanTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbSoCanTTActionPerformed

    private void tblDotThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDotThanhToanMousePressed
        // TODO add your handling code here:
//        int row = tblDotThanhToan.getSelectedRow();
//        txtMaDotTT.setText(tblDotThanhToan.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblDotThanhToanMousePressed

    private void jButtonIncommingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncommingActionPerformed
        try {
            // TODO add your handling code here:
            BLL.DotThanhToanBLL.incommingDate(tblDotThanhToan);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIncommingActionPerformed

    private void jButtonlateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlateActionPerformed

        BLL.DotThanhToanBLL.lateDate(tblDotThanhToan);
    }//GEN-LAST:event_jButtonlateActionPerformed

    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        // TODO add your handling code here:
        BLL.DotThanhToanBLL.show(tblDotThanhToan);
    }//GEN-LAST:event_jButtonReloadActionPerformed

    private void jTextFieldTimDttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimDttActionPerformed
        // TODO add your handling code here:
        try {
            BLL.DotThanhToanBLL.search(tblDotThanhToan, jTextFieldTimDtt.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldTimDttActionPerformed

    private void jTextFieldTimDttKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimDttKeyReleased
        // TODO add your handling code here:
        try {
            BLL.DotThanhToanBLL.search(tblDotThanhToan, jTextFieldTimDtt.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldTimDttKeyReleased

    private void jTextFieldGDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGDKeyReleased
        // TODO add your handling code here:
        try {
            BLL.GiaoDichBLL.search(tblGiaoDich, jTextFieldGD.getText());
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldGDKeyReleased

    private void jButtonMoGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoGDActionPerformed
        // TODO add your handling code here:
        try {
            String text = "BienBanGiaoDich_" + txtMaGD.getText().trim() + ".docx";
            Desktop.getDesktop().open(new File(text));
        } catch (Exception ex) {
            System.out.println("Error Mo Hop Dong " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Biên Bản Này Đã Bị Xóa");
        }
    }//GEN-LAST:event_jButtonMoGDActionPerformed

    private void tblGiaoDichMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiaoDichMousePressed
        // TODO add your handling code here:
        int row = tblGiaoDich.getSelectedRow();
        txtMaGD.setText(tblGiaoDich.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblGiaoDichMousePressed

    private void txtTongGiaCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongGiaCHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongGiaCHActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMaCuDan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Chọn mã cư dân.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtTenCuDan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Tên cư dân trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtNgaySinh.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ngày sinh trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkDateTime(txtNgaySinh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSoDienThoai.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số điện thoại trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtCMT.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số CMND trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtQueQuan.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Quê quán trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BLL.QuanLyCuDanBLL.updateCD_BLL(txtMaCuDan, txtTenCuDan, txtNgaySinh, cbbGioiTinh, txtSoDienThoai, txtCMT, txtQueQuan);
                BLL.HopDongBLL.UpdateHD_BLL(txtQueQuan.getText(), txtMaCuDan.getText(), txtTenCuDan.getText());
                BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblCuDan);
                JOptionPane.showMessageDialog(null, "Sửa thành công.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in btnSua: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButtonXoacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoacdActionPerformed
        // TODO add your handling code here:
        try {
            if (QuanLyCuDanDAL.xuLyXoaCuDan(txtMaCuDan.getText().trim())) {
                tblCuDan.setModel(new DefaultTableModel(null, new String[]{}));
                try {
                    BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblCuDan);
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Khách hàng này đã ký hợp đồng mua nhà!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Khách hàng này đã ký hợp đồng mua nhà!");
        }


    }//GEN-LAST:event_jButtonXoacdActionPerformed

    private void BtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnThemActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        try {
            if (txtMaCuDan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Chọn mã cư dân.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtTenCuDan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Tên cư dân trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtNgaySinh.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ngày sinh trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkDateTime(txtNgaySinh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSoDienThoai.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số điện thoại trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtCMT.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số CMND trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtQueQuan.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Quê quán trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkPhoneNumber(txtSoDienThoai.getText())) {
                JOptionPane.showMessageDialog(null, "SĐT phải gồm 10 số.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkID(txtCMT.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số CMND gồm 9 hoặc 12 số.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (QuanLyCuDanBLL.insertCD_BLL(txtMaCuDan.getText(), txtTenCuDan, txtNgaySinh, cbbGioiTinh, txtSoDienThoai, txtCMT, txtQueQuan)) {
                    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table
                    renderer.setHorizontalAlignment(JLabel.CENTER);//
                    tblCuDan.setModel(new DefaultTableModel(null, new String[]{}));
                    BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblCuDan);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    tblCuDan.setDefaultRenderer(Object.class, renderer);

                } else {
                    JOptionPane.showMessageDialog(null, "Mã Cư Dân Không Được Trùng");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in btnSua: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Mã Cư Dân Không Được Trùng");

        }

    }//GEN-LAST:event_BtnThemActionPerformed

    private void txtMaNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyReleased
        // TODO add your handling code here:
        txtEmailNV.setText(txtMaNV.getText().trim() + "@hust.com");
    }//GEN-LAST:event_txtMaNVKeyReleased

    private void tbCanHoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCanHoMousePressed
        // TODO add your handling code here:
        cbbMaCanHo.setSelectedItem(tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 1));
        txbDienTich.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 2).toString()));
        txbGia.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 3).toString()));
        txbSoPhong.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 5).toString()));
        if ((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 6)) == null) {
            txbMaCuDan.setText("<Empty>");
        } else {
            txbMaCuDan.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 6).toString()));
        }
        txbTenKhu_CanHo.setText((tbCanHo.getValueAt(tbCanHo.getSelectedRow(), 7).toString()));
    }//GEN-LAST:event_tbCanHoMousePressed

    private void tbKhuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuMousePressed
        // TODO add your handling code here:
        cbbMaKhu.setSelectedItem(tbKhu.getValueAt(tbKhu.getSelectedRow(), 1).toString()); // Dữ liệu trong combobox phải có trước
        txbTenKhu.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 2).toString());
        txbSoTang.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 3).toString());
        txbSoCanTT.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 4).toString());
        txbDiaChi.setText(tbKhu.getValueAt(tbKhu.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbKhuMousePressed

    private void tbTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoanMousePressed
        // TODO add your handling code here:
        txtMaNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 0)).toString().trim());
        txtHoTenNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 1)).toString().trim());
        txtDiaChiNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 2)).toString().trim());
        txtSDTNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 3)).toString().trim());
        txtEmailNV.setText((tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 4)).toString().trim());
    }//GEN-LAST:event_tbTaiKhoanMousePressed

    private void tblMuaBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMuaBanKeyPressed
        // TODO add your handling code here:
        txtMaHopDong.setText((String) (tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 0)));
        txtTenKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 1) + "");
        cbbMaCanHoMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 2) + "");
        cbbMaCuDanMuaBan.setSelectedItem(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 3) + "");
        txtDiaChiKhachHang.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 4) + "");
        txtDaThanhToan.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 5).toString().trim() + "\tVND");
        txtNgayGiaoDich.setText(tblMuaBan.getValueAt(tblMuaBan.getSelectedRow(), 7) + "");
    }//GEN-LAST:event_tblMuaBanKeyPressed

    private void tblCuDanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuDanMousePressed
        // TODO add your handling code here:
        txtMaCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 0).toString());
        txtTenCuDan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 1).toString());
        txtNgaySinh.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 2).toString());
        cbbGioiTinh.setSelectedItem(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 3).toString());
        txtSoDienThoai.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 4).toString());
        txtCMT.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 5).toString());
        txtQueQuan.setText(tblCuDan.getValueAt(tblCuDan.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tblCuDanMousePressed
    protected void xuLyLuuCuDan() {
        CuDan cuDan = new CuDan();
        cuDan.setMaCuDan(txtMaCuDan.getText());
        cuDan.setTenCuDan(txtTenCuDan.getText());
        cuDan.setNgaySinh(txtNgaySinh.getText());
        boolean gt = false;
        gt = cbbGioiTinh.getSelectedItem().toString().equals("Nam");
        cuDan.setGioiTinh(gt);
        cuDan.setSoDT(txtSoDienThoai.getText());
        cuDan.setSoCMT(txtCMT.getText());
        cuDan.setQueQuan(txtQueQuan.getText());
        QuanLyCuDanDAL qlCuDan = new QuanLyCuDanDAL();
        qlCuDan.themCuDan(cuDan);

    }

    protected void xuLyUpdateCuDan() {
        CuDan cuDan = new CuDan();
        cuDan.setMaCuDan(txtMaCuDan.getText());
        cuDan.setTenCuDan(txtTenCuDan.getText());
        cuDan.setNgaySinh(txtNgaySinh.getText());
        boolean gt = false;
        gt = cbbGioiTinh.getSelectedItem().toString().equals("Nam");
        cuDan.setGioiTinh(gt);
        cuDan.setSoDT(txtSoDienThoai.getText());
        cuDan.setSoCMT(txtCMT.getText());
        cuDan.setQueQuan(txtQueQuan.getText());
        QuanLyCuDanDAL qlCuDan = new QuanLyCuDanDAL();
        qlCuDan.updateCuDan(cuDan);
    }

    protected void xuLyUpdateHopDong() {
        HopDong hopDong = new HopDong();
        hopDong.setMaHopDong(txtMaHopDong.getText());
        hopDong.setNgayGiaoDich(txtNgayGiaoDich.getText());
        hopDong.setDiaChiKhachHang(txtDiaChiKhachHang.getText());
        hopDong.setMaCuDan(cbbMaCuDanMuaBan.getSelectedItem() + "");
        hopDong.setMaCanHo(cbbMaCanHoMuaBan.getSelectedItem() + "");
        hopDong.setTenKH(txtTenKhachHang.getText());
        QuanLyHopDongDAL qlHopDong = new QuanLyHopDongDAL();
        qlHopDong.updateHopDong(hopDong);

    }

    protected void xuLyLuuHopDong() {
        HopDong hopDong = new HopDong();
        hopDong.setMaHopDong(txtMaHopDong.getText());
        hopDong.setNgayGiaoDich(txtNgayGiaoDich.getText());
        hopDong.setDiaChiKhachHang(txtDiaChiKhachHang.getText());
        hopDong.setMaCuDan(cbbMaCuDanMuaBan.getSelectedItem() + "");
        hopDong.setMaCanHo(cbbMaCanHoMuaBan.getSelectedItem() + "");
        hopDong.setTenKH(txtTenKhachHang.getText());
        QuanLyHopDongDAL qlHopDong = new QuanLyHopDongDAL();
        qlHopDong.themHopDong(hopDong);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
    }

    private String convertMoney(Long number) {
        String numberInText = String.valueOf(number);

        int numberLength = numberInText.length();

        if (numberLength < 4) {
            return numberInText;
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0, j = numberLength % 3 == 0 ? 3 : numberLength % 3; i < numberLength; ++i) {

            if (j < numberLength && i == j) {
                sb.append(".");
                j += 3;
            }

            sb.append(numberInText.charAt(i));
        }

        return sb.toString();
    }

    private Long removeDelimitor(String number) {
        return Long.parseLong(number.replaceAll("\\.", ""));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnThem;
    private javax.swing.JButton btDangXuat;
    private javax.swing.JButton btLuu_QL;
    private javax.swing.JButton btSua_CanHo;
    private javax.swing.JButton btSua_Khu;
    private javax.swing.JButton btSua_NV;
    private javax.swing.JButton btThem_Khu;
    private javax.swing.JButton btThem_NV;
    private javax.swing.JButton btThoat_QL;
    private javax.swing.JButton btTiepTuc;
    private javax.swing.JButton btTim_CanHo;
    private javax.swing.JButton btViewAllApartment;
    private javax.swing.JButton btViewAllArea;
    private javax.swing.JButton btXoa_Khu;
    private javax.swing.JButton btXoa_NV;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JCheckBox cbTrangThai;
    private javax.swing.JComboBox<String> cbbDienTich;
    private javax.swing.JComboBox<String> cbbGia;
    private javax.swing.JComboBox cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbMaCanHo;
    private javax.swing.JComboBox cbbMaCanHoMuaBan;
    private javax.swing.JComboBox cbbMaCuDanMuaBan;
    private javax.swing.JComboBox<String> cbbMaKhu;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonIncomming;
    private javax.swing.JButton jButtonMoGD;
    private javax.swing.JButton jButtonMoHD;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonXoacd;
    private javax.swing.JButton jButtonlate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTabbedPane jTablePanel2;
    private javax.swing.JTextField jTextFieldGD;
    private javax.swing.JTextField jTextFieldTimDtt;
    private javax.swing.JTextField jTextFieldTimMuaBan;
    private javax.swing.JPanel pnChange;
    private javax.swing.JPanel pnChangeInfo;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JPanel tabDotThanhToan;
    private javax.swing.JPanel tabGiaoDich;
    private javax.swing.JTable tbCanHo;
    private javax.swing.JTable tbKhu;
    private javax.swing.JTable tbTaiKhoan;
    private javax.swing.JPanel tblCanHoDaBan;
    private javax.swing.JTable tblCuDan;
    private javax.swing.JTable tblDotThanhToan;
    private javax.swing.JTable tblDsCanHoDaBan;
    private javax.swing.JTable tblGiaoDich;
    private javax.swing.JTable tblMuaBan;
    private javax.swing.JTextField txbDiaChi;
    private javax.swing.JTextField txbDienTich;
    private javax.swing.JTextField txbGia;
    private javax.swing.JPasswordField txbMK_QL_Confirm;
    private javax.swing.JPasswordField txbMK_QL_New;
    private javax.swing.JTextField txbMaCuDan;
    private javax.swing.JTextField txbSoCanTT;
    private javax.swing.JTextField txbSoPhong;
    private javax.swing.JTextField txbSoTang;
    private javax.swing.JTextField txbTenKhu;
    private javax.swing.JTextField txbTenKhu_CanHo;
    private javax.swing.JTextField txbTenTK_QL_New;
    private javax.swing.JTextField txbTimKiem1;
    private javax.swing.JTextField txtCMT;
    private javax.swing.JTextField txtDaThanhToan;
    private javax.swing.JTextField txtDiaChiKhachHang;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaCuDan;
    private javax.swing.JTextField txtMaGD;
    private javax.swing.JTextField txtMaHopDong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayGiaoDich;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtSoCanDaBan;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenCuDan;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongDoanhThu;
    private javax.swing.JTextField txtTongGiaCH;
    // End of variables declaration//GEN-END:variables

}
