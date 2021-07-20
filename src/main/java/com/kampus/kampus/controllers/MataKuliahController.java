package com.kampus.kampus.controllers;

import com.kampus.kampus.models.entites.Mahasiswa;
import com.kampus.kampus.models.repos.MataKuliahRepo;
import com.kampus.kampus.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matakuliah")
public class MataKuliahController {

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    MataKuliahRepo mataKuliahRepo;

    @GetMapping("/mahasiswa/{id}")
    public Iterable<Mahasiswa> getMahasiswaByMataKuliah(@PathVariable("id") int id) {
        return mahasiswaService.findByMataKuliah(id);
    }
}
