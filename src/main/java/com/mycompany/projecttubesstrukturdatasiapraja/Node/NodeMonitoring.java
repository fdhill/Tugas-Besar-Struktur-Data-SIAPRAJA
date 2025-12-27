/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Monitoring;

/**
 *
 * @author Pongo
 */
public class NodeMonitoring {
    Monitoring data;
    NodeMonitoring next;

    public NodeMonitoring(Monitoring data) {
        this.data = data;
        next = null;
    }

    public Monitoring getData() {
        return data;
    }

    public void setData(Monitoring data) {
        this.data = data;
    }

    public NodeMonitoring getNext() {
        return next;
    }

    public void setNext(NodeMonitoring next) {
        this.next = next;
    }
}
