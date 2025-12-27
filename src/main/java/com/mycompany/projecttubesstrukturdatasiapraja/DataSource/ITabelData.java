/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public interface ITabelData {
    public DefaultTableModel getTableModel();

    public void refreshTableModel();
}
