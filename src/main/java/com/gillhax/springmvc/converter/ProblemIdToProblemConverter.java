package com.gillhax.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gillhax.springmvc.model.Problem;
import com.gillhax.springmvc.service.ProblemService;

/**
 * Created by alex on 26.07.2016.
 */

@Component
public class ProblemIdToProblemConverter implements Converter<Object, Problem>{

    @Autowired
    ProblemService problemService;

    public Problem convert(Object element) {
        if(element.toString().contains("Problem")) {
            return (Problem) element;
        }
        else {
            Integer id = Integer.parseInt((String)element);
            Problem problem = problemService.findById(id);
            System.out.println("Problem  : " + problem);
            return problem;
        }
    }

}