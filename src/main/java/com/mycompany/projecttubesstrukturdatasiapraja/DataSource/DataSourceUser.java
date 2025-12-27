/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Login.HashPassword;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceUser {
    private SLLUser slluser;
    private ArrayList<User> listuser;
    
    private final DefaultTableModel todoTableModel;

    public DataSourceUser() {
        this.slluser = DataSource.getSllUser();
        this.listuser = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Username", "Password", "Role"},
                0
        );
    }
    
    public NodeUser add(String nama, String username, String password, int role){
        User data = new User(nama, username, password, role);
                
        NodeUser newNode = slluser.insertAndGet(data);
        
        //slluser.insert(data);
        return newNode;
    }
    
    public void update(int id, String nama, String username, String password, int role){
        User data = new User(nama, username, password, role);
        slluser.edit(data, id);
    }
    
    public boolean gantiPassword(int idUser, String passwordBaru, String passwordLama){
        return slluser.gantiPassword(idUser, passwordBaru, passwordLama);
    }
    
    public User getUser(int id){
        User u = slluser.SearchById(id);
        return u;
    }
    
    public void getAll(){
        listuser.clear();
        listuser.addAll(
                slluser.getAll()
        );
    }
    
    public DefaultTableModel getTableModel(){
        return this.todoTableModel;
    }

    public void refreshTableModel(){
        getAll();
        this.todoTableModel.setRowCount(0);
        for(User user : listuser){
            this.todoTableModel.addRow(
                    new Object[]{
                        user.getId(),
                        user.getNama(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole()
                    }
            );
        }
    }
}
