package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE - Simpan data baru
    public void simpan(String nis, String nama, String jurusan, String jk, String alamat) throws SQLException {
        String sql = "INSERT INTO students (nis, nama, jurusan, jk, alamat) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nis);
            ps.setString(2, nama);
            ps.setString(3, jurusan);
            ps.setString(4, jk);
            ps.setString(5, alamat);
            ps.executeUpdate();
        }
    }

    // READ - Ambil semua data
    public List<String[]> getAll() throws SQLException {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DatabaseConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("nis"),
                        rs.getString("nama"),
                        rs.getString("jurusan"),
                        rs.getString("jk"),
                        rs.getString("alamat")
                });
            }
        }
        return list;
    }

    // UPDATE - Update data berdasarkan NIS
    public void update(String nis, String nama, String jurusan, String jk, String alamat) throws SQLException {
        String sql = "UPDATE students SET nama=?, jurusan=?, jk=?, alamat=? WHERE nis=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nama);
            ps.setString(2, jurusan);
            ps.setString(3, jk);
            ps.setString(4, alamat);
            ps.setString(5, nis);
            ps.executeUpdate();
        }
    }

    // DELETE - Hapus data berdasarkan NIS
    public void hapus(String nis) throws SQLException {
        String sql = "DELETE FROM students WHERE nis=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nis);
            ps.executeUpdate();
        }
    }
}