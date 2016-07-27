package com.gillhax.springmvc.converter;

import com.gillhax.springmvc.model.Psychologist;
import com.gillhax.springmvc.service.PsychologistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 26.07.2016.
 */

@Component
public class PsychologistIdToPsychologistConverter implements Converter<Object, Psychologist> {

    @Autowired
    PsychologistService psychologistService;

    public Psychologist convert(Object element) {
        if(element.toString().contains("Psychologist")) {
            return (Psychologist) element;
        }
        else {
            Integer id = Integer.parseInt((String)element);
            Psychologist psychologist = psychologistService.findById(id);
            System.out.println("Psychologist  : " + psychologist);
            return psychologist;
        }
    }

}