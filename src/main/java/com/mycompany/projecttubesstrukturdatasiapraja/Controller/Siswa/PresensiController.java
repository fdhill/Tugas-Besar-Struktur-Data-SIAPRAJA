/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.DashboardSiswaView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.PresensiDanKegiatanSiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class PresensiController {

    DataSourcePresensi datasource;
    PresensiDanKegiatanSiswaView view;

    int idPresensiTabel = -1;

    public PresensiController(DataSourcePresensi datasource, PresensiDanKegiatanSiswaView view) {
        this.datasource = datasource;
        this.view = view;

        clear();

        datasource.refreshTableModelBySiswa(DataSource.getSession().getId_data());
        this.view.getTblPresensi().setModel(datasource.getTableModel());
        ((DataSourcePresensi) this.datasource).refreshTableModelBySiswa(DataSource.getSession().getId_data());

        this.view.getTblPresensi().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblPresensi().getColumnModel().getColumn(0).setMaxWidth(0);

        view.getTblPresensi().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                int row = view.getTblPresensi().getSelectedRow();
                if (row == -1) {
                    return;
                }

                idPresensiTabel = (int) view.getTblPresensi().getValueAt(row, 0);

                Object jamKeluarObj = view.getTblPresensi().getValueAt(row, 4);

                boolean bolehPulang
                        = jamKeluarObj == null
                        || jamKeluarObj.toString().trim().isEmpty();

                view.getjBtnKepulangan().setEnabled(bolehPulang);
            }
        });

        this.view.getjBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menambahkan presensi",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }

                if (cekKosong()) {
                    view.getjLblPeringatan().setText("Harap Isi Semua Data");
                    return;
                }

                String keterangan = view.getjTfKegiatan().getText();
                String lokasi = view.getjTfLokasi().getText();
                int status = view.getcBStatus().getSelectedIndex();

                datasource.add(DataSource.getSession().getId_data(), status, keterangan, lokasi);
                datasource.refreshTableModelBySiswa(DataSource.getSession().getId_data());
                clear();
            }
        });

        this.view.getjBtnKepulangan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datasource.setJamPulang(idPresensiTabel);
                clear();
                datasource.refreshTableModelBySiswa(DataSource.getSession().getId_data());
            }
        });

        this.view.getjBtnClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        this.view.getjBtnHome().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardSiswaController(new DashboardSiswaView()).show();
                view.dispose();
            }
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public boolean cekKosong() {
        if (view.getjTfKegiatan().getText().trim().isEmpty()
                || view.getjTfLokasi().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public void clear() {
        idPresensiTabel = -1;
        view.getjLblPeringatan().setText("");
        view.getjBtnKepulangan().setEnabled(false);
        view.getjTfKegiatan().setText("");
        view.getjTfLokasi().setText("");
    }
}
