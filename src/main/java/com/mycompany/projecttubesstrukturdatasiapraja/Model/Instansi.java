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
public class Instansi {
    int id, kuota;
    String nama, alamat, telepon, pembimbing;
    NodeUser user_id;

    public Instansi(String nama, String alamat, String telepon, int kuota, String pembimbing) {
        this.kuota = kuota;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.pembimbing = pembimbing;
    }

    public Instansi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
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

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public NodeUser getUser_id() {
        return user_id;
    }

    public void setUser_id(NodeUser user_id) {
        this.user_id = user_id;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }
}
