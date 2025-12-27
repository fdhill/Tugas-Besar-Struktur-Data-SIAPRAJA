/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Pengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodePengajuan;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLPengajuan implements ISLL<Pengajuan> {

    NodePengajuan head;

    @Override
    public void insert(Pengajuan data) {
        NodePengajuan current = head;
        NodePengajuan nn = new NodePengajuan(data);

        int id = getIncremental();
        nn.getData().setId(id);
        nn.getData().setStatus(0);

        if (head == null) {
            head = nn;
            return;
        }

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(nn);
    }

    @Override
    public void edit(Pengajuan data, int id) {
        NodePengajuan current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != id) {
            current = current.getNext();
        }
        current.setData(data);
    }

    @Override
    public Pengajuan SearchById(int id) {
        NodePengajuan current = head;

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
        int incremental = 0;
        NodePengajuan current = head;

        if (current == null) {
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }

    public ArrayList<Pengajuan> getAll() {
        NodePengajuan current = head;
        ArrayList<Pengajuan> pengajuan = new ArrayList<>();

        if (head == null) {
            return new ArrayList<>();
        }
        while (current != null) {
            if (current.getData().getStatus() == 0) {
                pengajuan.add(current.getData());
            }
            current = current.getNext();
        }
        return pengajuan;
    }

    public void setujuiPengajuan(int pengajuan_id) {
        NodePengajuan current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != pengajuan_id) {
            current = current.getNext();
        }
        current.getData().setStatus(1);
    }

    public void tolakPengajuan(int pengajuan_id) {
        NodePengajuan current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != pengajuan_id) {
            current = current.getNext();
        }

        current.getData().setStatus(2);
    }
    
    public boolean cekSudahMengajukanByIdSiswa(int id){
        NodePengajuan current = head;
        
        if(head == null){
            return false;
        }
        
        while(current != null){
            if(current.getData().getSiswa_id().getData().getId() == id){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public Instansi getInstansiBySiswaId(int id){
         NodePengajuan current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getSiswa_id().getData().getId() == id){
                return current.getData().getInstansi_id().getData();
            }
            current = current.getNext();
        }
        return null;
    }

}
