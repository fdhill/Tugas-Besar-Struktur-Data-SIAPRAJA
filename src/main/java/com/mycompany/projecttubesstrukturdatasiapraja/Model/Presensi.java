/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Model;

import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeMonitoring;

/**
 *
 * @author Pongo
 */
public class Presensi {
    int id, status;
    String tanggal, jam_masuk, jam_keluar, keterangan, lokasi;
    NodeMonitoring monitoring_id;

    public Presensi(int status, String tanggal, String jam_masuk, String keterangan, String lokasi, NodeMonitoring monitoring_id) {
        this.tanggal = tanggal;
        this.jam_masuk = jam_masuk;
        this.keterangan = keterangan;
        this.lokasi = lokasi;
        this.monitoring_id = monitoring_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public void setJam_masuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public NodeMonitoring getMonitoring_id() {
        return monitoring_id;
    }

    public void setMonitoring_id(NodeMonitoring monitoring_id) {
        this.monitoring_id = monitoring_id;
    }
}
