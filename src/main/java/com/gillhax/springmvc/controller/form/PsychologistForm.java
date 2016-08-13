package com.gillhax.springmvc.controller.form;

import com.gillhax.springmvc.model.Psychologist;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by alex on 01.08.2016.
 */

public class PsychologistForm extends Psychologist {

    private static String realLocation = "D:\\Project\\Java\\apache-tomcat-7.0.70\\userdata\\photo\\";

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public PsychologistForm() {
    }

    public PsychologistForm(Psychologist psychologist) {
        this.setId(psychologist.getId());
        this.setName(psychologist.getName());
        this.setContacts(psychologist.getContacts());
        this.setAbout(psychologist.getAbout());
        this.setPhoto(psychologist.getPhoto());
        this.setPassword(psychologist.getPassword());
        this.setUsername(psychologist.getUsername());
    }

    public Psychologist getPsychologist() {
        Psychologist psychologist = new Psychologist();
        psychologist.setId(this.getId());
        psychologist.setName(this.getName());
        psychologist.setContacts(this.getContacts());
        psychologist.setAbout(this.getAbout());
        psychologist.setPhoto(this.getPhoto());
        psychologist.setUsername(this.getUsername());
        psychologist.setPassword(this.getPassword());
        return psychologist;
    }

    public static String getRealPathToFileBySource(String photoName) {
        String [] source = photoName.split("/photo/", -1);
        return realLocation + source[1];
    }

    public Psychologist preparePsychologistToSave() throws IOException {
        String destPath = realLocation + file.getOriginalFilename();
        String source = "/photo/"+ file.getOriginalFilename();
        file.transferTo(new File(destPath));
        this.setPhoto(source);
        return getPsychologist();
    }


    public static boolean preparePsychologistToDelete(String photoName) {
        return new File(getRealPathToFileBySource(photoName)).delete();
    }



}
