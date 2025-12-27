/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLGuru implements ISLL<Guru> {

    NodeGuru head;

    @Override
    public void insert(Guru data) {
        NodeGuru current = head;
        NodeGuru nn = new NodeGuru(data);
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
    public void edit(Guru data, int id) {
        NodeGuru current = head;

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
    public Guru SearchById(int id) {
        NodeGuru current = head;

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
        NodeGuru current = head;

        if (current == null) {
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }

    public void setUser(int idGuru, NodeUser nodeuser) {
        NodeGuru current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != idGuru) {
            current = current.getNext();
        }
        current.getData().setUser_id(nodeuser);
    }
    
    public boolean cekNipTerpakai(String nip){
        NodeGuru current = head;
        
        if(head == null){
            return false;
        }
        
        while(current != null){
            if(current.getData().getNip().equals(nip)) return true;
            
            current = current.getNext();
        }
        return false;
    }

    public Guru getGuruById(int id) {
        NodeGuru current = head;

        if (head == null) {
            System.out.println("Data kosong");
            return null;
        }

        while (current != null && current.getData().getId() != id) {
            current = current.getNext();
        }
        return current.getData();
    }
    
    public NodeGuru getNodeGuruById(int id) {
        NodeGuru current = head;

        if (head == null) {
            System.out.println("Data kosong");
            return null;
        }

        while (current != null && current.getData().getId() != id) {
            current = current.getNext();
        }
        return current;
    }
    
    public Guru getGuruaByUserId(int user_id){
        NodeGuru current = head;
        
        if(head == null){
            return new Guru();
        }
        
        while(current != null){
            if(current.getData().getUser_id().getData().getId() == user_id){
                return current.getData();
            }
            
            current = current.getNext();
        }
        return new Guru();
    }

    public ArrayList<Guru> getAll() {
        NodeGuru current = head;
        ArrayList<Guru> guru = new ArrayList<>();

        if (head == null) {
            return new ArrayList<>();
        }
        while (current != null) {
            guru.add(current.getData());
            current = current.getNext();
        }
        return guru;
    }

    public NodeGuru getHead() {
        return head;
    }
}
