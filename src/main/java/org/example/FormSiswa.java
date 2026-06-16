package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FormSiswa extends JFrame {

    private JTextField txtNis, txtNama;
    private JComboBox<String> cmbJurusan, cmbJk;
    private JTextArea txtAlamat;
    private JTable table;
    private DefaultTableModel tableModel;
    private StudentDAO dao = new StudentDAO();

    public FormSiswa() {
        setTitle("Form Siswa");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label & Input
        JLabel lblNis = new JLabel("NIS");
        lblNis.setBounds(20, 20, 80, 25);
        add(lblNis);

        txtNis = new JTextField();
        txtNis.setBounds(100, 20, 200, 25);
        add(txtNis);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 55, 80, 25);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(100, 55, 200, 25);
        add(txtNama);

        JLabel lblJurusan = new JLabel("Jurusan");
        lblJurusan.setBounds(20, 90, 80, 25);
        add(lblJurusan);

        cmbJurusan = new JComboBox<>(new String[]{"Rekayasa Perangkat Lunak", "Teknik Komputer Jaringan", "Multimedia"});
        cmbJurusan.setBounds(100, 90, 200, 25);
        add(cmbJurusan);

        JLabel lblJk = new JLabel("JK");
        lblJk.setBounds(20, 125, 80, 25);
        add(lblJk);

        cmbJk = new JComboBox<>(new String[]{"Laki-laki", "Perempuan"});
        cmbJk.setBounds(100, 125, 200, 25);
        add(cmbJk);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(20, 160, 80, 25);
        add(lblAlamat);

        txtAlamat = new JTextArea();
        JScrollPane scrollAlamat = new JScrollPane(txtAlamat);
        scrollAlamat.setBounds(100, 160, 200, 80);
        add(scrollAlamat);

        // Tombol
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(60, 260, 100, 30);
        add(btnSimpan);

        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBounds(170, 260, 100, 30);
        add(btnHapus);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(60, 300, 100, 30);
        add(btnUpdate);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(170, 300, 100, 30);
        add(btnReset);

        // Tabel
        tableModel = new DefaultTableModel(new String[]{"NIS", "Nama", "Jurusan", "JK", "Alamat"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBounds(320, 20, 400, 280);
        add(scrollTable);

        // Load data awal
        loadTable();

        // Event tombol Simpan
        btnSimpan.addActionListener(e -> {
            try {
                dao.simpan(txtNis.getText(), txtNama.getText(),
                        cmbJurusan.getSelectedItem().toString(),
                        cmbJk.getSelectedItem().toString(),
                        txtAlamat.getText());
                loadTable();
                resetForm();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Event tombol Hapus
        btnHapus.addActionListener(e -> {
            try {
                dao.hapus(txtNis.getText());
                loadTable();
                resetForm();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Event tombol Update
        btnUpdate.addActionListener(e -> {
            try {
                dao.update(txtNis.getText(), txtNama.getText(),
                        cmbJurusan.getSelectedItem().toString(),
                        cmbJk.getSelectedItem().toString(),
                        txtAlamat.getText());
                loadTable();
                resetForm();
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Event tombol Reset
        btnReset.addActionListener(e -> resetForm());

        // Klik baris tabel → isi form
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.getSelectedRow();
                txtNis.setText(tableModel.getValueAt(row, 0).toString());
                txtNama.setText(tableModel.getValueAt(row, 1).toString());
                cmbJurusan.setSelectedItem(tableModel.getValueAt(row, 2).toString());
                cmbJk.setSelectedItem(tableModel.getValueAt(row, 3).toString());
                txtAlamat.setText(tableModel.getValueAt(row, 4).toString());
            }
        });

        setVisible(true);
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        try {
            List<String[]> list = dao.getAll();
            for (String[] row : list) {
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void resetForm() {
        txtNis.setText("");
        txtNama.setText("");
        cmbJurusan.setSelectedIndex(0);
        cmbJk.setSelectedIndex(0);
        txtAlamat.setText("");
    }

    public static void main(String[] args) {
        new FormSiswa();
    }
}