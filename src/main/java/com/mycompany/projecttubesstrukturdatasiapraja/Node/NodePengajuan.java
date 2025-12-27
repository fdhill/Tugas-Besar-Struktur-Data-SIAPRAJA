/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Pengajuan;

/**
 *
 * @author Pongo
 */
public class NodePengajuan {
    Pengajuan data;
    NodePengajuan next;

    public NodePengajuan(Pengajuan data) {
        this.data = data;
        this.next = null;
    }

    public Pengajuan getData() {
        return data;
    }

    public void setData(Pengajuan data) {
        this.data = data;
    }

    public NodePengajuan getNext() {
        return next;
    }

    public void setNext(NodePengajuan next) {
        this.next = next;
    }
}
