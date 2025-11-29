/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Model;

/**
 *
 * @author Pongo
 */
public class Monitoring {
    int id;
    Siswa siswa_id;
    Guru guru_id;
    Instansi instansi_id;
    String tanggal_mulai, tanggal_selesai;

    public Monitoring(Siswa siswa_id, Guru guru_id) {
        this.siswa_id = siswa_id;
        this.guru_id = guru_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Siswa getSiswa_id() {
        return siswa_id;
    }

    public void setSiswa_id(Siswa siswa_id) {
        this.siswa_id = siswa_id;
    }

    public Guru getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Guru guru_id) {
        this.guru_id = guru_id;
    }

    public Instansi getInstansi_id() {
        return instansi_id;
    }

    public void setInstansi_id(Instansi instansi_id) {
        this.instansi_id = instansi_id;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }
}
