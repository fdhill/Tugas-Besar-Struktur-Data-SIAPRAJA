/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Node;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;

/**
 *
 * @author Pongo
 */
public class NodeUser {
    User data;
    NodeUser next;

    public NodeUser(User data) {
        this.data = data;
        next = null;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public NodeUser getNext() {
        return next;
    }

    public void setNext(NodeUser next) {
        this.next = next;
    }
}
