package com.gillhax.springmvc.model;

/**
 * Created by alex on 31.07.2016.
 */

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}