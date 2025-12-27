/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceSiswa {
    private SLLSiswa sllsiswa;
    private SLLUser slluser;
    private SLLMonitoring sllmonitoring;
    
    private final DefaultTableModel todoTableModel;
    
    private ArrayList<Siswa> listsiswa;

    public DataSourceSiswa() {
        this.sllsiswa = DataSource.getSllSiswa();
        this.slluser = DataSource.getSllUser();
        this.sllmonitoring = DataSource.getSllMonitoring();
        
        listsiswa = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Nisn", "Kelas", "Alamat" ,"Jenis_Kelamin"},
                0
        );
    }
    
    public void add(String nama, String nisn, String alamat, String jenis_kelamin, String kelas){
        Siswa data = new Siswa(nama, nisn, alamat, jenis_kelamin, kelas);
        User user = new User(nama, nisn, nisn, 2);
        NodeUser nodeuser = slluser.insertAndGet(user);
        data.setUserr_id(nodeuser);
        
        sllsiswa.insert(data);
    }
    
    public void update(int id, String nama, String nisn, String alamat, String jenis_kelamin, String kelas){
        Siswa data = new Siswa(nama, nisn, alamat, jenis_kelamin, kelas);
        sllsiswa.edit(data, id);
    }
    
    public Siswa getSiswa(int id){
        Siswa s = sllsiswa.SearchById(id);
        return s;
    }
    
    public String getGuruBySiswa(int id){
        return sllmonitoring.getGuruByIdSiswa(id).getNama();
    }
    
    public String getInstansiBySiswa(int id){
        return sllmonitoring.getInstansiByIdSiswa(id).getNama();
    }
    
    public boolean cekNisnTerpakai(String nisn){
        return sllsiswa.cekNisnTerpakai(nisn);
    }
    
    public void getAll(){
        listsiswa.clear();
        listsiswa.addAll(
                sllsiswa.getAll()
        );
    }
    
    public DefaultTableModel getTableModel(){
        return this.todoTableModel;
    }

    public void refreshTableModel(){
        getAll();
        this.todoTableModel.setRowCount(0);
        for(Siswa siswa : listsiswa){
            this.todoTableModel.addRow(
                    new Object[]{
                        siswa.getId(),
                        siswa.getNama(),
                        siswa.getNisn(),
                        siswa.getKelas(),
                        siswa.getAlamat(),
                        siswa.getJenis_kelamin()
                    }
            );
        }
    }
}
