package com.wurain.gridcolumninfo.repository;

import java.util.List;

import com.wurain.gridcolumninfo.model.Gridcolumninfo;

public interface GridcolumninfoRepository {

    public void updateColKey(String pgmId);
    public void updateColType(String pgmId);
    public void updateColAlign(String pgmId);
    public void updateColLength(String pgmId);
    public void updateColKeyFromRes(String pgmId);

    public List<Gridcolumninfo> findByPgmId(String pgmId);

    public void insert(Gridcolumninfo gridcolumninfo);
    public void update(Gridcolumninfo gridcolumninfo);
    public boolean isExistsCheckById(Gridcolumninfo gridcolumninfo);
}
