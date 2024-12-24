package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Mapel;

public interface MapelService {

    public Mapel getMapelById(Integer mapelId);

    public List<Mapel> getAllMapel();

    public Mapel addMapel (Mapel mapel);

    public Mapel updateMapel (Integer id, Mapel mapel);
    
    public Mapel deleteMapelById (Integer id);
}
