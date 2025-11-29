/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Presensi;

/**
 *
 * @author Pongo
 */
public class NodePresensi {
    Presensi data;
    NodePresensi next;

    public NodePresensi(Presensi data) {
        this.data = data;
        next = null;
    }
}
