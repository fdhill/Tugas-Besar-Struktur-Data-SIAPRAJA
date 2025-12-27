/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMengajukanPKL;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.DashboardSiswaView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.PengajuanInstansiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class PengajuanPklController {

    DataSourceMengajukanPKL datasource;
    PengajuanInstansiView view;

    int idInstansi = -1;
    Session session;

    public PengajuanPklController(DataSourceMengajukanPKL datasource, PengajuanInstansiView view) {
        this.datasource = datasource;
        this.view = view;
        this.session = DataSource.getSession();

        bassicLayout();
        initTable();
        show();

        view.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = view.getjTable1().getSelectedRow();
                if (row != -1) {
                    view.getjBtnMengajukan().setEnabled(true);

                    idInstansi = (int) view.getjTable1().getValueAt(row, 0);
                }
            }
        });

        this.view.getjBtnMengajukan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((int) view.getjTable1().getValueAt(view.getjTable1().getSelectedRow(), 4) == 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Kuota Telah Habis",
                            "Informasi",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin mengajukan",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                datasource.add(idInstansi, session.getId_data());

                new DashboardSiswaController(new DashboardSiswaView()).show();
                view.dispose();
            }
        });

        this.view.getjBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardSiswaController(new DashboardSiswaView()).show();

                view.dispose();
            }
        });
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void bassicLayout() {
        view.getjBtnMengajukan().setEnabled(false);
        idInstansi = -1;
    }

    public boolean cekSudahMendaftar() {
        return datasource.cekSudahMengajukan(session.getId_data());
    }

    private void initTable() {
        datasource.refreshTableModel();
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourceMengajukanPKL) this.datasource).refreshTableModel();

        this.view.getjTable1().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getjTable1().getColumnModel().getColumn(0).setMaxWidth(0);
    }
}
