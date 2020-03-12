package com.wurain.gridcolumninfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wurain.gridcolumninfo.model.Gridcolumninfo;
import com.wurain.gridcolumninfo.service.GridcolumninfoService;

@RestController
@RequestMapping("/gridcolumninfo")
public class GridcolumninfoController {

    @Autowired
    private GridcolumninfoService gridcolumninfoService;

    @GetMapping("/findByPgmId/{pgmId}")
    public List<Gridcolumninfo> findByPgmId(@PathVariable("pgmId") String pgmId) {

        return gridcolumninfoService.findByPgmId(pgmId);
    }

    @PostMapping("/save")
    public void save(@RequestBody Gridcolumninfo gridcolumninfo) {

        gridcolumninfoService.save(gridcolumninfo);
    }
}
