package com.kampus.kampus.controllers;

import com.kampus.kampus.helpers.MahasiswaHelper;
import com.kampus.kampus.models.entites.Fakultas;
import com.kampus.kampus.models.entites.Jurusan;
import com.kampus.kampus.models.entites.Mahasiswa;
import com.kampus.kampus.models.entites.MataKuliah;
import com.kampus.kampus.models.repos.MataKuliahRepo;
import com.kampus.kampus.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService mahasiswaService;

    @Autowired
    private MataKuliahRepo mataKuliahRepo;

    @PostMapping("/add")
    public Mahasiswa create(MahasiswaHelper mahasiswaHelper) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama(mahasiswaHelper.getNama());
        mahasiswa.setNim(mahasiswaHelper.getNim());
        mahasiswa.setJurusan(new Jurusan(mahasiswaHelper.getJurusan(), ""));
        mahasiswa.setFakultas(new Fakultas(mahasiswaHelper.getFakultas(), ""));

        return mahasiswaService.save(mahasiswa);
    }

    @GetMapping("/all")
    public Iterable<Mahasiswa> getAll() {
        return mahasiswaService.findAll();
    }

    @GetMapping("/{id}")
    public Mahasiswa getMahasiswa(@PathVariable("id") int id) {
        return mahasiswaService.findOne(id);
    }

    @PutMapping("/update")
    public Mahasiswa update(MahasiswaHelper mahasiswaHelper) {
        Mahasiswa mahasiswa = mahasiswaService.findOne(mahasiswaHelper.getId());
        mahasiswa.setNama(mahasiswaHelper.getNama());
        mahasiswa.setNim(mahasiswaHelper.getNim());
        return mahasiswaService.save(mahasiswa);
    }

    @PutMapping("/addMataKuliah")
    public Mahasiswa addMataKuliah(int idMataKuliah, int idMahasiswa) {

        MataKuliah mataKuliah = mataKuliahRepo.findById(idMataKuliah).get();
        Mahasiswa mahasiswa = mahasiswaService.findOne(idMahasiswa);

        mahasiswa.addMataKuliah(mataKuliah);
        return mahasiswaService.save(mahasiswa);
    }

    @DeleteMapping("/delete")
    public String delete(int id) {
        mahasiswaService.deleteMahasiswa(id);
        return "{\"message\": \"Berhasil Menghapus Mahasiswa\"}";
    }
}
