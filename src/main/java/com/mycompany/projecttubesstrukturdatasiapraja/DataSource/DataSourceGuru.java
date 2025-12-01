/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLGuru;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class DataSourceGuru {
    private SLLGuru sllguru;
    private DataSourceUser dsUser;
    private ArrayList<NodeGuru> listnodeguru;

    public DataSourceGuru(SLLGuru sllGuru, DataSourceUser dsUser) {
        this.sllguru = sllGuru;
        this.dsUser = dsUser;
        listnodeguru = new ArrayList<>();
    }
    
    public void add(String nama, String alamat, String jenis_kelamin, String nip){
        Guru data = new Guru(nama, alamat, jenis_kelamin, nip);
        sllguru.insert(data);
    }
    
    public void addWithUser(String nama, String alamat, String jenis_kelamin, String nip){
        Guru data = new Guru(nama, alamat, jenis_kelamin, nip);
        NodeUser nodeuser = dsUser.addAndGetNode(nama, nip, nip);
        data.setUser_id(nodeuser);
        
        sllguru.insert(data);
    }
    
    public void update(int id, String nama, String alamat, String jenis_kelamin, String nip){
        Guru data = new Guru(nama, alamat, jenis_kelamin, nip);
        sllguru.edit(data, id);
    }
    
    public void setUserId(){
        
    }
    
    public Guru getGuru(int id){
        Guru s = sllguru.SearchById(id);
        return s;
    }
    
    public void getAll(){
        listnodeguru.clear();
        listnodeguru.addAll(
                sllguru.getAll()
        );
    }
}
