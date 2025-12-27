/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Model;

import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;

/**
 *
 * @author Pongo
 */
public class Pengajuan {
    int id, status = 0;
    NodeInstansi instansi_id;
    NodeSiswa siswa_id;

    public Pengajuan(NodeInstansi instansi_id, NodeSiswa siswa_id) {
        this.instansi_id = instansi_id;
        this.siswa_id = siswa_id;
        this.status = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodeInstansi getInstansi_id() {
        return instansi_id;
    }

    public void setInstansi_id(NodeInstansi instansi_id) {
        this.instansi_id = instansi_id;
    }

    public NodeSiswa getSiswa_id() {
        return siswa_id;
    }

    public void setSiswa_id(NodeSiswa siswa_id) {
        this.siswa_id = siswa_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
