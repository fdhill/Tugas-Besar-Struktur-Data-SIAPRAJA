/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLInstansi implements ISLL<Instansi> {

    NodeInstansi head;

    @Override
    public void insert(Instansi data) {
        NodeInstansi current = head;
        NodeInstansi nn = new NodeInstansi(data);
        int id = getIncremental();
        nn.getData().setId(id);

        if (current == null) {
            head = nn;
            return;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(nn);
    }

    @Override
    public void edit(Instansi data, int id) {
        NodeInstansi current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != id) {
            current = current.getNext();
        }
        data.setUser_id(current.getData().getUser_id());
        current.setData(data);
    }

    @Override
    public Instansi SearchById(int id) {
        NodeInstansi current = head;

        while (current != null) {
            if (current.getData().getId() == id) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public int getIncremental() {
        NodeInstansi current = head;

        if (current == null) {
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }

    public void setUser(int idInstansi, NodeUser nodeuser) {
        NodeInstansi current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != idInstansi) {
            current = current.getNext();
        }
        current.getData().setUser_id(nodeuser);
    }

    public NodeInstansi getNodeInstansiById(int id) {
        NodeInstansi current = head;

        if (head == null) {
            System.out.println("Data kosong");
            return null;
        }

        while (current != null && current.getData().getId() != id) {
            current = current.getNext();
        }
        return current;
    }

    public Instansi getInstansiByUserId(int user_id) {
        NodeInstansi current = head;

        if (head == null) {
            return new Instansi();
        }

        while (current != null) {
            if (current.getData().getUser_id().getData().getId() == user_id) {
                return current.getData();
            }

            current = current.getNext();
        }
        return new Instansi();
    }

    public ArrayList<Instansi> getAll() {
        NodeInstansi current = head;
        ArrayList<Instansi> instansi = new ArrayList<>();

        if (head == null) {
            return new ArrayList<>();
        }
        while (current != null) {
            instansi.add(current.getData());
            current = current.getNext();
        }
        return instansi;
    }

    public NodeInstansi getHead() {
        return head;
    }

    public void kurangiKuota(NodeInstansi nodeInstansi_id) {
        NodeInstansi current = head;

        if (head == null) {
            return;
        }

        while (current != null) {
            if (current == nodeInstansi_id) {
                current.getData().setKuota(current.getData().getKuota() -1);
            }

            current = current.getNext();
        }
        return;
    }
}
