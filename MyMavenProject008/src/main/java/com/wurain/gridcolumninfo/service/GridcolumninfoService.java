package com.wurain.gridcolumninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wurain.gridcolumninfo.model.Gridcolumninfo;
import com.wurain.gridcolumninfo.repository.GridcolumninfoRepository;

@Service
public class GridcolumninfoService {

    @Autowired
    private GridcolumninfoRepository gridcolumninfoRepository;

    public List<Gridcolumninfo> findByPgmId(String pgmId) {

        gridcolumninfoRepository.updateColKey(pgmId);
        gridcolumninfoRepository.updateColType(pgmId);
        gridcolumninfoRepository.updateColAlign(pgmId);
        gridcolumninfoRepository.updateColLength(pgmId);
        gridcolumninfoRepository.updateColKeyFromRes(pgmId);

        return gridcolumninfoRepository.findByPgmId(pgmId);
    }

    public void save(Gridcolumninfo gridcolumninfo) {
        if(gridcolumninfoRepository.isExistsCheckById(gridcolumninfo)) {
            gridcolumninfoRepository.update(gridcolumninfo);
        } else {
            gridcolumninfoRepository.insert(gridcolumninfo);
        }
    }
}
