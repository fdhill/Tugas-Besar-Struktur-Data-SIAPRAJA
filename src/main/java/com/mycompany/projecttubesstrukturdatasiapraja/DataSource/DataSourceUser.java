/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class DataSourceUser {
    private SLLUser slluser;
    private ArrayList<NodeUser> listnodeuser;

    public DataSourceUser(SLLUser slluser) {
        this.slluser = slluser;
        this.listnodeuser = new ArrayList<>();;
    }
    
    public NodeUser addAndGetNode(String nama, String username, String password){
        User data = new User(nama, username, password);
        
        NodeUser newNode = slluser.insertUser(data);
        slluser.insert(data);
        return newNode;
    }
    
    public void add(String nama, String username, String password){
        User data = new User(nama, username, password);      
        slluser.insert(data);
    }
    
    public void update(int id, String nama, String username, String password){
        User data = new User(nama, username, password);
        slluser.edit(data, id);
    }
    
    public User getUser(int id){
        User u = slluser.SearchById(id);
        return u;
    }
    
    public void getAll(){
        listnodeuser.clear();
        listnodeuser.addAll(
                slluser.getAll()
        );
    }
}
