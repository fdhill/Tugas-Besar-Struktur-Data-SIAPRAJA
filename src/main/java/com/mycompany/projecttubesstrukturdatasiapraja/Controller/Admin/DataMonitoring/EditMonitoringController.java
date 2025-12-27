/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.EditMonitoringView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihSiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class EditMonitoringController {

    DataSourceMonitoring datasource;
    EditMonitoringView view;

    int idMonitoring = -1;
    int idSiswa = -1;
    int idGuru = -1;
    int idInstansi = -1;

    public EditMonitoringController(DataSourceMonitoring datasource, EditMonitoringView view, int idMonitoring) {
        this.datasource = datasource;
        this.view = view;
        this.idMonitoring = idMonitoring;

        dataLama();
        show();

        this.view.getjBtnCancle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        this.view.getjBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menyimpan",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                
                datasource.update(idSiswa, idInstansi, idGuru, idMonitoring);

                datasource.refreshTableModel();
                view.dispose();
            }
        });

        this.view.getjBtnPilihSiswa().addActionListener(e -> {
            new PilihSiswaController(new DataSourceSiswa(), new PilihSiswaView(), (Integer idSiswa) -> {
                view.getjBtnPilihSiswa().setText(String.valueOf(idSiswa));
                this.idSiswa = idSiswa;
            });
        });

        this.view.getjBtnPilihGuru().addActionListener(e -> {
            new PilihGuruController(new DataSourceGuru(), new PilihGuruView(), (Integer idGuru) -> {
                view.getjBtnPilihGuru().setText(String.valueOf(idGuru));
                this.idGuru = idGuru;
            });
        });

        this.view.getjBtnPilihInstansi().addActionListener(e -> {
            new PilihInstansiController(new DataSourceInstansi(), new PilihInstansiView(), (Integer idInstansi) -> {
                view.getjBtnPilihInstansi().setText(String.valueOf(idInstansi));
                this.idInstansi = idInstansi;
            });
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public void dataLama() {
        view.getjTfMulai().setText(datasource.getMonitoringById(idMonitoring).getTanggal_mulai());
        view.getjTfSelesai().setText(datasource.getMonitoringById(idMonitoring).getTanggal_selesai());

        view.getjBtnPilihSiswa().setText(datasource.getSiswaByMonitoringId(idMonitoring).getData().getNama());
        view.getjBtnPilihGuru().setText((datasource.getGuruByMonitoringId(idMonitoring) == null) ? "Pilih Guru" : datasource.getGuruByMonitoringId(idMonitoring).getData().getNama());
        view.getjBtnPilihInstansi().setText(datasource.getInstansiByMonitoringId(idMonitoring).getData().getNama());

        idSiswa = datasource.getSiswaByMonitoringId(idMonitoring).getData().getId();
        idGuru = (datasource.getGuruByMonitoringId(idMonitoring) == null) ? -1 : datasource.getGuruByMonitoringId(idMonitoring).getData().getId();
        idInstansi = datasource.getInstansiByMonitoringId(idMonitoring).getData().getId();
    }
}
