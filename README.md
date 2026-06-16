# 📚 GUI_CRUD_Fikri — Aplikasi CRUD Data Siswa

Aplikasi desktop berbasis Java Swing untuk manajemen data siswa menggunakan konsep **Object-Oriented Programming (OOP)** dengan koneksi database MySQL.

---

## 🧰 Teknologi yang Digunakan

| Teknologi | Keterangan |
|-----------|------------|
| Java (Swing) | Framework GUI desktop |
| MySQL | Database penyimpanan data siswa |
| JDBC | Koneksi Java ke database |
| Maven | Build tool & dependency management |
| IntelliJ IDEA | IDE pengembangan |

---

## 📁 Struktur Project

```
GUL_CRUD_Fikri/
├── src/
│   └── main/
│       └── java/
│           └── org/example/
│               ├── DatabaseConnection.java   # Konfigurasi koneksi ke MySQL
│               ├── StudentDAO.java           # Data Access Object (CRUD logic)
│               ├── FormSiswa.java            # GUI utama (Swing JFrame)
│               └── Main.java                 # Entry point aplikasi
├── pom.xml                                   # Konfigurasi Maven
└── README.md
```

---

## 🗄️ Skema Database

Buat database dan tabel berikut di MySQL sebelum menjalankan aplikasi:

```sql
CREATE DATABASE db_siswa;

USE db_siswa;

CREATE TABLE students (
    nis     VARCHAR(20) PRIMARY KEY,
    nama    VARCHAR(100) NOT NULL,
    jurusan VARCHAR(100),
    jk      VARCHAR(15),
    alamat  TEXT
);
```

---

## ⚙️ Konfigurasi Koneksi Database

Edit file `DatabaseConnection.java` sesuai konfigurasi MySQL lokal kamu:

```java
// Contoh konfigurasi
String url  = "jdbc:mysql://localhost:3306/db_siswa";
String user = "root";
String pass = "password_kamu";
```

---

## 🚀 Cara Menjalankan

1. Clone atau download repository ini
2. Buka project di IntelliJ IDEA
3. Pastikan MySQL berjalan dan database sudah dibuat
4. Sesuaikan konfigurasi di `DatabaseConnection.java`
5. Jalankan `Main.java` atau `FormSiswa.java`

---

## ✨ Fitur Aplikasi

| Fitur | Deskripsi |
|-------|-----------|
| ➕ **Simpan** | Menambahkan data siswa baru ke database |
| 📋 **Tampil** | Menampilkan seluruh data siswa di tabel |
| ✏️ **Update** | Memperbarui data siswa berdasarkan NIS |
| 🗑️ **Hapus** | Menghapus data siswa berdasarkan NIS |
| 🔄 **Reset** | Mengosongkan semua field input |
| 🖱️ **Klik baris** | Klik data di tabel → otomatis mengisi form |

---

## 🏗️ Konsep OOP yang Diterapkan

- **Encapsulation** — Data siswa dikelola melalui class `StudentDAO`, memisahkan logika akses data dari tampilan GUI
- **Abstraction** — Class `DatabaseConnection` menyembunyikan detail koneksi JDBC dari kelas lain
- **Separation of Concerns** — Tampilan (`FormSiswa`), logika data (`StudentDAO`), dan koneksi (`DatabaseConnection`) dipisahkan ke masing-masing class
- **DAO Pattern** — Pola Data Access Object diterapkan untuk memisahkan operasi database dari logika bisnis

---

## 📸 Tampilan Aplikasi

Form input di sisi kiri memungkinkan pengguna memasukkan NIS, Nama, Jurusan, Jenis Kelamin, dan Alamat. Data yang tersimpan langsung ditampilkan pada tabel di sisi kanan secara real-time.

---

## 👤 Informasi Pengembang

| | |
|-|-|
| **Nama** | Muhammad Fikri |
| **NIM** | I.2510162 |
| **Program Studi** | Teknik Informatika |
| **Universitas** | Universitas Djuanda Bogor (UNIDA) |
| **Mata Kuliah** | Pemrograman Berorientasi Objek |

---

> Tugas Akhir — Mata Kuliah Pemrograman Berorientasi Objek (OOP)
