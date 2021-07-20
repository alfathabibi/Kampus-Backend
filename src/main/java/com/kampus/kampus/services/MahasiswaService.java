package com.kampus.kampus.services;

import javax.transaction.Transactional;

import com.kampus.kampus.models.entites.Mahasiswa;
import com.kampus.kampus.models.repos.MahasiswaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MahasiswaService {

    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    public Mahasiswa save(Mahasiswa mahasiswa) {
        return mahasiswaRepo.save(mahasiswa);
    }

    public Mahasiswa findOne(int id) {
        return mahasiswaRepo.findById(id).get();
    }

    public Iterable<Mahasiswa> findAll() {
        return mahasiswaRepo.findAll();
    }

    public void deleteMahasiswa(int id) {
        mahasiswaRepo.deleteById(id);
    }

    public Iterable<Mahasiswa> findByName(String name) {
        return mahasiswaRepo.findByNamaContains(name);
    }

    public Iterable<Mahasiswa> findByMataKuliah(int id) {
        return mahasiswaRepo.findByMataKuliahId(id);
    }

    public Iterable<Mahasiswa> findByJurusanId(int jurusanId) {
        return mahasiswaRepo.findByJurusanId(jurusanId);
    }
}
