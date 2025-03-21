/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.NhanKhauController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.NhanKhauModel;
import NhanKhauView.themNhanKhau;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import controller.HoKhauController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import HoKhauView.QuanLiTinhTrangView;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Toolkit;

/**
 *
 * @author MY PC
 */
public class NhanKhauView extends javax.swing.JFrame {
    
    public DefaultTableModel table;
    NhanKhauModel nhankhau; 
    NhanKhauController nkControl;
    String option = new String();
    
    public NhanKhauView() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(NhanKhauView.class.getResource("/img/apartment_13889041-min.png")));
    	setResizable(false);
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Quản lý nhân khẩu");
        option = "main";
        this.setVisible(true);
        nkControl = new NhanKhauController(this);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {        
                MainView view = new MainView(LoginView.vaiTroQuanLy);    
                dispose();     
            }
        });

        table = (DefaultTableModel)jTable.getModel();  
        nkControl.getNhanKhauTable();
       
    }
    
    public void xoaBang(){
    int rowCount = table.getRowCount();
    for (int i = rowCount - 1; i >= 0; i--) {
        table.removeRow(i);
}
    }
    
    public void hienThiBangNhanKhau(ArrayList<NhanKhauModel>list){
      for(NhanKhauModel i : list){
        table.addRow(new Object[]{i.getCCCD(),i.getHoTen(), i.getNamSinh(), i.getGioiTinh(),i.getTinhTrang()});
      }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(0, 102, 153));
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tinhTrangBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(new Color(0, 102, 153));
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setForeground(new Color(0, 102, 153));
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        fromTuoi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setForeground(new Color(0, 102, 153));
        jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        toTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setForeground(new Color(0, 102, 153));
        jLabel5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        gioiTinhBox = new javax.swing.JComboBox<>();
        locBt = new javax.swing.JButton();
        locBt.setBorderPainted(false);
        jButton2 = new javax.swing.JButton();
        jButton2.setBorderPainted(false);
        jPanel4 = new javax.swing.JPanel();
        timKiemText = new javax.swing.JTextField();
        timKiemBt = new javax.swing.JButton();
        timKiemBt.setBorderPainted(false);
        jButton1 = new javax.swing.JButton();
        jButton1.setBorderPainted(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        add.setBorderPainted(false);
        chiTiet = new javax.swing.JButton();
        chiTiet.setBorderPainted(false);
        edit = new javax.swing.JButton();
        edit.setBorderPainted(false);
        add1 = new javax.swing.JButton();
        add1.setBorderPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hộ Khẩu");

        jPanel1.setBackground(new Color(230, 242, 255));

        jPanel2.setBackground(new Color(230, 242, 255));

        jLabel1.setText("Tình trạng: ");

        tinhTrangBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tạm trú", "Tạm vắng", "Thường trú", "Chưa khai báo" }));

        jLabel2.setText("Độ tuổi:");

        jLabel3.setText("Từ:");

        jLabel4.setText("Đến:");

        jLabel5.setText("Giới tính:");

        gioiTinhBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        gioiTinhBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gioiTinhBoxActionPerformed(evt);
            }
        });

        locBt.setText("Lọc");
        locBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locBtActionPerformed(evt);
            }
        });

        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tinhTrangBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gioiTinhBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locBt)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tinhTrangBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(fromTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(toTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(gioiTinhBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locBt)
                        .addComponent(jButton2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new Color(230, 242, 255));

        timKiemText.setText("CCCD/Họ và Tên");
        timKiemText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemTextActionPerformed(evt);
            }
        });

        timKiemBt.setText("Tìm kiếm");
        timKiemBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemBtActionPerformed(evt);
            }
        });

        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timKiemText, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(timKiemBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timKiemText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timKiemBt)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CCCD", "Họ và tên", "Ngày sinh", "Giới tính", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel3.setBackground(new Color(230, 242, 255));

        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        chiTiet.setText("Chi tiết");
        chiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiTietActionPerformed(evt);
            }
        });

        edit.setText("Chỉnh sửa");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        add1.setText("Tạm trú/Tạm vắng");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(add1)
        			.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
        			.addComponent(add, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(chiTiet)
        			.addGap(18)
        			.addComponent(edit)
        			.addGap(21))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(edit)
        				.addComponent(add1)
        				.addComponent(chiTiet)
        				.addComponent(add))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(11)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        option = "add";
        themNhanKhau view2 = new themNhanKhau(option,"","");
        this.setVisible(false);
            // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void gioiTinhBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gioiTinhBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_gioiTinhBoxActionPerformed

    private void chiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiTietActionPerformed
        int sRow = jTable.getSelectedRow();
        if(sRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn nhân khẩu");
            return;
        }
        
        String CCCD = (table.getValueAt(sRow, 0)+"");
        String maHK = this.nkControl.getThanhVien(CCCD).getIdHoKhau();
        
        option = "xem";
        themNhanKhau view2 = new themNhanKhau(option,CCCD,maHK);
        
        this.setVisible(false);
    }//GEN-LAST:event_chiTietActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        int sRow = jTable.getSelectedRow();
        if(sRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn nhân khẩu");
            return;
        }
        
        String CCCD = (table.getValueAt(sRow, 0)+"");
        String maHK = this.nkControl.getThanhVien(CCCD).getIdHoKhau();
        
        option = "edit";
        themNhanKhau view2 = new themNhanKhau(option,CCCD,maHK);
        this.setVisible(false);
    }//GEN-LAST:event_editActionPerformed

    private void timKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemBtActionPerformed
    if(option.equals("main") || option.equals("tim")){
        this.xoaBang();
        this.nkControl.timNhanKhau(this.timKiemText.getText());
        option = "tim";
        }
    }//GEN-LAST:event_timKiemBtActionPerformed

    private void timKiemTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemTextActionPerformed
            
    }//GEN-LAST:event_timKiemTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.timKiemText.setText("");
        if(option.equals("tim")){
            this.xoaBang();
            nkControl.getNhanKhauTable();
            option = "main";
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void locBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locBtActionPerformed
      if(option.equals("main") || option.equals("loc")){  
        String gioiTinh = this.gioiTinhBox.getSelectedItem()+"";
        String tinhTrang = this.tinhTrangBox.getSelectedItem()+"";
        String from = this.fromTuoi.getText();
        String to = this.toTuoi.getText();
        
        System.out.println(gioiTinh+""+tinhTrang+""+from+""+to+"");
        this.xoaBang();
        option = "loc";
        
        this.nkControl.thongkeNhanKhau(gioiTinh, tinhTrang, from, to);
      }
        
        
    }//GEN-LAST:event_locBtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.fromTuoi.setText("");
        this.toTuoi.setText("");
        if(option.equals("loc")){
            this.xoaBang();
            nkControl.getNhanKhauTable();
            option = "main";
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        QuanLiTinhTrangView view2 = new QuanLiTinhTrangView();
        dispose();
    }//GEN-LAST:event_add1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton chiTiet;
    private javax.swing.JButton edit;
    private javax.swing.JTextField fromTuoi;
    private javax.swing.JComboBox<String> gioiTinhBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton locBt;
    private javax.swing.JButton timKiemBt;
    private javax.swing.JTextField timKiemText;
    private javax.swing.JComboBox<String> tinhTrangBox;
    private javax.swing.JTextField toTuoi;
    // End of variables declaration//GEN-END:variables
}
