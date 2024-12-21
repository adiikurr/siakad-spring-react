package com.project.siakad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.siakad.exception.ResourceNotFoundException;
import com.project.siakad.model.Siswa;
import com.project.siakad.repository.SiswaRepo;
import com.project.siakad.service.SiswaService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SiswaServiceImpl implements SiswaService{
    @Autowired private SiswaRepo SiswaRepo;

    @Override
    public Siswa getSiswaById(Integer siswaId) {
        return SiswaRepo.findById(siswaId).orElseThrow(() 
            -> new ResourceNotFoundException("Data Siswa not found with ID: " + siswaId));
    }
    @Override
    public List<Siswa> getAllSiswa(){
        return SiswaRepo.findAll();
    }
    @Override
    public Siswa addSiswa (Siswa siswa) {   
        siswa.setCreated_at(LocalDateTime.now());
        return SiswaRepo.save(siswa);
    }
    @Override
    public Siswa updateSiswa (Integer id, Siswa siswa) {
        Siswa existingSiswa = SiswaRepo.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Data Siswa not found with ID: " + id));
        
        existingSiswa.setNo_induk(siswa.getNo_induk());
        existingSiswa.setNisn(siswa.getNisn());
        existingSiswa.setNama_siswa(siswa.getNama_siswa());
        existingSiswa.setKelas_id(siswa.getKelas_id());
        existingSiswa.setGender(siswa.getGender());
        existingSiswa.setNo_telp(siswa.getNo_telp());
        existingSiswa.setTempat_lahir(siswa.getTempat_lahir());
        existingSiswa.setTanggal_lahir(siswa.getTanggal_lahir());
        existingSiswa.setAlamat(siswa.getAlamat());

        return SiswaRepo.save(existingSiswa);
    }
    @Override
    public Siswa deleteSiswaById (Integer id) {
        Siswa existingSiswa = SiswaRepo.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Data Siswa not found with ID: " + id));

        SiswaRepo.delete(existingSiswa);
        return existingSiswa;
    }
}
