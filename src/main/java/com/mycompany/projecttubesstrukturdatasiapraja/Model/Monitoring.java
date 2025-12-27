/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Model;

import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;

/**
 *
 * @author Pongo
 */
public class Monitoring {
    int id;
    NodeSiswa siswa_id;
    NodeGuru guru_id;
    NodeInstansi instansi_id;
    String tanggal_mulai, tanggal_selesai;

    public Monitoring(NodeSiswa siswa_id, NodeInstansi intansi_id) {
        this.siswa_id = siswa_id;
        this.instansi_id = intansi_id;
    }

    public Monitoring() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodeSiswa getSiswa_id() {
        return siswa_id;
    }

    public void setSiswa_id(NodeSiswa siswa_id) {
        this.siswa_id = siswa_id;
    }

    public NodeGuru getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(NodeGuru guru_id) {
        this.guru_id = guru_id;
    }

    public NodeInstansi getInstansi_id() {
        return instansi_id;
    }

    public void setInstansi_id(NodeInstansi instansi) {
        this.instansi_id = instansi;
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
