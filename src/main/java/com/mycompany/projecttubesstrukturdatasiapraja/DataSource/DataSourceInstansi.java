/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class DataSourceInstansi {
    private SLLInstansi sllinstansi;
    private SLLUser slluser;
    private ArrayList<NodeInstansi> listnodeinstansi;

    public DataSourceInstansi(SLLInstansi sllinstansi, SLLUser slluser) {
        this.sllinstansi = sllinstansi;
        this.slluser = slluser;
        listnodeinstansi = new ArrayList<>();
    }
    
    public void add(String nama, String alamat, String telepon, int kuota){
        Instansi data = new Instansi(nama, alamat, telepon, kuota);
        User user = new User(nama, telepon, telepon);
        sllinstansi.insert(data);
    }
    
    public void addWithUser(String nama, String alamat, String telepon, int kuota){
        Instansi data = new Instansi(nama, alamat, telepon, kuota);
        User user = new User(nama, telepon, telepon);
        NodeUser nodeuser = new NodeUser(user);
        data.setUser_id(nodeuser);
        sllinstansi.insert(data);
    }
    
    public void update(int id, String nama, String alamat, String telepon, int kuota){
        Instansi data = new Instansi(nama, alamat, telepon, kuota);
        sllinstansi.edit(data, id);
    }
    
    public Instansi getInstansi(int id){
        Instansi s = sllinstansi.SearchById(id);
        return s;
    }
    
    public void getAll(){
        listnodeinstansi.clear();
        listnodeinstansi.addAll(
                sllinstansi.getAll()
        );
    }
}
