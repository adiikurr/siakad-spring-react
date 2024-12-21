package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Guru;

public interface GuruService {

    public Guru getGuruById(Integer guruId);

    public List<Guru> getAllGuru();

    public Guru addGuru (Guru guru);

    public Guru updateGuru (Integer id, Guru guru);
    
    public Guru deleteGuruById (Integer id);
}
