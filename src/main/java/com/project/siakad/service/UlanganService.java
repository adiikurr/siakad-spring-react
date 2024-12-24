package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Ulangan;

public interface UlanganService {

    public Ulangan getUlanganById(Integer ulanganId);

    public List<Ulangan> getAllUlangan();

    public Ulangan addUlangan (Ulangan ulangan);

    public Ulangan updateUlangan (Integer id, Ulangan ulangan);
    
    public Ulangan deleteUlanganById (Integer id);
}
