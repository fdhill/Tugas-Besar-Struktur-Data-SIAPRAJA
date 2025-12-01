/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class DataSourceSiswa {
    private SLLSiswa sllsiswa;
    private SLLUser slluser;
    private ArrayList<NodeSiswa> listnodesiswa;

    public DataSourceSiswa(SLLSiswa sllSiswa, SLLUser slluser) {
        this.sllsiswa = sllSiswa;
        this.slluser = slluser;
        listnodesiswa = new ArrayList<>();
    }
    
    public void add(String nama, String nisn, String alamat, String jenis_kelamin, String kelas){
        Siswa data = new Siswa(nama, nisn, alamat, jenis_kelamin, kelas);
        User user = new User(nama, nisn, nisn);
        sllsiswa.insert(data);
    }
    
    public void addWithUser(String nama, String nisn, String alamat, String jenis_kelamin, String kelas){
        Siswa data = new Siswa(nama, nisn, alamat, jenis_kelamin, kelas);
        User user = new User(nama, nisn, nisn);
        NodeUser nodeuser = new NodeUser(user);
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
    
    public void getAll(){
        listnodesiswa.clear();
        listnodesiswa.addAll(
                sllsiswa.getAll()
        );
    }
}
