package com.kampus.kampus.models.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nim;

    private String nama;

    @ManyToOne
    private Jurusan jurusan;

    @ManyToOne
    private Fakultas fakultas;

    @ManyToMany
    private List<MataKuliah> mataKuliah;

    public Mahasiswa() {
    }

    public Mahasiswa(int id, String nim, String nama, String jurusanId, String fakultasId) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jurusan = new Jurusan(Integer.parseInt(jurusanId), "");
        this.fakultas = new Fakultas(Integer.parseInt(fakultasId), "");
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

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public List<MataKuliah> getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(List<MataKuliah> mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public void addMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah.add(mataKuliah);
    }

}
