/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceInstansi {
    private SLLInstansi sllinstansi;
    private SLLMonitoring sllmonitoring;
    private SLLUser slluser;
    
    private final DefaultTableModel todoTableModel;
    
    private ArrayList<Instansi> listinstansi;
    private ArrayList<Siswa> listsiswa;

    public DataSourceInstansi() {
        this.sllinstansi = DataSource.getSllInstansi();
        this.sllmonitoring = DataSource.getSllMonitoring();
        this.slluser = DataSource.getSllUser();
        
        listinstansi = new ArrayList<>();
        listsiswa = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Alamat", "Telepon", "Sisa_Kuota", "Pembimbing"},
                0
        );
    }
    
    public void add(String nama, String alamat, String telepon, int kuota, String pembimbing){
        Instansi data = new Instansi(nama, alamat, telepon, kuota, pembimbing);
        User user = new User(nama, pembimbing, pembimbing, 4);
        NodeUser nodeuser = slluser.insertAndGet(user);
        data.setUser_id(nodeuser);
        
        sllinstansi.insert(data);
    }
    
    public void update(int id, String nama, String alamat, String telepon, int kuota, String pembimbing){
        Instansi data = new Instansi(nama, alamat, telepon, kuota, pembimbing);
        sllinstansi.edit(data, id);
    }
    
//    public void getSiswaByInstansi(int id){
//        listsiswa.clear();
//        Instansi instansi = sllinstansi.SearchById(id);
//        listsiswa.addAll(sllmonitoring.getSiswaByInstansi(instansi));
//    }
    
    public Instansi getInstansiById(int id){
        return sllinstansi.SearchById(id);
    }
    
    public void getAll(){
        listinstansi.clear();
        listinstansi.addAll(
                sllinstansi.getAll()
        );
    }
    
    public DefaultTableModel getTableModel(){
        return this.todoTableModel;
    }

    public void refreshTableModel(){
        getAll();
        this.todoTableModel.setRowCount(0);
        for(Instansi instansi : listinstansi){
            this.todoTableModel.addRow(
                    new Object[]{
                        instansi.getId(),
                        instansi.getNama(),
                        instansi.getAlamat(),
                        instansi.getTelepon(),
                        instansi.getKuota(),
                        instansi.getPembimbing()
                    }
            );
        }
    }
}
