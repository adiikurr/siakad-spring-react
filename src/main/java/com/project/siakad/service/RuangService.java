package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Ruang;

public interface RuangService {
    public Ruang getRuangById(Integer ruangId);

    public List<Ruang> getAllRuang();

    public Ruang addRuang (Ruang ruang);

    public Ruang updateRuang (Integer id, Ruang ruang);
    
    public Ruang deleteRuangById (Integer id);
}
