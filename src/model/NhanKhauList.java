/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY PC
 */
public class NhanKhauList {
    private NhanKhauModel nhankhau;
    private ArrayList<NhanKhauModel> listNK;
    
    
    public NhanKhauList(NhanKhauModel nhanKhauModel,ArrayList<NhanKhauModel> listNhanKhauModels) {
        this.nhankhau = nhanKhauModel;
        this.listNK = listNhanKhauModels;
        
    }

    public NhanKhauList() {
        this.nhankhau = new NhanKhauModel();
        this.listNK = new ArrayList<>();
    }

    public NhanKhauModel getNhankhau() {
        return nhankhau;
    }

    public void setNhankhau(NhanKhauModel nhankhau) {
        this.nhankhau = nhankhau;
    }

    public ArrayList<NhanKhauModel> getListNK() {
        return listNK;
    }

    public void setListNK(ArrayList<NhanKhauModel> listNK) {
        this.listNK = listNK;
    }
    
    
    
    
    
    
    
}
