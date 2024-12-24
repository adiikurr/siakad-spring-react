package com.project.siakad.service;

import java.util.List;

import com.project.siakad.model.Rapot;

public interface RapotService {

    public Rapot getRapotById(Integer rapotId);

    public List<Rapot> getAllRapot();

    public Rapot addRapot (Rapot rapot);

    public Rapot updateRapot (Integer id, Rapot rapot);
    
    public Rapot deleteRapotById (Integer id);
}
