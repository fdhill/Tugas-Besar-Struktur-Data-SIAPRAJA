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
public class Siswa {
    private int id;
    private String nama, nisn, alamat, jenis_kelamin, kelas;
    private NodeUser userr_id;

    public Siswa(String nama, String nisn, String alamat, String jenis_kelamin, String kelas) {
        this.nama = nama;
        this.nisn = nisn;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.kelas = kelas;
    }

    public Siswa() {
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

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public NodeUser getUserr_id() {
        return userr_id;
    }

    public void setUserr_id(NodeUser userr_id) {
        this.userr_id = userr_id;
    }
}
