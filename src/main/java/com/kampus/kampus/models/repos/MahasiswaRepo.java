package com.kampus.kampus.models.repos;

import java.util.List;

import com.kampus.kampus.models.entites.Mahasiswa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Integer> {

    List<Mahasiswa> findByNamaContains(String name);

    Iterable<Mahasiswa> findByMataKuliahId(int mataKuliahId);

    Iterable<Mahasiswa> findByJurusanId(int jurusanId);

}
