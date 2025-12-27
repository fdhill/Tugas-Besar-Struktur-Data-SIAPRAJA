/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;

/**
 *
 * @author Pongo
 */
public class NodeGuru {
    Guru data;
    NodeGuru next;

    public NodeGuru(Guru data) {
        this.data = data;
        next = null;
    }

    public Guru getData() {
        return data;
    }

    public void setData(Guru data) {
        this.data = data;
    }

    public NodeGuru getNext() {
        return next;
    }

    public void setNext(NodeGuru next) {
        this.next = next;
    }
}
