/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;

/**
 *
 * @author Pongo
 */
public class NodeInstansi {
    Instansi data;
    NodeInstansi next;

    public NodeInstansi(Instansi data) {
        this.data = data;
        next = null;
    }

    public Instansi getData() {
        return data;
    }

    public void setData(Instansi data) {
        this.data = data;
    }

    public NodeInstansi getNext() {
        return next;
    }

    public void setNext(NodeInstansi next) {
        this.next = next;
    }
}
