/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Login.HashPassword;
import com.mycompany.projecttubesstrukturdatasiapraja.Login.LoginService;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLUser implements ISLL<User> {

    NodeUser head;

    HashPassword hashpassword = new HashPassword();
    LoginService login = new LoginService();

    @Override
    public void insert(User data) {
        NodeUser current = head;
        NodeUser nn = new NodeUser(data);

        if (current == null) {
            head = nn;
            return;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(nn);
    }

    public NodeUser insertAndGet(User data) {
        NodeUser current = head;
        NodeUser nn = hashing(data);

        int id = getIncremental();
        nn.getData().setId(id);

        insert(nn.getData());
        return nn;
    }

    @Override
    public void edit(User data, int id) {
        NodeUser current = head;

        if (current == null) {
            return;
        }
        while (current.getData().getId() != id) {
            current = current.getNext();
        }
        
        if (data.getPassword().trim().isEmpty()) {
            data.setPassword(current.getData().getPassword());
        } else {
            data = hashing(data).getData();
        }
        data.setId(current.getData().getId());
        current.setData(data);
    }

    @Override
    public User SearchById(int id) {
        NodeUser current = head;

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
        NodeUser current = head;

        if (current == null) {
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }
    
    public boolean gantiPassword(int idUser, String passwordBaru, String passwordLama){
        NodeUser current = head;

        while (current != null) {
            if (current.getData().getId() == idUser) {
                String hashedPassword = current.getData().getPassword();

                if (login.chekpassword(passwordLama, hashedPassword)) {
                    current.getData().setPassword(hashpassword.editPasswordHash(passwordBaru));
                    return true;
                }
                return false;
            }
            current = current.getNext();
        }
        return false;
    }

    public User getByUsername(String username) {
        NodeUser current = head;

        while (current != null) {
            if (current.getData().getUsername().equals(username)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean cekUsernameTerpakai(String username) {
        NodeUser current = head;

        if (head == null) {
            return false;
        }

        while (current != null) {
            if (current.getData().getUsername().equals(username)) {
                return true;
            }

            current = current.getNext();
        }
        return false;
    }

    public ArrayList<User> getAll() {
        NodeUser current = head;
        ArrayList<User> user = new ArrayList<>();

        if (head == null) {
            return new ArrayList<>();
        }
        while (current != null) {
            user.add(current.getData());
            current = current.getNext();
        }
        return user;
    }

    public void hashSemuaPassword() {
        SLLUser headbaru = hashpassword.hashAll(this);
        head = headbaru.getHead();
    }

    public NodeUser hashing(User user) {
        NodeUser usernode = hashpassword.hashingPassword(user);
        return usernode;
    }

    public User login(String username, String password) {
        NodeUser current = head;

        while (current != null) {
            if (current.getData().getUsername().equals(username)) {
                String hashedPassword = current.getData().getPassword();

                if (login.chekpassword(password, hashedPassword)) {
                    return current.getData();
                }
                return null;
            }
            current = current.getNext();
        }
        return null;
    }

    public NodeUser getHead() {
        return head;
    }
}
