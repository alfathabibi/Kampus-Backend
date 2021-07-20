package com.kampus.kampus.controllers;

import com.kampus.kampus.models.entites.Mahasiswa;
import com.kampus.kampus.models.repos.JurusanRepo;
import com.kampus.kampus.services.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jurusan")
public class JurusanController {

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    JurusanRepo jurusanRepo;

    @GetMapping("/mahasiswa/{id}")
    public Iterable<Mahasiswa> getMahasiswaByJurusanId(@PathVariable("id") int id) {
        // Jurusan jurusan = jurusanRepo.findById(id).get();

        return mahasiswaService.findByJurusanId(id);
    }
}
