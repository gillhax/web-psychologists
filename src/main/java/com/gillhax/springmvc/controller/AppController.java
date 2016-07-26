package com.gillhax.springmvc.controller;

/**
 * Created by alex on 26.07.2016.
 */

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gillhax.springmvc.model.*;
import com.gillhax.springmvc.service.*;



@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    ProblemService problemService;

    @Autowired
    PsychologistService psychologistService;

    @Autowired
    PublicationService publicationService;


    @Autowired
    MessageSource messageSource;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<Problem> problems = problemService.findAllProblem();
        List<Psychologist> psychologists = psychologistService.findAllPsychologist();
        List<Publication> publications = publicationService.findAllPublication();
        model.addAttribute("problems", problems);
        model.addAttribute("psychologists", psychologists);
        model.addAttribute("publications", publications);
        return "list";
    }

}