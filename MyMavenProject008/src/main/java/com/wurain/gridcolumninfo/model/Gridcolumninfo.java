package com.wurain.gridcolumninfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gridcolumninfo {

    private String pgmId;
    private int columnId;
    private String columnTitle;
    private String columnKey;
    private String columnType;
    private String columnAlign;
    private Integer columnLength;
}
