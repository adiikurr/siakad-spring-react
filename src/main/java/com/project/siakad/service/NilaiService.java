package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Nilai;

public interface NilaiService {

    public Nilai getNilaiById(Integer nilaiId);

    public List<Nilai> getAllNilai();

    public Nilai addNilai (Nilai nilai);

    public Nilai updateNilai (Integer id, Nilai nilai);
    
    public Nilai deleteNilaiById (Integer id);
}
