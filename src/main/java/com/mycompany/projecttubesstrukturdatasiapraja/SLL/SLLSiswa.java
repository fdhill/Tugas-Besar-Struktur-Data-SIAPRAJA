/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLSiswa implements ISLL<Siswa> {

    NodeSiswa head;

    @Override
    public void insert(Siswa data) {
        NodeSiswa current = head;
        NodeSiswa nn = new NodeSiswa(data);
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
    public void edit(Siswa data, int id) {
        NodeSiswa current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != id) {
            current = current.getNext();
        }
        data.setUserr_id(current.getData().getUserr_id());
        current.setData(data);
    }

    @Override
    public Siswa SearchById(int id) {
        NodeSiswa current = head;

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
        NodeSiswa current = head;

        if (current == null) {
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }

    public void setUser(int idGuru, NodeUser nodeuser) {
        NodeSiswa current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != idGuru) {
            current = current.getNext();
        }
        current.getData().setUserr_id(nodeuser);
    }
    
    public boolean cekNisnTerpakai(String nisn){
        NodeSiswa current = head;
        
        if(head == null){
            return false;
        }
        
        while(current != null){
            if(current.getData().getNisn().equals(nisn)) return true;
            
            current = current.getNext();
        }
        return false;
    }

    public NodeSiswa getNodeSiswaById(int id) {
        NodeSiswa current = head;

        if (head == null) {
            return null;
        }

        while (current != null) {
            if(current.getData().getId() == id){
                return current;
            }
            
            current = current.getNext();
        }
        return null;
    }
    
    public Siswa getSiswaByUserId(int user_id){
        NodeSiswa current = head;
        
        if(head == null){
            return new Siswa();
        }
        
        while(current != null){
            if(current.getData().getUserr_id().getData().getId() == user_id){
                return current.getData();
            }
            
            current = current.getNext();
        }
        return new Siswa();
    }

    public ArrayList<Siswa> getAll() {
        NodeSiswa current = head;
        ArrayList<Siswa> siswa = new ArrayList<>();

        if (head == null) {
            return new ArrayList<>();
        }
        while (current != null) {
            siswa.add(current.getData());
            current = current.getNext();
        }
        return siswa;
    }
    
    

    public NodeSiswa getHead() {
        return head;
    }
}
