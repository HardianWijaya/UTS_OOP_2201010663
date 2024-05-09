/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author LAB F
 */
import java.util.Scanner;

public class AplikasiBuku {
    private static final int MAX_CATATAN = 100;
    private Catatan[] catatanArray;
    private int jumlahCatatan;

    public AplikasiBuku() {
        catatanArray = new Catatan[MAX_CATATAN];
        jumlahCatatan = 0;
    }

    public void tambahCatatan(String judul, String isi) {
        if (jumlahCatatan < MAX_CATATAN) {
            catatanArray[jumlahCatatan++] = new Catatan(judul, isi);
            System.out.println("Catatan  berhasil ditambahkan.");
        } else {
            System.out.println("Maaf, sudah mencapai batas maksimum catatan.");
        }
    }

    public void tampilkanCatatan() {
        if (jumlahCatatan == 0) {
            System.out.println("Belum ada catatan.");
        } else {
            System.out.println("Daftar Catatan:");
            for (int i = 0; i < jumlahCatatan; i++) {
                System.out.println("Catatan " + (i + 1) + ":");
                System.out.println(catatanArray[i]);
            }
        }
    }

    public void ubahCatatan(int index, String judul, String isi) {
        if (index >= 0 && index < jumlahCatatan) {
            catatanArray[index].setJudul(judul);
            catatanArray[index].setIsi(isi);
            System.out.println("Catatan berhasil diubah.");
        } else {
            System.out.println("Indeks catatan tidak valid.");
        }
    }

    public void hapusCatatan(int index) {
        if (index >= 0 && index < jumlahCatatan) {
            for (int i = index; i < jumlahCatatan - 1; i++) {
                catatanArray[i] = catatanArray[i + 1];
            }
            catatanArray[jumlahCatatan - 1] = null;
            jumlahCatatan--;
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Indeks catatan tidak valid.");
        }
    }

    public static void main(String[] args) {
        AplikasiBuku aplikasi = new AplikasiBuku();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan isi Buku: ");
                    String isi = scanner.nextLine();
                    aplikasi.tambahCatatan(judul, isi);
                    break;
                case 2:
                    aplikasi.tampilkanCatatan();
                    break;
                case 3:
                    System.out.print("Masukkan indeks Buku yang ingin diubah: ");
                    int indexUbah = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Masukkan judul buku baru: ");
                    judul = scanner.nextLine();
                    System.out.print("Masukkan isi buku baru: ");
                    isi = scanner.nextLine();
                    aplikasi.ubahCatatan(indexUbah - 1, judul, isi);
                    break;
                case 4:
                    System.out.print("Masukkan indeks Buku yang ingin dihapus: ");
                    int indexHapus = scanner.nextInt();
                    aplikasi.hapusCatatan(indexHapus - 1);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini ");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        scanner.close();
    }
}

