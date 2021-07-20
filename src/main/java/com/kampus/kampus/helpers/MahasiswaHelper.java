package com.kampus.kampus.helpers;

import javax.persistence.GeneratedValue;

public class MahasiswaHelper {

    @GeneratedValue
    private int id;

    private String nim;

    private String nama;

    private int jurusan;

    private int fakultas;

    public MahasiswaHelper() {
    }

    public MahasiswaHelper(int id, String nim, String nama, int jurusan, int fakultas) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJurusan() {
        return jurusan;
    }

    public void setJurusan(int jurusan) {
        this.jurusan = jurusan;
    }

    public int getFakultas() {
        return fakultas;
    }

    public void setFakultas(int fakultas) {
        this.fakultas = fakultas;
    }

}
