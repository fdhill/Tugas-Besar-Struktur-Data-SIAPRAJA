/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

/**
 *
 * @author Pongo
 */
public interface ISLL<T> {
    void insert(T data);
    void update(T data, int id);
    T SearchById(int id);
}

