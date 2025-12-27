/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceGuru {
    private SLLGuru sllguru;
    private SLLUser slluser;
    private SLLMonitoring sllmonitoring;
    
    private final DefaultTableModel todoTableModel;
    
    
    private ArrayList<Guru> listguru;
    private ArrayList<Siswa> listsiswa;

    public DataSourceGuru() {
        this.sllguru = DataSource.getSllGuru();
        this.slluser = DataSource.getSllUser();
        this.sllmonitoring = DataSource.getSllMonitoring();
        
        listguru = new ArrayList<>();
        listsiswa = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Alamat", "Jenis_kelamin", "NIP"},
                0
        );
    }
    
    public void add(String nama, String alamat, String jenis_kelamin, String nip){
        Guru data = new Guru(nama, alamat, jenis_kelamin, nip);
        User user = new User(nama, nip, nip, 3);
        NodeUser nodeuser = slluser.insertAndGet(user);
        data.setUser_id(nodeuser);
        
        sllguru.insert(data);
    }
    
    public void update(int id, String nama, String alamat, String jenis_kelamin, String nip){
        Guru data = new Guru(nama, alamat, jenis_kelamin, nip);
        sllguru.edit(data, id);
    }
    
//    public void getSiswaByGuru(int id){
//        listsiswa.clear();
//        Guru guru = sllguru.SearchById(id);
//        listsiswa.addAll(sllmonitoring.getSiswaByGuru(guru));
//    }
    
    public Guru getGuruById(int id){
        return sllguru.getGuruById(id);
    }
    
    public boolean cekNipTerpakai(String nip){
        return sllguru.cekNipTerpakai(nip);
    }
    
    public void getAll(){
        listguru.clear();
        listguru.addAll(
                sllguru.getAll()
        );
    }
    
    public DefaultTableModel getTableModel(){
        return this.todoTableModel;
    }

    public void refreshTableModel(){
        getAll();
        this.todoTableModel.setRowCount(0);
        for(Guru guru : listguru){
            this.todoTableModel.addRow(
                    new Object[]{
                        guru.getId(),
                        guru.getNama(),
                        guru.getAlamat(),
                        guru.getJenis_kelamin(),
                        guru.getNip()
                    }
            );
        }
    }
}
