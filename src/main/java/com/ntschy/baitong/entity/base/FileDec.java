package com.ntschy.baitong.entity.base;

import lombok.Data;

@Data
public class FileDec {

    private String fileName;

    private String originFileName;

    private Long fileSize;

    public FileDec(String fileName, String originFileName) {
        this.fileName = fileName;
        this.originFileName = originFileName;
    }

    public FileDec() {

    }
}
