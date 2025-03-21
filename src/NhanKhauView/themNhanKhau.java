/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NhanKhauView;

import controller.NhanKhauController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import model.NhanKhauModel;
import NhanKhauController.themNhanKhauController;
import view.NhanKhauView;
import controller.HoKhauController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.HoKhauModel;
import model.ThanhVienModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author MY PC
 */
public class themNhanKhau extends javax.swing.JFrame {

    /**
     * Creates new form themNhanKhau
     */
    themNhanKhauController nkControl;
    NhanKhauView view;
    public String option;
    private String CCCD="";
    
    public themNhanKhau(String option,String CCCD,String maHK) {
    	setTitle("Thêm nhân khẩu");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(themNhanKhau.class.getResource("/img/apartment_13889041-min.png")));
        initComponents();
        
        this.setLocationRelativeTo(null);
        nkControl = new themNhanKhauController(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.CCCD = CCCD;
        this.option = option;
        
        if(option.equals("add")){
            setTitle("Thêm mới nhân khẩu");
            this.choPhepSua();
            this.xoaForm();
            this.chuyendinoikhac.setVisible(false);
            this.TinhTrangBox.setVisible(true);
        }else if (option.equals("xem")){
            setTitle("Xem nhân khẩu");
            this.xoaForm();
            this.chanSua();
            this.nkControl.xemNhanKhau(CCCD);
            this.nkControl.xemHoKhau(maHK);
            try{
                this.nkControl.xemThanhVien(CCCD);
                this.chuyendinoikhac.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(option.equals("edit")){
            setTitle("Sửa nhân khẩu");
            this.choPhepSua();
            this.xoaForm();
            this.jLabel11.setVisible(true);
            this.TinhTrangBox.setVisible(true);
            this.cccdText.setEditable(false);
            this.nkControl.xemNhanKhau(CCCD);
            this.nkControl.xemHoKhau(maHK);
            this.jButton3.setVisible(false);
            this.chuyendinoikhac.setVisible(false);
            try{
                this.nkControl.xemThanhVien(CCCD);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        this.setVisible(true);
        
        
    }
    
    public void chonHoKhau(String maHK){
        this.nkControl.xemHoKhau(maHK);
    }
    
    public void choPhepSua(){
        this.cccdText.setEditable(true);
        this.nameText.setEditable(true);
        this.countryText.setEditable(true);
        this.regionText.setEditable(true);
        this.ngaySinhText.setEnabled(true);
        this.jobText.setEditable(true);
        this.workText.setEditable(true);
        this.queText.setEditable(true);
        this.sexBox.setEnabled(true);
        this.qhChuHoText.setEditable(true);
        this.TinhTrangBox.setEnabled(false);
        this.TinhTrangBox.setEnabled(false);
    }
    
    public void chanSua(){
        this.cccdText.setEditable(false);
        this.nameText.setEditable(false);
        this.countryText.setEditable(false);
        this.regionText.setEditable(false);
        this.ngaySinhText.setEnabled(false);
        this.jobText.setEditable(false);
        this.workText.setEditable(false);
        this.queText.setEditable(false);
        this.sexBox.setEnabled(false);
        this.qhChuHoText.setEditable(false);
        this.TinhTrangBox.setEnabled(false);
        
    }
    
    public void hienThiHoKhau(HoKhauModel hk){
        this.soNhaText.setText(hk.getSoNha());
        this.loaiSoText.setText(hk.getLoaiSo());
        this.tenChuHoText.setText(hk.getTenChu());
        this.CCCDCHuHoText.setText(hk.getId_chu()+"");
        if(this.loaiSoText.getText().equals("Thường trú") && option.equals("add"))
            this.TinhTrangBox.setEnabled(true);
        else this.TinhTrangBox.setEnabled(false);
    }
    
    public void hienThiThanhVien(ThanhVienModel tv){
        this.qhChuHoText.setText(tv.getQuanHeVoiChuHo());
    }
    
    
    public void hienThiNhanKhau(NhanKhauModel nk){
        
        
        this.TinhTrangBox.setVisible(true);
        this.TinhTrangBox.setSelectedItem(nk.getTinhTrang());
        this.TinhTrangBox.setEnabled(false);
        
        if(option.equals("xem")){
            this.jButton1.setVisible(false);
            this.jButton4.setVisible(false);
            this.jButton3.setVisible(false);
        }else if(option.equals("edit") || option.equals("add")){
            this.jButton1.setVisible(true);
            this.jButton4.setVisible(true);
            this.jButton3.setVisible(true);
        }
                    
        this.sexBox.setSelectedItem(nk.getGioiTinh());
        this.cccdText.setText(nk.getCCCD());
        this.nameText.setText(nk.getHoTen());
        this.countryText.setText(nk.getQuocTich());
        this.regionText.setText(nk.getDanToc());
        this.ngaySinhText.setDate(nk.getNamSinh());
        this.jobText.setText(nk.getNgheNghiep());
        this.workText.setText(nk.getNoiLamViec());
        this.queText.setText(nk.getNguyenQuan());

        //this.TinhTrangBox.setText(nk.getTinhTrang());
    }
    
    public void xoaForm(){
        if(option.equals("add")){
            this.cccdText.setText("");
        }
        this.nameText.setText("");
        this.countryText.setText("");
        this.regionText.setText("");
        this.ngaySinhText.cleanup();
        this.jobText.setText("");
        this.workText.setText("");
        this.queText.setText("");  
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(0, 102, 153));
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(new Color(0, 102, 153));
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setForeground(new Color(0, 102, 153));
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setForeground(new Color(0, 102, 153));
        jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setForeground(new Color(0, 102, 153));
        jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setForeground(new Color(0, 102, 153));
        jLabel6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setForeground(new Color(0, 102, 153));
        jLabel7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel8 = new javax.swing.JLabel();
        jLabel8.setForeground(new Color(0, 102, 153));
        jLabel8.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel9 = new javax.swing.JLabel();
        jLabel9.setForeground(new Color(0, 102, 153));
        jLabel9.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameText = new javax.swing.JTextField();
        cccdText = new javax.swing.JTextField();
        regionText = new javax.swing.JTextField();
        countryText = new javax.swing.JTextField();
        workText = new javax.swing.JTextField();
        jobText = new javax.swing.JTextField();
        queText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.setBorderPainted(false);
        jButton2 = new javax.swing.JButton();
        jButton2.setBorderPainted(false);
        jButton4 = new javax.swing.JButton();
        jButton4.setBorderPainted(false);
        jLabel11 = new javax.swing.JLabel();
        jLabel11.setForeground(new Color(0, 102, 153));
        jLabel11.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(255, 255, 255));
        jButton3 = new javax.swing.JButton();
        jButton3.setBorderPainted(false);
        jLabel13 = new javax.swing.JLabel();
        jLabel13.setForeground(new Color(0, 102, 153));
        jLabel13.setFont(new Font("Tahoma", Font.PLAIN, 13));
        soNhaText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel14.setForeground(new Color(0, 102, 153));
        jLabel14.setFont(new Font("Tahoma", Font.PLAIN, 13));
        loaiSoText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel15.setForeground(new Color(0, 102, 153));
        jLabel15.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tenChuHoText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel16.setForeground(new Color(0, 102, 153));
        jLabel16.setFont(new Font("Tahoma", Font.PLAIN, 13));
        CCCDCHuHoText = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel18.setForeground(new Color(0, 102, 153));
        jLabel18.setFont(new Font("Tahoma", Font.PLAIN, 13));
        qhChuHoText = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TinhTrangBox = new javax.swing.JComboBox<>();
        chuyendinoikhac = new javax.swing.JButton();
        chuyendinoikhac.setBorderPainted(false);
        sexBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ngaySinhText = new com.toedter.calendar.JDateChooser();
        ngaySinhText.getCalendarButton().setBackground(Color.white);
        ngaySinhText.getCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(230, 242, 255));
        jPanel1.setBorder(null); // NOI18N

        jLabel1.setText("Họ và tên: ");

        jLabel2.setText("CCCD:");

        jLabel3.setText("Ngày sinh: ");

        jLabel4.setText("Giới tính:");

        jLabel5.setText("Dân tộc:");

        jLabel6.setText("Quốc tịch:");

        jLabel7.setText("Nơi làm việc");

        jLabel8.setText("Nghề nghiệp");

        jLabel9.setText("Quê quán:");

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        cccdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cccdTextActionPerformed(evt);
            }
        });

        regionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionTextActionPerformed(evt);
            }
        });

        countryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryTextActionPerformed(evt);
            }
        });

        workText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workTextActionPerformed(evt);
            }
        });

        jobText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTextActionPerformed(evt);
            }
        });

        queText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queTextActionPerformed(evt);
            }
        });

        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Xóa hết");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Tình trạng");

        jPanel2.setBorder(new LineBorder(new Color(0, 102, 153), 1, true)); // NOI18N

        jButton3.setText("Chọn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel13.setText("Số nhà:");

        soNhaText.setEditable(false);

        jLabel14.setText("Loại số:");

        loaiSoText.setEditable(false);

        jLabel15.setText("Tên chủ hộ:");

        tenChuHoText.setEditable(false);

        jLabel16.setText("CCCD:");

        CCCDCHuHoText.setEditable(false);
        CCCDCHuHoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCCDCHuHoTextActionPerformed(evt);
            }
        });

        jLabel18.setText("Quan hệ với chủ hộ:");

        qhChuHoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qhChuHoTextActionPerformed(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("(*)");

        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("(*)");
        
        lblThngTinH = new JLabel();
        lblThngTinH.setText("Thông tin hộ khẩu");
        lblThngTinH.setForeground(new Color(0, 102, 153));
        lblThngTinH.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGap(0, 26, Short.MAX_VALUE)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel13)
        								.addComponent(jLabel14))
        							.addGap(42)
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(soNhaText, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        								.addComponent(loaiSoText))
        							.addGap(54))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jButton3)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel27)
        							.addGap(342)))
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(tenChuHoText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        							.addGap(56)
        							.addComponent(CCCDCHuHoText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(qhChuHoText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jLabel26)
        					.addGap(7))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(lblThngTinH, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(578, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addComponent(lblThngTinH, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel15)
        				.addComponent(tenChuHoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton3)
        				.addComponent(jLabel27))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel13)
        				.addComponent(soNhaText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel16)
        				.addComponent(CCCDCHuHoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel14)
        				.addComponent(loaiSoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel18)
        				.addComponent(qhChuHoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel26))
        			.addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        TinhTrangBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thường trú", "Tạm trú" }));
        TinhTrangBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TinhTrangBoxActionPerformed(evt);
            }
        });

        chuyendinoikhac.setText("Chuyển đi nơi khác");
        chuyendinoikhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyendinoikhacActionPerformed(evt);
            }
        });

        sexBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("(*)");

        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("(*)");

        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("(*)");

        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("(*)");

        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("(*)");

        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("(*)");

        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("(*)");

        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("(*)");

        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("(*)");

        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("(*)");

        ngaySinhText.setDateFormatString("yyyy-MM-dd");
        
        lblThngTinNhn = new JLabel();
        lblThngTinNhn.setText("Thông tin nhân khẩu");
        lblThngTinNhn.setForeground(new Color(0, 102, 153));
        lblThngTinNhn.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(25)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(lblThngTinNhn, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        						.addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(83)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(workText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        								.addComponent(countryText, Alignment.LEADING)
        								.addComponent(cccdText)
        								.addComponent(TinhTrangBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(ngaySinhText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel12)
        								.addComponent(jLabel17)
        								.addComponent(jLabel19)
        								.addComponent(jLabel20)
        								.addComponent(jLabel21)))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(nameText, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel10)))
        					.addGap(31)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(chuyendinoikhac)
        							.addContainerGap(216, Short.MAX_VALUE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel8)
        								.addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(queText, 203, 203, 203)
        								.addComponent(regionText, 203, 203, 203)
        								.addComponent(sexBox, 0, 203, Short.MAX_VALUE)
        								.addComponent(jobText, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel22)
        								.addComponent(jLabel23)
        								.addComponent(jLabel24)
        								.addComponent(jLabel25))
        							.addGap(29))))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(567, Short.MAX_VALUE)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jButton4)
        			.addGap(18)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(lblThngTinNhn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(chuyendinoikhac)
        				.addComponent(jLabel10))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(cccdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4)
        				.addComponent(sexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel12)
        				.addComponent(jLabel25))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel3)
        					.addComponent(jLabel9)
        					.addComponent(queText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel17)
        					.addComponent(jLabel22))
        				.addComponent(ngaySinhText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(countryText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(regionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel19)
        				.addComponent(jLabel23))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(workText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8)
        				.addComponent(jobText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel20)
        				.addComponent(jLabel24))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel11)
        					.addComponent(TinhTrangBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel21))
        			.addGap(23)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
        			.addGap(17)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton2)
        				.addComponent(jButton1)
        				.addComponent(jButton4))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void cccdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cccdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cccdTextActionPerformed

    private void regionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regionTextActionPerformed

    private void countryTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextActionPerformed

    private void workTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workTextActionPerformed

    private void jobTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTextActionPerformed

    private void queTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date namSinh;
    try{
        String ngaySinh = dateFormat.format(this.ngaySinhText.getDate());
        namSinh = dateFormat.parse(ngaySinh);
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");  
        return;
    }
    
    if(this.cccdText.getText().equals("") || this.nameText.getText().equals("") 
            || this.regionText.getText().equals("")
            || this.countryText.getText().equals("")
            || this.workText.getText().equals("")
            || this.jobText.getText().equals("")
            || this.queText.getText().equals("")
            || this.soNhaText.getText().equals("")
            || this.qhChuHoText.getText().equals(""))  {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !");  
        return;
    }    
    

        
    String CCCD;
    String hoTen = this.nameText.getText();
    
    String gioiTinh = this.sexBox.getSelectedItem()+"";
    String nguyenQuan = this.queText.getText();
    String danToc = this.regionText.getText();
    String quocTich = this.countryText.getText();
    String noiLamViec = this.workText.getText();
    String ngheNghiep = this.jobText.getText();
    CCCD = this.cccdText.getText();
    String tinhTrang = this.TinhTrangBox.getSelectedItem()+"";
    if(tinhTrang.equals("Tạm trú") && option.equals("add")){
        tinhTrang = "Chưa khai báo";
    }else if(loaiSoText.equals("Thường trú") && option.equals("add") && tinhTrang.equals("Tạm trú")){
        tinhTrang = "Chưa khai báo";
    }
    
    NhanKhauModel nk = new NhanKhauModel(CCCD,hoTen,namSinh,gioiTinh,nguyenQuan,danToc,quocTich,noiLamViec,"BlueMoon",ngheNghiep,tinhTrang);
    
    String quanHeChuHo = this.qhChuHoText.getText();
    String maHK = this.soNhaText.getText();
    String nameTV = hoTen;
    
    ThanhVienModel tv = new ThanhVienModel(CCCD,maHK,quanHeChuHo,nameTV);

    
    if(option.equals("add")){
        if(this.nkControl.addNhanKhau(nk)){
            this.nkControl.addThanhVien(tv);
        }
    }
    else if(option.equals("edit")){
        this.nkControl.suaNhanKhau(CCCD, nk);
        this.nkControl.suaHoKhau(tv);
    }
        
    //this.setVisible(false);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            NhanKhauView viewMain = new NhanKhauView();
            this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            xoaForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CCCDCHuHoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCCDCHuHoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CCCDCHuHoTextActionPerformed

    private void qhChuHoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qhChuHoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qhChuHoTextActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        DanhSachHoKhau ds = new DanhSachHoKhau(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TinhTrangBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TinhTrangBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TinhTrangBoxActionPerformed

    private void chuyendinoikhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyendinoikhacActionPerformed
        if(!this.qhChuHoText.getText().equals("chủ hộ")){
            int response = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn chuyển đi nơi khác ?", "Chuyển đi nơi khác", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    nkControl.xoaNhanKhau(this.CCCD);
                }          
        }else{
            JOptionPane.showMessageDialog(this, "Bạn là chủ hộ, chuyển đi nơi khác ở Hộ Khẩu");
        }
    }//GEN-LAST:event_chuyendinoikhacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCDCHuHoText;
    private javax.swing.JComboBox<String> TinhTrangBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JTextField cccdText;
    private javax.swing.JButton chuyendinoikhac;
    private javax.swing.JTextField countryText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jobText;
    private javax.swing.JTextField loaiSoText;
    private javax.swing.JTextField nameText;
    private com.toedter.calendar.JDateChooser ngaySinhText;
    private javax.swing.JTextField qhChuHoText;
    private javax.swing.JTextField queText;
    private javax.swing.JTextField regionText;
    private javax.swing.JComboBox<String> sexBox;
    private javax.swing.JTextField soNhaText;
    private javax.swing.JTextField tenChuHoText;
    private javax.swing.JTextField workText;
    private JLabel lblThngTinNhn;
    private JLabel lblThngTinH;
    // End of variables declaration//GEN-END:variables
}
