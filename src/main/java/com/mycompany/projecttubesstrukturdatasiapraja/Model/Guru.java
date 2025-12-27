/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Model;

import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;

/**
 *
 * @author Pongo
 */
public class Guru {
    int id;
    String nama, alamat, jenis_kelamin, nip;
    NodeUser user_id;

    public Guru(String nama, String alamat, String jenis_kelamin, String nip) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.nip = nip;
    }

    public Guru() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public NodeUser getUser_id() {
        return user_id;
    }

    public void setUser_id(NodeUser user_id) {
        this.user_id = user_id;
    }
    
    
}
