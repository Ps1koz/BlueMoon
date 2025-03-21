/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.GuiXeController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.NhanKhauModel;
import model.PhuongTien;
import GuiXeView.DangKiGuiXeView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.Font;

/**
 *
 * @author MY PC
 */
public class GuiXeView extends javax.swing.JFrame {

    /**
     * Creates new form GuiXeView
     */
    public DefaultTableModel table;
    GuiXeController gxControl;
    String option ="";

    public GuiXeView() {
    	setTitle("Gửi xe");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(GuiXeView.class.getResource("/img/apartment_13889041-min.png")));
        initComponents();
        this.chiTiet.setVisible(false);
        this.setLocationRelativeTo(null);
        gxControl = new GuiXeController(this);
        table = (DefaultTableModel)jTable.getModel(); 
        option = "main";
        
        gxControl.getPhuongTienTable();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {        
                MainView view = new MainView(LoginView.vaiTroQuanLy);    
                dispose();     
            }
            
        });
        this.setVisible(true);
        
    }
    
public void hienThiBangPhuongTien(ArrayList<PhuongTien>list){
      for(PhuongTien i : list){
        table.addRow(new Object[]{i.getSoNha(),i.getTenChuXe(), i.getBienSo(), i.getLoaiXe()});
      }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        timKiemText = new javax.swing.JTextField();
        timKiemBt = new javax.swing.JButton();
        timKiemBt.setBorderPainted(false);
        jButton1 = new javax.swing.JButton();
        jButton1.setBorderPainted(false);
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(0, 102, 153));
        tinhTrangBox = new javax.swing.JComboBox<>();
        locBt = new javax.swing.JButton();
        locBt.setBorderPainted(false);
        jButton2 = new javax.swing.JButton();
        jButton2.setBorderPainted(false);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        add.setBorderPainted(false);
        chiTiet = new javax.swing.JButton();
        chiTiet.setBorderPainted(false);
        delete = new javax.swing.JButton();
        delete.setBorderPainted(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(230, 242, 255));

        jPanel4.setBackground(new Color(230, 242, 255));

        timKiemText.setText("Biển số xe/ chủ xe");
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

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        jLabel1.setText("Loại xe");

        tinhTrangBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Xe máy", "Ô tô" }));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(timKiemText, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(tinhTrangBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(timKiemBt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(locBt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton2)
        				.addComponent(jButton1))
        			.addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(timKiemText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1)
        				.addComponent(timKiemBt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(locBt)
        				.addComponent(jButton2)
        				.addComponent(tinhTrangBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4.setLayout(jPanel4Layout);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số nhà", "Chủ xe", "Biển số", "Loại xe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
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

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(chiTiet, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
        			.addComponent(add, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(delete, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(add)
        				.addComponent(delete)
        				.addComponent(chiTiet))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        				.addComponent(jPanel4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locBtActionPerformed

    }//GEN-LAST:event_locBtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void timKiemTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemTextActionPerformed

    }//GEN-LAST:event_timKiemTextActionPerformed

    private void timKiemBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemBtActionPerformed

    }//GEN-LAST:event_timKiemBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        option = "add";
        DangKiGuiXeView view2 = new DangKiGuiXeView(option);
        this.setVisible(false);

    }//GEN-LAST:event_addActionPerformed

    private void chiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiTietActionPerformed

    }//GEN-LAST:event_chiTietActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
      int sRow = jTable.getSelectedRow();
        if(sRow == -1){
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn phương tiện");
            return;
        }
      PhuongTien pt = new PhuongTien();
        
        String soNha = new String();
        String tenchu = new String();
        String bienso = new String();
        String loaixe = new String();

                soNha = (table.getValueAt(sRow, 0)+"");
                tenchu = (table.getValueAt(sRow, 1)+"");
                bienso = (table.getValueAt(sRow, 2)+"");
                loaixe = (table.getValueAt(sRow, 3)+"");

            pt.setSoNha(soNha);
            pt.setBienSo(bienso);
            pt.setLoaiXe(loaixe);
            pt.setTenChuXe(tenchu);
             int xemay = 0;
             int oto = 0;
             if(pt.getLoaiXe().equals("Xe máy")){
                    xemay = -1;
             }else if(pt.getLoaiXe().equals("Ô tô")){
                    oto = -1;
             }
                         
        String bienSo = (table.getValueAt(sRow, 2)+"");
        
        gxControl.updatePhuongTienhk(oto, xemay, pt.getSoNha());
        gxControl.xoaPhuongTien(bienSo);
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton chiTiet;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton locBt;
    private javax.swing.JButton timKiemBt;
    private javax.swing.JTextField timKiemText;
    private javax.swing.JComboBox<String> tinhTrangBox;
    // End of variables declaration//GEN-END:variables
}
