/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;

/**
 *
 * @author Pongo
 */
public class NodeSiswa{
    Siswa data;
    NodeSiswa next;

    public NodeSiswa(Siswa data) {
        this.data = data;
        next = null;
    }

    public Siswa getData() {
        return data;
    }

    public void setData(Siswa data) {
        this.data = data;
    }

    public NodeSiswa getNext() {
        return next;
    }

    public void setNext(NodeSiswa next) {
        this.next = next;
    }
}
