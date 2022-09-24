/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CreateTransaction;
import BLL.KhuCanHoBLL;
import BLL.QuanLyCuDanBLL;
import static BLL.QuanLyCuDanBLL.cmb_BLL;
import BLL.NhanVienBLL;
import BLL.ThongTinCanHoBLL;
import DAL.QuanLyCuDanDAL;
import static DAL.QuanLyCuDanDAL.dsCuDan;
import Entities.CanHo;
import Entities.CuDan;
import Entities.DotThanhToan;
import Entities.GiaoDich;
import Entities.HopDong;
import Entities.NhanVien;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class NhanVienGUI extends javax.swing.JFrame {

    /**
     * Creates new form testFrameGUI
     *
     * @throws java.sql.SQLException
     */
    public static final String ERROR = "ERROR";
    private static NhanVien nv = new NhanVien();

    public NhanVienGUI(NhanVien tk) throws SQLException {
        initComponents();
        setLocationRelativeTo(null);

        //======================================================================
        //Begin TabQuanLyCuDan
        //======================================================================
        try {
            nv.setDiaChi(tk.getDiaChi());
            nv.setEmail(tk.getEmail());
            nv.setHoTen(tk.getHoTen());
            nv.setSDT(tk.getSDT());
            nv.setMaNhanVien(tk.getMaNhanVien());
            nv.setMatKhau(tk.getMatKhau());
            txtNhanVienGD.setText(nv.getMaNhanVien());
            txtNhanVienGD.setEditable(false);
            jLabel1.setText("Nhân Viên: " + nv.getHoTen());
            System.out.println(nv.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //======================================================================
        //Truyen Du Lieu Tai Khoan
        //======================================================================
        txtTenNV.setText(nv.getHoTen());
        txtEmailNV.setText(nv.getEmail());
        txtDiaChiNV.setText(nv.getDiaChi());
        txtSDTNV.setText(nv.getSDT());
        txtUserNameNV.setText(nv.getMaNhanVien());
        txtPasswordNV1.setText(nv.getMatKhau());
        txtPasswordNV2.setText(nv.getMatKhau());
        txtUserNameNV.setEditable(false);
        txtEmailNV.setEditable(false);
        //======================================================================
        //Truyen Thong Tin Nv
        //======================================================================
        cmbGioitinh.setSelectedItem(null);
        //======================================================================
        //End TabQuanLyCuDan
        //======================================================================

        //======================================================================
        //Begin TabThongTinCanHo
        //======================================================================
        txtMacanho1.setEditable(false);
        txtGiacanho.setEditable(false);
        txtNgaygiaodich.setEditable(false);
        txtSoPhongMB.setEditable(false);
        txtDienTichMB.setEditable(false);
        txtKhuCHMB.setEditable(false);
//        cmbMacudan.setEnabled(false);
        cmbMacudan.setSelectedItem("");
        cmbGioitinh1.setSelectedItem(null);
        cmbMacudan.setModel(cmb_BLL()); //Đưa mã cư dân lên comboBox
        cmbMacudan.setSelectedItem(null);
        cmbSophong.setModel(ThongTinCanHoBLL.SoPhong_BLL());
        //======================================================================
        //End TabThongTinCanHo
        //======================================================================
        showPhanTich();
        try {
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table
            renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng

            BLL.HopDongBLL.HienThongTinMuaBan(tblThongTinMuaBan);
            tblThongTinMuaBan.setDefaultRenderer(Object.class, renderer);
            BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblQuanLyCuDan);
            tblQuanLyCuDan.setDefaultRenderer(Object.class, renderer);
            BLL.ThongTinCanHoBLL.HienThongTinCanho(tblThongTinCanHo);
            tblThongTinCanHo.setDefaultRenderer(Object.class, renderer);
            BLL.DotThanhToanBLL.show(tblDotThanhToan);
            tblDotThanhToan.setDefaultRenderer(Object.class, renderer);
            BLL.GiaoDichBLL.show(tblGiaoDich);
            tblGiaoDich.setDefaultRenderer(Object.class, renderer);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in NhanVienGUI: " + ex.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        tabNhanvien = new javax.swing.JTabbedPane();
        tabThongtinmuaban = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinMuaBan = new javax.swing.JTable();
        btnRefreshTTMB = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tabQuanlycudan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTencudan = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtQuequan = new javax.swing.JTextField();
        txtSocmt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbGioitinh = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btnRefreshQLCD = new javax.swing.JButton();
        txtMacudan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLyCuDan = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jButtonXoacd = new javax.swing.JButton();
        BtnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        tabThongtincanho = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongTinCanHo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cmbMacudan = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtTenkh = new javax.swing.JTextField();
        txtNgsinh = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtScmt = new javax.swing.JTextField();
        cmbGioitinh1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnInhopdong = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        chkLacudan = new javax.swing.JCheckBox();
        txtGiacanho = new javax.swing.JTextField();
        txtNgaygiaodich = new javax.swing.JTextField();
        txtMacanho1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtSoDot = new javax.swing.JTextField();
        txtDienTichMB = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtSoPhongMB = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtKhuCHMB = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btTim_CanHo = new javax.swing.JButton();
        cbbDienTich = new javax.swing.JComboBox<>();
        cbbGia = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cmbSophong = new javax.swing.JComboBox<>();
        btnRefreshTTCH = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPhanTich = new javax.swing.JTable();
        tabDotThanhToan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDotThanhToan = new javax.swing.JTable();
        jButtonIncomming = new javax.swing.JButton();
        jButtonlate = new javax.swing.JButton();
        jButtonReload = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTimDtt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtMaDotTT = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtSoTienGD = new javax.swing.JTextField();
        txtNhanVienGD = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jButtonXacNhanGD = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        txtTienDTT = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        tabGiaoDich = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblGiaoDich = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldGD = new javax.swing.JTextField();
        tabThongTinCaNhan = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtUserNameNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        txtPasswordNV1 = new javax.swing.JPasswordField();
        txtPasswordNV2 = new javax.swing.JPasswordField();
        jButtonSaveNV = new javax.swing.JButton();
        jButtonReloadNV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý chung cư");
        setBackground(new java.awt.Color(255, 195, 191));
        setName("frmNhanVien"); // NOI18N
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 81));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 38, 66));
        jLabel1.setText("NHÂN VIÊN");

        btnLogout.setBackground(new java.awt.Color(221, 255, 236));
        btnLogout.setText("Đăng Xuất");
        btnLogout.setToolTipText("Đăng xuất");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(83, 58, 255), 2));
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(153, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabNhanvien.setBackground(new java.awt.Color(204, 204, 204));
        tabNhanvien.setForeground(new java.awt.Color(0, 0, 0));
        tabNhanvien.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tabNhanvien.setPreferredSize(new java.awt.Dimension(1280, 640));
        tabNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabNhanvienMouseEntered(evt);
            }
        });

        tabThongtinmuaban.setBackground(new java.awt.Color(255, 255, 226));
        tabThongtinmuaban.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 58, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin mua bán");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 226));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 255));

        tblThongTinMuaBan.setBackground(new java.awt.Color(255, 255, 226));
        tblThongTinMuaBan.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        tblThongTinMuaBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hợp đồng", "Tên khách hàng", "Mã Khách", "Mã căn hộ", "Giá", "Đã Thanh Toán", "Còn Thiếu", "Ngày Giao Dịch", "Thời Hạn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTinMuaBan.setToolTipText("Bảng Thông tin mua bán");
        tblThongTinMuaBan.setRowHeight(35);
        jScrollPane1.setViewportView(tblThongTinMuaBan);
        if (tblThongTinMuaBan.getColumnModel().getColumnCount() > 0) {
            tblThongTinMuaBan.getColumnModel().getColumn(0).setResizable(false);
            tblThongTinMuaBan.getColumnModel().getColumn(1).setResizable(false);
            tblThongTinMuaBan.getColumnModel().getColumn(2).setResizable(false);
            tblThongTinMuaBan.getColumnModel().getColumn(3).setResizable(false);
            tblThongTinMuaBan.getColumnModel().getColumn(4).setResizable(false);
            tblThongTinMuaBan.getColumnModel().getColumn(5).setResizable(false);
        }

        btnRefreshTTMB.setBackground(new java.awt.Color(255, 255, 226));
        btnRefreshTTMB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        btnRefreshTTMB.setToolTipText("Tải lại");
        btnRefreshTTMB.setBorder(null);
        btnRefreshTTMB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshTTMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTTMBActionPerformed(evt);
            }
        });

        txtTimKiem.setForeground(new java.awt.Color(0, 0, 255));
        txtTimKiem.setToolTipText("Nhập thông tin cần tìm kiếm");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Từ Khóa :");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(83, 58, 255));
        jLabel33.setText("Tìm Kiếm");

        javax.swing.GroupLayout tabThongtinmuabanLayout = new javax.swing.GroupLayout(tabThongtinmuaban);
        tabThongtinmuaban.setLayout(tabThongtinmuabanLayout);
        tabThongtinmuabanLayout.setHorizontalGroup(
            tabThongtinmuabanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)
            .addGroup(tabThongtinmuabanLayout.createSequentialGroup()
                .addGroup(tabThongtinmuabanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabThongtinmuabanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefreshTTMB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabThongtinmuabanLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel33)))
                .addContainerGap(898, Short.MAX_VALUE))
        );
        tabThongtinmuabanLayout.setVerticalGroup(
            tabThongtinmuabanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongtinmuabanLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabThongtinmuabanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabThongtinmuabanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addComponent(btnRefreshTTMB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        tabNhanvien.addTab("Thông tin hợp đồng", tabThongtinmuaban);

        tabQuanlycudan.setBackground(new java.awt.Color(255, 233, 226));
        tabQuanlycudan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 163, 0), 2));

        jPanel2.setBackground(new java.awt.Color(240, 255, 182));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));

        jLabel3.setText("Mã cư dân:");

        jLabel4.setText("SĐT:");

        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSdtMouseClicked(evt);
            }
        });

        jLabel5.setText("Tên cư dân:");

        txtTencudan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTencudanMouseClicked(evt);
            }
        });

        txtNgaysinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaysinhMouseClicked(evt);
            }
        });

        jLabel6.setText("Ngày sinh:");

        jLabel7.setText("Giới tính:");

        jLabel8.setText("Quê quán:");

        txtQuequan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuequanMouseClicked(evt);
            }
        });

        txtSocmt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSocmtMouseClicked(evt);
            }
        });

        jLabel9.setText("Số CMND:");

        cmbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioitinh.setEditor(null);
        cmbGioitinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbGioitinhMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(83, 58, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Thông Tin Khách Hàng");

        btnRefreshQLCD.setBackground(new java.awt.Color(240, 255, 182));
        btnRefreshQLCD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        btnRefreshQLCD.setToolTipText("Tải lại");
        btnRefreshQLCD.setBorder(null);
        btnRefreshQLCD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshQLCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshQLCDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTencudan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMacudan, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(cmbGioitinh, 0, 127, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 150, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(btnRefreshQLCD, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSocmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbGioitinh, txtQuequan, txtSdt, txtSocmt});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMacudan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTencudan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtQuequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtSocmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnRefreshQLCD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tblQuanLyCuDan.setBackground(new java.awt.Color(255, 233, 226));
        tblQuanLyCuDan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã cư dân", "Tên cư dân", "Ngày sinh", "Giới tính", "SĐT", "Số CMT", "Quê quán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuanLyCuDan.setToolTipText("Bảng Thông tin cư dân");
        tblQuanLyCuDan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyCuDanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblQuanLyCuDanMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLyCuDan);
        if (tblQuanLyCuDan.getColumnModel().getColumnCount() > 0) {
            tblQuanLyCuDan.getColumnModel().getColumn(0).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(1).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(2).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(3).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(4).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(5).setResizable(false);
            tblQuanLyCuDan.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel27.setText("Tìm kiếm:");

        txtTimKiem1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtTimKiem1.setForeground(new java.awt.Color(0, 0, 255));
        txtTimKiem1.setToolTipText("Nhập thông tin cần tìm kiếm");
        txtTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem1KeyReleased(evt);
            }
        });

        jButtonXoacd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/removeuser.png"))); // NOI18N
        jButtonXoacd.setText("Xóa Khách Hàng");
        jButtonXoacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoacdActionPerformed(evt);
            }
        });

        BtnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/adduser.png"))); // NOI18N
        BtnThem.setText("Thêm Khách Hàng");
        BtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edituser.png"))); // NOI18N
        btnSua.setText("Sửa Khách Hàng");
        btnSua.setToolTipText("Sửa thông tin cư dân");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabQuanlycudanLayout = new javax.swing.GroupLayout(tabQuanlycudan);
        tabQuanlycudan.setLayout(tabQuanlycudanLayout);
        tabQuanlycudanLayout.setHorizontalGroup(
            tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanlycudanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanlycudanLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addGroup(tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanlycudanLayout.createSequentialGroup()
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButtonXoacd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanlycudanLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnThem)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(228, 228, 228))
        );
        tabQuanlycudanLayout.setVerticalGroup(
            tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabQuanlycudanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnThem)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoacd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabQuanlycudanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabNhanvien.addTab("Quản lý Khách Hàng", tabQuanlycudan);

        tabThongtincanho.setBackground(new java.awt.Color(221, 255, 236));
        tabThongtincanho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 2));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(83, 58, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DANH SÁCH CĂN HỘ TRỐNG");

        tblThongTinCanHo.setBackground(new java.awt.Color(221, 255, 236));
        tblThongTinCanHo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 0), 2, true));
        tblThongTinCanHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã căn hộ", "Diện tích", "Giá", "Số phòng", "Tên khu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTinCanHo.setToolTipText("Bảng Thông tin căn hộ");
        tblThongTinCanHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThongTinCanHoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblThongTinCanHo);
        if (tblThongTinCanHo.getColumnModel().getColumnCount() > 0) {
            tblThongTinCanHo.getColumnModel().getColumn(0).setResizable(false);
            tblThongTinCanHo.getColumnModel().getColumn(1).setResizable(false);
            tblThongTinCanHo.getColumnModel().getColumn(2).setResizable(false);
            tblThongTinCanHo.getColumnModel().getColumn(3).setResizable(false);
            tblThongTinCanHo.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.setBackground(new java.awt.Color(221, 255, 236));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));

        jLabel17.setText("Mã khách hàng:");

        cmbMacudan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMacudanItemStateChanged(evt);
            }
        });
        cmbMacudan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMacudanActionPerformed(evt);
            }
        });

        jLabel18.setText("Tên khách hàng:");

        txtNgsinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgsinhActionPerformed(evt);
            }
        });

        jLabel19.setText("Ngày sinh:");

        jLabel20.setText("SĐT:");

        jLabel21.setText("Giới Tính:");

        jLabel22.setText("Địa chỉ:");

        jLabel23.setText("Số CMND:");

        cmbGioitinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cmbGioitinh1.setEditor(null);
        cmbGioitinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGioitinh1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(221, 255, 236));

        btnInhopdong.setBackground(new java.awt.Color(221, 255, 236));
        btnInhopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/printer.png"))); // NOI18N
        btnInhopdong.setToolTipText("In hợp đồng");
        btnInhopdong.setBorder(null);
        btnInhopdong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInhopdong.setPreferredSize(new java.awt.Dimension(121, 45));
        btnInhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhopdongActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(83, 58, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("THÔNG TIN GIAO DỊCH");

        chkLacudan.setBackground(new java.awt.Color(221, 255, 236));
        chkLacudan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        chkLacudan.setForeground(new java.awt.Color(83, 58, 255));
        chkLacudan.setText("Thiết Lập Mua Bán");
        chkLacudan.setToolTipText("");
        chkLacudan.setActionCommand("Chọn Cư Dân");
        chkLacudan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkLacudanMouseClicked(evt);
            }
        });
        chkLacudan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLacudanActionPerformed(evt);
            }
        });

        txtGiacanho.setForeground(new java.awt.Color(0, 0, 0));
        txtGiacanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiacanhoActionPerformed(evt);
            }
        });

        txtNgaygiaodich.setForeground(new java.awt.Color(0, 0, 0));

        txtMacanho1.setForeground(new java.awt.Color(0, 0, 0));
        txtMacanho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMacanho1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Giá căn hộ:");

        jLabel14.setText("Mã căn hộ:");

        jLabel16.setText("Ngày giao dịch:");

        jLabel10.setText("NV Phụ Trách :");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel35.setText("Số Đợt TT :");

        txtSoDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDotActionPerformed(evt);
            }
        });

        txtDienTichMB.setForeground(new java.awt.Color(0, 0, 0));

        jLabel37.setText("Số Phòng:");

        txtSoPhongMB.setForeground(new java.awt.Color(0, 0, 0));

        jLabel38.setText("Diện Tích:");

        jLabel39.setText("Tên Khu Căn Hộ:");

        txtKhuCHMB.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15)
                                                .addComponent(jLabel14))
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel39)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel21))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmbMacudan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgaygiaodich, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGiacanho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMacanho1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgsinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbGioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtScmt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDienTichMB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSoDot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSoPhongMB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKhuCHMB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(chkLacudan)
                                .addGap(94, 94, 94))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(txtMacanho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiacanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaygiaodich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtSoPhongMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDienTichMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(txtKhuCHMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkLacudan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbMacudan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtScmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoDot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jPanel12.setBackground(new java.awt.Color(221, 255, 236));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
        jPanel12.setToolTipText("Thanh tìm kiếm");
        jPanel12.setPreferredSize(new java.awt.Dimension(578, 60));

        btTim_CanHo.setBackground(new java.awt.Color(221, 255, 236));
        btTim_CanHo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btTim_CanHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        btTim_CanHo.setToolTipText("Tìm");
        btTim_CanHo.setBorder(null);
        btTim_CanHo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btTim_CanHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTim_CanHoActionPerformed(evt);
            }
        });

        cbbDienTich.setForeground(new java.awt.Color(0, 0, 204));
        cbbDienTich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ 30m² - 40m²", "Từ 40m² - 50mm²", "Trên 50m²" }));
        cbbDienTich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDienTichActionPerformed(evt);
            }
        });

        cbbGia.setForeground(new java.awt.Color(0, 0, 204));
        cbbGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dưới 1 tỷ", "Từ 1 tỷ - 2 tỷ", "Trên 2 tỷ", " " }));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setText("Diện tích");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel29.setText("Giá");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel30.setText("Số phòng");

        cmbSophong.setForeground(new java.awt.Color(0, 0, 204));
        cmbSophong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSophongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(cbbDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cbbGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cmbSophong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel28)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel29)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btTim_CanHo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbDienTich, cbbGia, cmbSophong});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel28))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(cbbGia)
                            .addComponent(cbbDienTich)
                            .addComponent(cmbSophong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btTim_CanHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnRefreshTTCH.setBackground(new java.awt.Color(221, 255, 236));
        btnRefreshTTCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        btnRefreshTTCH.setToolTipText("Refresh");
        btnRefreshTTCH.setBorder(null);
        btnRefreshTTCH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshTTCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTTCHActionPerformed(evt);
            }
        });

        tblPhanTich.setBackground(new java.awt.Color(221, 255, 236));
        tblPhanTich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Khu", "Tên Khu", "Số Căn Còn Trống", "Tỉ Lệ (%)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhanTich.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblPhanTich);
        if (tblPhanTich.getColumnModel().getColumnCount() > 0) {
            tblPhanTich.getColumnModel().getColumn(0).setResizable(false);
            tblPhanTich.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblPhanTich.getColumnModel().getColumn(1).setResizable(false);
            tblPhanTich.getColumnModel().getColumn(2).setResizable(false);
            tblPhanTich.getColumnModel().getColumn(3).setResizable(false);
            tblPhanTich.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout tabThongtincanhoLayout = new javax.swing.GroupLayout(tabThongtincanho);
        tabThongtincanho.setLayout(tabThongtincanhoLayout);
        tabThongtincanhoLayout.setHorizontalGroup(
            tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                .addGroup(tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                        .addGroup(tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnRefreshTTCH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabThongtincanhoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabThongtincanhoLayout.setVerticalGroup(
            tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                .addGroup(tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 728, Short.MAX_VALUE)
                    .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabThongtincanhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabThongtincanhoLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnRefreshTTCH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabNhanvien.addTab("Thiết Lập Mua Bán", tabThongtincanho);

        tabDotThanhToan.setBackground(new java.awt.Color(204, 255, 255));

        tblDotThanhToan.setBackground(new java.awt.Color(204, 255, 255));
        tblDotThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
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
        tblDotThanhToan.setRowHeight(40);
        tblDotThanhToan.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblDotThanhToan.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblDotThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDotThanhToanMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblDotThanhToan);
        tblDotThanhToan.getAccessibleContext().setAccessibleDescription("");

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(83, 58, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DANH SÁCH ĐỢT THANH TOÁN");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Tìm Kiếm :");

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));

        txtMaDotTT.setBackground(new java.awt.Color(204, 204, 204));
        txtMaDotTT.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        txtMaDotTT.setForeground(new java.awt.Color(0, 0, 0));
        txtMaDotTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDotTTActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setText("Mã Đợt Thanh Toán :");

        jLabel40.setBackground(new java.awt.Color(255, 255, 0));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("Tạo Giao Dịch Thanh Toán");

        txtSoTienGD.setBackground(new java.awt.Color(204, 204, 204));
        txtSoTienGD.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        txtSoTienGD.setForeground(new java.awt.Color(0, 0, 0));
        txtSoTienGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTienGDActionPerformed(evt);
            }
        });
        txtSoTienGD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoTienGDKeyReleased(evt);
            }
        });

        txtNhanVienGD.setBackground(new java.awt.Color(204, 204, 204));
        txtNhanVienGD.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        txtNhanVienGD.setForeground(new java.awt.Color(0, 0, 0));
        txtNhanVienGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienGDActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("Số Tiền Giao Dịch:");

        jButtonXacNhanGD.setBackground(new java.awt.Color(204, 204, 204));
        jButtonXacNhanGD.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jButtonXacNhanGD.setForeground(new java.awt.Color(0, 0, 0));
        jButtonXacNhanGD.setText("Xác Nhận");
        jButtonXacNhanGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanGDActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setText("Nhân Viên:");

        txtTienDTT.setBackground(new java.awt.Color(204, 204, 204));
        txtTienDTT.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        txtTienDTT.setForeground(new java.awt.Color(0, 0, 0));
        txtTienDTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienDTTActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setText("Số Tiền Cần Trả :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel42)
                            .addComponent(jLabel45)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNhanVienGD)
                            .addComponent(txtSoTienGD, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtMaDotTT)
                            .addComponent(txtTienDTT))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonXacNhanGD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtMaDotTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXacNhanGD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienDTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtSoTienGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhanVienGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabDotThanhToanLayout = new javax.swing.GroupLayout(tabDotThanhToan);
        tabDotThanhToan.setLayout(tabDotThanhToanLayout);
        tabDotThanhToanLayout.setHorizontalGroup(
            tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDotThanhToanLayout.createSequentialGroup()
                .addGap(0, 209, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addComponent(jScrollPane5)
            .addGroup(tabDotThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTimDtt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
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
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDotThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonIncomming)
                        .addComponent(jButtonlate)
                        .addComponent(jButtonReload)
                        .addComponent(jTextFieldTimDtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabNhanvien.addTab("Đợt Thanh Toán", tabDotThanhToan);

        tabGiaoDich.setBackground(new java.awt.Color(204, 204, 255));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(83, 58, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("DANH SÁCH GIAO DỊCH");

        tblGiaoDich.setBackground(new java.awt.Color(204, 204, 255));
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
        jScrollPane6.setViewportView(tblGiaoDich);

        jLabel44.setText("Tìm Kiếm :");

        jTextFieldGD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldGDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tabGiaoDichLayout = new javax.swing.GroupLayout(tabGiaoDich);
        tabGiaoDich.setLayout(tabGiaoDichLayout);
        tabGiaoDichLayout.setHorizontalGroup(
            tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addGroup(tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabGiaoDichLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabGiaoDichLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGD, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabGiaoDichLayout.setVerticalGroup(
            tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGiaoDichLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabGiaoDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextFieldGD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        tabNhanvien.addTab("Các Giao Dịch", tabGiaoDich);

        tabThongTinCaNhan.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel53.setText("Họ Tên :");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(83, 58, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("THÔNG TIN CÁ NHÂN");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel55.setText("Địa Chỉ :");

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel56.setText("Nhắc Lại Mật Khẩu :");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel57.setText("Mật Khẩu :");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel58.setText("Tên Đăng Nhập :");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel59.setText("SĐT :");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel60.setText("Email :");

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtEmailNV.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtUserNameNV.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtSDTNV.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtDiaChiNV.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtPasswordNV1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        txtPasswordNV2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        jButtonSaveNV.setBackground(new java.awt.Color(221, 255, 236));
        jButtonSaveNV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonSaveNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save_ql.png"))); // NOI18N
        jButtonSaveNV.setText("Save");
        jButtonSaveNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveNVActionPerformed(evt);
            }
        });

        jButtonReloadNV.setBackground(new java.awt.Color(221, 255, 236));
        jButtonReloadNV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonReloadNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rotation.png"))); // NOI18N
        jButtonReloadNV.setText("Reload");
        jButtonReloadNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel55))
                                .addGap(21, 21, 21)
                                .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel60))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenNV)
                                    .addComponent(txtEmailNV)
                                    .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPasswordNV1)
                            .addComponent(txtPasswordNV2)
                            .addComponent(txtUserNameNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(746, 746, 746)
                        .addComponent(jButtonSaveNV)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonReloadNV)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60)
                            .addComponent(txtPasswordNV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jLabel59)
                            .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasswordNV2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)
                            .addComponent(txtUserNameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveNV)
                    .addComponent(jButtonReloadNV))
                .addGap(260, 260, 260))
        );

        javax.swing.GroupLayout tabThongTinCaNhanLayout = new javax.swing.GroupLayout(tabThongTinCaNhan);
        tabThongTinCaNhan.setLayout(tabThongTinCaNhanLayout);
        tabThongTinCaNhanLayout.setHorizontalGroup(
            tabThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongTinCaNhanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabThongTinCaNhanLayout.setVerticalGroup(
            tabThongTinCaNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongTinCaNhanLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        tabNhanvien.addTab("Thông Tin Cá Nhân", tabThongTinCaNhan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(tabNhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1310, 876);
    }// </editor-fold>//GEN-END:initComponents
    public void showPhanTich() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        tblPhanTich.setModel(KhuCanHoBLL.showPhanTich()); // load data to table
        renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
        tblPhanTich.setDefaultRenderer(Object.class, renderer);// chỉ căn giữa dữ liệu là String

    }

    public void setTextFieldQLCD() {
        cmbGioitinh.setEnabled(false);
    }

    public void ClearTextTTCH() {
        cmbMacudan.setSelectedItem(null);
        cmbMacudan.setEnabled(false);
        txtTenkh.setText(null);
        txtTenkh.requestFocus();
        txtNgsinh.setText(null);
        cmbGioitinh1.setSelectedItem(null);
        txtSDT.setText(null);
        txtScmt.setText(null);
        txtDiachi.setText(null);
    }


    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        DangNhapUI dn = new DangNhapUI("Quản lý căn hộ");
        dn.showWindow();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tabNhanvienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabNhanvienMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabNhanvienMouseEntered

    private void jButtonXacNhanGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanGDActionPerformed
        // TODO add your handling code here:
        if (Long.valueOf(removeDelimitor(txtTienDTT.getText())) < removeDelimitor(txtSoTienGD.getText())) {
            JOptionPane.showMessageDialog(null, "Số Tiền đã vượt quá số Tiền thanh toán trong đợt");
        } else {
            try {
                GiaoDich gd = new GiaoDich();
                gd.setSoTien(removeDelimitor(txtSoTienGD.getText().trim()));
                gd.setMaNhanVien(txtNhanVienGD.getText());
                gd.setMaDotTT(txtMaDotTT.getText());
                BLL.GiaoDichBLL.insert(gd);

                DotThanhToan dtt = BLL.DotThanhToanBLL.findByID(txtMaDotTT.getText());
                BLL.DotThanhToanBLL.UpdateDTTMoney(dtt, gd.getSoTien());
                HopDong hd = BLL.HopDongBLL.findByID(dtt.getMaHopDong());
                BLL.HopDongBLL.UpdateHDMoney(hd, gd.getSoTien());
                CuDan cd = BLL.QuanLyCuDanBLL.findByID(hd.getMaCuDan());

                System.out.println(hd.toString());
                //hd, dtt, gd, nv, cd
                CreateWordFile(hd, dtt, gd, nv, cd);
                String text = "BienBanGiaoDich_" + gd.getMaGiaoDich() + ".docx";
                Desktop.getDesktop().open(new File(text));

                BLL.DotThanhToanBLL.show(tblDotThanhToan);
                BLL.GiaoDichBLL.show(tblGiaoDich);

                JOptionPane.showMessageDialog(null, "Giao Dịch Thành Công");
            } catch (ParseException ex) {
                System.out.println("JButtonXacNhanGD Error " + ex.getMessage());
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonXacNhanGDActionPerformed

    private void txtNhanVienGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienGDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienGDActionPerformed

    private void txtMaDotTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDotTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDotTTActionPerformed

    private void jTextFieldTimDttKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimDttKeyReleased
        // TODO add your handling code here:
        try {
            BLL.DotThanhToanBLL.search(tblDotThanhToan, jTextFieldTimDtt.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldTimDttKeyReleased

    private void jTextFieldTimDttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTimDttActionPerformed
        // TODO add your handling code here:
        try {
            BLL.DotThanhToanBLL.search(tblDotThanhToan, jTextFieldTimDtt.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldTimDttActionPerformed

    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
        try {
            // TODO add your handling code here:
            BLL.DotThanhToanBLL.show(tblDotThanhToan);
        } catch (ParseException ex) {
            System.out.println("Error in jButton Reload " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonReloadActionPerformed

    private void jButtonlateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlateActionPerformed

        BLL.DotThanhToanBLL.lateDate(tblDotThanhToan);
    }//GEN-LAST:event_jButtonlateActionPerformed

    private void jButtonIncommingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncommingActionPerformed
        try {
            // TODO add your handling code here:
            BLL.DotThanhToanBLL.incommingDate(tblDotThanhToan);
        } catch (ParseException ex) {
            System.out.println("error incomming date " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonIncommingActionPerformed

    private void tblDotThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDotThanhToanMousePressed
        // TODO add your handling code here:
        int row = tblDotThanhToan.getSelectedRow();
        txtMaDotTT.setText(tblDotThanhToan.getValueAt(row, 1).toString());
        txtTienDTT.setText(tblDotThanhToan.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblDotThanhToanMousePressed

    private void btnRefreshTTCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTTCHActionPerformed
        try {
            BLL.ThongTinCanHoBLL.HienThongTinCanho(tblThongTinCanHo);
            cmbMacudan.setModel(cmb_BLL());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshTTCHActionPerformed

    private void cmbSophongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSophongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSophongActionPerformed

    private void cbbDienTichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDienTichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDienTichActionPerformed

    private void btTim_CanHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTim_CanHoActionPerformed
        try {
            float tuDienTich = 0;
            float denDienTich = 0;
            long tuGia = 0;
            long denGia = 0;
            int sophong = Integer.valueOf(cmbSophong.getSelectedItem().toString());
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
                    denGia = 1000000000 - 1;
                    break;
                case 1:
                    tuGia = 1000000000;
                    denGia = 2000000001;
                    break;
                default:
                    tuGia = 2000000000;
            }

            ThongTinCanHoBLL.TKThongTinCanho(tblThongTinCanHo, tuDienTich, denDienTich, tuGia, denGia, sophong);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btTim_CanHoActionPerformed

    private void txtSoDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDotActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtMacanho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMacanho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMacanho1ActionPerformed

    private void txtGiacanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiacanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiacanhoActionPerformed

    private void chkLacudanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLacudanActionPerformed
        try {
            cmbMacudan.setModel(cmb_BLL());        // TODO add your handling code here:
            txtMaNV.setText(nv.getMaNhanVien());
            txtMaNV.setEditable(false);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkLacudanActionPerformed

    private void chkLacudanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkLacudanMouseClicked
        if (chkLacudan.isSelected()) {
            cmbMacudan.setEnabled(true);
            txtTenkh.setEditable(false);
            txtNgsinh.setEditable(false);
            cmbGioitinh1.setEnabled(false);
            txtSDT.setEditable(false);
            txtScmt.setEditable(false);
            txtDiachi.setEditable(false);
        } else {
            ClearTextTTCH();

            cmbMacudan.setEnabled(false);
            txtTenkh.setEditable(true);
            txtNgsinh.setEditable(true);
            cmbGioitinh1.setEnabled(true);
            txtSDT.setEditable(true);
            txtScmt.setEditable(true);
            txtDiachi.setEditable(true);
        }
    }//GEN-LAST:event_chkLacudanMouseClicked

    private void btnInhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhopdongActionPerformed

        try {
            if (txtMacanho1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Chọn căn hộ.", ERROR, JOptionPane.ERROR_MESSAGE);
            } else if (txtTenkh.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập tên khách hàng.", ERROR, JOptionPane.ERROR_MESSAGE);
            } else if (txtNgsinh.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkDateTime(txtNgsinh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (cmbGioitinh1.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Chọn giới tính.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSDT.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập số điện thoại.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtScmt.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập số chứng minh nhân dân.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtDiachi.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nhập địa chỉ.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                List<CuDan> dsCuDan = dsCuDan();
                String mcd = "111111";
                String maHopDong = "";

                if (chkLacudan.isSelected()) {
                    mcd = cmbMacudan.getSelectedItem().toString();
                } else {
                    for (CuDan cd : dsCuDan) {
                        if (cd.getMaCuDan().equals(mcd)) {
                            mcd = String.valueOf(Integer.parseInt(mcd) + 1);
                        }
                    }
                    BLL.QuanLyCuDanBLL.insertCD_BLL(mcd, txtTenkh, txtNgsinh, cmbGioitinh1, txtSDT, txtScmt, txtDiachi);
                }
                HopDong hd = getHopDongMuaBan();
                CuDan cd = getCuDanMuaBan();
                CanHo ch = getCanHoMuaBan();
                XacNhanThanhToan xn = new XacNhanThanhToan(cd, hd, ch, nv, this);
                xn.setVisible(true);
                //                BLL.ThongTinCanHoBLL.updateCH_BLL(txtMacanho1.getText(), mcd);
                //                String mahd = BLL.HopDongBLL.insertHD_BLL(txtDiachi.getText(), mcd, txtMacanho1.getText(), txtTenkh.getText(), txtCoc.getText(), txtThoiHan.getText());
                //                                showPhanTich();
                //                BLL.ThongTinCanHoBLL.HienThongTinCanho(tblThongTinCanHo);
                //                BLL.DotThanhToanBLL.show(tblDotThanhToan);

                //                JOptionPane.showMessageDialog(null, "Thêm hợp đồng thành công.", "Thông tin", JOptionPane.INFORMATION_MESSAGE);
                //
                //                AutomaticallyClosedMsgBox(1500, "Đang tạo hợp đồng.\nXin hãy đợi....");
                //               CreateWordFile(mahd);
                //
                //                AutomaticallyClosedMsgBox(2000, "Thực hiện mở hợp đồng.\n.....");
                //                String text = "HopDongMuaBanCanHo_" + mahd + ".docx";
                //                Desktop.getDesktop().open(new File(text));
            }
        } catch (SQLException e) {
            System.out.println("Error in btnInhopdong: " + e.getMessage());
        } catch (HeadlessException e) {
            System.out.println("Many errors: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Khách hàng này chưa là cư dân.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Hợp đồng không tồn tại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table
        renderer.setHorizontalAlignment(JLabel.CENTER);// Căn giữa dữ liệu bảng
        renderer.removeAll();
        try {
            BLL.HopDongBLL.HienThongTinMuaBan(tblThongTinMuaBan);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblThongTinMuaBan.setDefaultRenderer(Object.class, renderer);
    }//GEN-LAST:event_btnInhopdongActionPerformed

    private void cmbGioitinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGioitinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGioitinh1ActionPerformed

    private void txtNgsinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgsinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgsinhActionPerformed

    private void cmbMacudanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMacudanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMacudanActionPerformed

    private void cmbMacudanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMacudanItemStateChanged
        try {
            List<CuDan> dsCuDan = dsCuDan();
            String mcd;
            if (chkLacudan.isSelected()) {
                mcd = cmbMacudan.getSelectedItem().toString();
                for (CuDan cd : dsCuDan) {
                    if (mcd.equals(cd.getMaCuDan())) {
                        txtTenkh.setText(cd.getTenCuDan());
                        txtNgsinh.setText(cd.getNgaySinh());
                        if (cd.isGioiTinh() == true) {
                            cmbGioitinh1.setSelectedIndex(0);
                        } else {
                            cmbGioitinh1.setSelectedIndex(1);
                        }
                        txtSDT.setText(cd.getSoDT());
                        txtScmt.setText(cd.getSoCMT());
                        txtDiachi.setText(cd.getQueQuan());
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbMacudanItemStateChanged

    private void tblThongTinCanHoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinCanHoMousePressed
        // TODO add your handling code here:
        int row = tblThongTinCanHo.getSelectedRow();
        txtMacanho1.setText(tblThongTinCanHo.getValueAt(row, 0).toString());
        String giaCh = tblThongTinCanHo.getValueAt(row, 2).toString();
        txtGiacanho.setText("" + removeDelimitor(giaCh));
        txtSoPhongMB.setText(tblThongTinCanHo.getValueAt(row, 3).toString());
        txtDienTichMB.setText(tblThongTinCanHo.getValueAt(row, 1).toString());
        txtKhuCHMB.setText(tblThongTinCanHo.getValueAt(row, 4).toString());
        //get today
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.now();
        txtNgaygiaodich.setText(dtf.format(ld));
    }//GEN-LAST:event_tblThongTinCanHoMousePressed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (txtMacudan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Chọn mã cư dân.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtTencudan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Tên cư dân trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtNgaysinh.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ngày sinh trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkDateTime(txtNgaysinh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSdt.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số điện thoại trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSocmt.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số CMND trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtQuequan.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Quê quán trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BLL.QuanLyCuDanBLL.updateCD_BLL(txtMacudan, txtTencudan, txtNgaysinh, cmbGioitinh, txtSdt, txtSocmt, txtQuequan);
                BLL.HopDongBLL.UpdateHD_BLL(txtQuequan.getText(), txtMacudan.getText(), txtTencudan.getText());
                BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblQuanLyCuDan);
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

    private void BtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnThemActionPerformed
        // TODO add your handling code here:
        try {
            if (txtMacudan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Chọn mã cư dân.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtTencudan.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Tên cư dân trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtNgaysinh.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ngày sinh trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkDateTime(txtNgaysinh.getText())) {
                JOptionPane.showMessageDialog(null, "Nhập sai ngày sinh.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSdt.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số điện thoại trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtSocmt.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Số CMND trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (txtQuequan.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Quê quán trống.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkPhoneNumber(txtSdt.getText())) {
                JOptionPane.showMessageDialog(null, "SĐT phải gồm 10 số.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!RegexExpression.checkID(txtSocmt.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Số CMND gồm 9 hoặc 12 số.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (QuanLyCuDanBLL.insertCD_BLL(txtMacudan.getText(), txtTencudan, txtNgaysinh, cmbGioitinh, txtSdt, txtSocmt, txtQuequan)) {
                    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();// đối tượng thao tác với ô trong table
                    renderer.setHorizontalAlignment(JLabel.CENTER);//
                    tblQuanLyCuDan.setModel(new DefaultTableModel(null, new String[]{}));
                    BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblQuanLyCuDan);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    tblQuanLyCuDan.setDefaultRenderer(Object.class, renderer);

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

    private void jButtonXoacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoacdActionPerformed
        // TODO add your handling code here:
        try {
            if (BLL.QuanLyCuDanBLL.xuLyXoaCuDan(txtMacudan.getText().trim())) {
                tblQuanLyCuDan.setModel(new DefaultTableModel(null, new String[]{}));
                try {
                    BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblQuanLyCuDan);
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

    private void txtTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem1KeyReleased
        try {
            BLL.QuanLyCuDanBLL.TimKiemCD_BLL(tblQuanLyCuDan, txtTimKiem1.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiem1KeyReleased

    private void btnRefreshQLCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshQLCDActionPerformed
        try {
            BLL.QuanLyCuDanBLL.HienThongTinCuDan(tblQuanLyCuDan);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshQLCDActionPerformed

    private void cmbGioitinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGioitinhMouseClicked
        cmbGioitinh.setEnabled(true);
    }//GEN-LAST:event_cmbGioitinhMouseClicked

    private void txtSocmtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSocmtMouseClicked
        txtSocmt.setEditable(true);
        txtSocmt.requestFocus();
    }//GEN-LAST:event_txtSocmtMouseClicked

    private void txtQuequanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuequanMouseClicked
        txtQuequan.setEditable(true);
        txtQuequan.requestFocus();
    }//GEN-LAST:event_txtQuequanMouseClicked

    private void txtNgaysinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaysinhMouseClicked
        txtNgaysinh.setEditable(true);
        txtNgaysinh.requestFocus();
    }//GEN-LAST:event_txtNgaysinhMouseClicked

    private void txtTencudanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTencudanMouseClicked
        txtTencudan.setEditable(true);
        txtTencudan.requestFocus();
    }//GEN-LAST:event_txtTencudanMouseClicked

    private void txtSdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSdtMouseClicked
        txtSdt.setEditable(true);
        txtSdt.requestFocus();
    }//GEN-LAST:event_txtSdtMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        try {
            BLL.HopDongBLL.TimKiem_BLL(tblThongTinMuaBan, txtTimKiem.getText());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnRefreshTTMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTTMBActionPerformed
        try {
            txtTimKiem.setText(null);
            BLL.HopDongBLL.HienThongTinMuaBan(tblThongTinMuaBan);
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshTTMBActionPerformed

    private void jButtonReloadNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadNVActionPerformed
        // TODO add your handling code here:
        reloadNV();
    }//GEN-LAST:event_jButtonReloadNVActionPerformed
    private void reloadNV() {
        txtTenNV.setText(nv.getHoTen());
        txtEmailNV.setText(nv.getEmail());
        txtDiaChiNV.setText(nv.getDiaChi());
        txtSDTNV.setText(nv.getSDT());
        txtUserNameNV.setText(nv.getMaNhanVien());
        txtPasswordNV1.setText(nv.getMatKhau());
        txtPasswordNV2.setText(nv.getMatKhau());
        txtUserNameNV.setEditable(false);
        txtEmailNV.setEditable(false);
    }
    private void jButtonSaveNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveNVActionPerformed
        // TODO add your handling code here:
        NhanVien nv1 = new NhanVien();
        nv1.setHoTen(txtTenNV.getText().trim());
        nv1.setEmail(txtEmailNV.getText().trim());
        nv1.setDiaChi(txtDiaChiNV.getText().trim());
        nv1.setSDT(txtSDTNV.getText().trim());
        nv1.setMaNhanVien(nv.getMaNhanVien());
        nv1.setMatKhau(txtPasswordNV1.getText().trim());

        boolean update = BLL.NhanVienBLL.update(nv1);
        if (update == true) {
            nv = nv1;
            JOptionPane.showMessageDialog(null, "Thay Đổi Thành Công ");
            reloadNV();
            System.out.println(nv.getHoTen() + "Alo");
        }
        if (update == false) {
            JOptionPane.showMessageDialog(null, "Không thay đổi được");
        }
    }//GEN-LAST:event_jButtonSaveNVActionPerformed

    private void jTextFieldGDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGDKeyReleased
        // TODO add your handling code here:
        try {
            BLL.GiaoDichBLL.search(tblGiaoDich, jTextFieldGD.getText());
        } catch (Exception ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldGDKeyReleased

    private void txtTienDTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienDTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienDTTActionPerformed

    private void tblQuanLyCuDanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyCuDanMousePressed
        // TODO add your handling code here:
        setTextFieldQLCD();
        int row = tblQuanLyCuDan.getSelectedRow();
        txtMacudan.setText(tblQuanLyCuDan.getValueAt(row, 0).toString());
        txtTencudan.setText(tblQuanLyCuDan.getValueAt(row, 1).toString());
        txtNgaysinh.setText(tblQuanLyCuDan.getValueAt(row, 2).toString());
        cmbGioitinh.setSelectedItem(tblQuanLyCuDan.getValueAt(row, 3).toString());
        txtSdt.setText(tblQuanLyCuDan.getValueAt(row, 4).toString());
        txtSocmt.setText(tblQuanLyCuDan.getValueAt(row, 5).toString());
        txtQuequan.setText(tblQuanLyCuDan.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblQuanLyCuDanMousePressed

    private void tblQuanLyCuDanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyCuDanMouseClicked

    }//GEN-LAST:event_tblQuanLyCuDanMouseClicked

    private void txtSoTienGDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoTienGDKeyReleased
        // TODO add your handling code here:

        String SoTienGD = addDelimitor(removeDelimitor(txtSoTienGD.getText().trim()));
        txtSoTienGD.setText(SoTienGD);
    }//GEN-LAST:event_txtSoTienGDKeyReleased

    private void txtSoTienGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTienGDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSoTienGDActionPerformed
    public void reloadtblMuaBan() throws SQLException, ParseException {
        BLL.ThongTinCanHoBLL.HienThongTinCanho(tblThongTinCanHo);
        BLL.DotThanhToanBLL.show(tblDotThanhToan);

    }

    public void reloadtblHopDong() throws SQLException, ParseException, Exception {
        BLL.HopDongBLL.HienThongTinMuaBan(tblThongTinMuaBan);

    }

    private HopDong getHopDongMuaBan() {
        HopDong hd = new HopDong();
        hd.setMaCanHo(txtMacanho1.getText());
        hd.setGia(Long.valueOf(txtGiacanho.getText()));
        hd.setNgayGiaoDich(txtNgaygiaodich.getText());
        hd.setMaCuDan(cmbMacudan.getSelectedItem().toString());
        hd.setMaNhanVien(txtMaNV.getText());
        hd.setTenKH(txtTenkh.getText());
        hd.setSoDot(Integer.valueOf(txtSoDot.getText()));
        hd.setDiaChiKhachHang(txtDiachi.getText());
        return hd;
    }

    private CuDan getCuDanMuaBan() {
        CuDan cd = new CuDan();
        cd.setMaCuDan(cmbMacudan.getSelectedItem().toString());
        cd.setTenCuDan(txtTenkh.getText());
        cd.setNgaySinh(txtNgsinh.getText());
        cd.setSoDT(txtSDT.getText());
        cd.setSoCMT(txtScmt.getText());
        return cd;
    }

    private CanHo getCanHoMuaBan() {
        CanHo ch = new CanHo();
        ch.setMaCanHo(txtMacanho1.getText());
        ch.setGia(Long.valueOf(txtGiacanho.getText()));
        ch.setSoPhong(Integer.valueOf(txtSoPhongMB.getText()));
        ch.setDienTich(Float.valueOf(txtDienTichMB.getText()));
        ch.setTenKhu(txtKhuCHMB.getText());
        return ch;
    }

    private String addDelimitor(Long number) {
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

    public void CreateWordFile(HopDong hd, DotThanhToan dtt, GiaoDich gd, NhanVien nv, CuDan cd) {
        try {
            CreateTransaction contract = new CreateTransaction();
            contract.CreateTransaction(hd, dtt, gd, nv, cd);
        } catch (Exception ex) {
            System.out.println("Error CreateWord " + ex.getMessage());
        }
    }

    public void AutomaticallyClosedMsgBox(long time, String text) {
        JOptionPane jop = new JOptionPane();
        jop.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        jop.setMessage(text);
        JDialog dialog = jop.createDialog(null, "Thông báo");

        // Set timer
        new Thread(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            dialog.dispose();
        }).start();

        dialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnThem;
    private javax.swing.JButton btTim_CanHo;
    private javax.swing.JButton btnInhopdong;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefreshQLCD;
    private javax.swing.JButton btnRefreshTTCH;
    private javax.swing.JButton btnRefreshTTMB;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cbbDienTich;
    private javax.swing.JComboBox<String> cbbGia;
    private javax.swing.JCheckBox chkLacudan;
    private javax.swing.JComboBox<String> cmbGioitinh;
    private javax.swing.JComboBox<String> cmbGioitinh1;
    private javax.swing.JComboBox<String> cmbMacudan;
    private javax.swing.JComboBox<String> cmbSophong;
    private javax.swing.JButton jButtonIncomming;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonReloadNV;
    private javax.swing.JButton jButtonSaveNV;
    private javax.swing.JButton jButtonXacNhanGD;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextFieldGD;
    private javax.swing.JTextField jTextFieldTimDtt;
    private javax.swing.JPanel tabDotThanhToan;
    private javax.swing.JPanel tabGiaoDich;
    private javax.swing.JTabbedPane tabNhanvien;
    private javax.swing.JPanel tabQuanlycudan;
    private javax.swing.JPanel tabThongTinCaNhan;
    private javax.swing.JPanel tabThongtincanho;
    private javax.swing.JPanel tabThongtinmuaban;
    private javax.swing.JTable tblDotThanhToan;
    private javax.swing.JTable tblGiaoDich;
    private javax.swing.JTable tblPhanTich;
    private javax.swing.JTable tblQuanLyCuDan;
    private javax.swing.JTable tblThongTinCanHo;
    private javax.swing.JTable tblThongTinMuaBan;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtDienTichMB;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtGiacanho;
    private javax.swing.JTextField txtKhuCHMB;
    private javax.swing.JTextField txtMaDotTT;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMacanho1;
    private javax.swing.JTextField txtMacudan;
    private javax.swing.JTextField txtNgaygiaodich;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtNgsinh;
    private javax.swing.JTextField txtNhanVienGD;
    private javax.swing.JPasswordField txtPasswordNV1;
    private javax.swing.JPasswordField txtPasswordNV2;
    private javax.swing.JTextField txtQuequan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtScmt;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSoDot;
    private javax.swing.JTextField txtSoPhongMB;
    private javax.swing.JTextField txtSoTienGD;
    private javax.swing.JTextField txtSocmt;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTencudan;
    private javax.swing.JTextField txtTenkh;
    private javax.swing.JTextField txtTienDTT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtUserNameNV;
    // End of variables declaration//GEN-END:variables
}
