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


    //!! Problem resolves

    @RequestMapping(value = { "/new-problem" }, method = RequestMethod.GET)
    public String newProblem(ModelMap model) {
        model.addAttribute("problem", new Problem());
        model.addAttribute("edit", false);
        return "change-problem";
    }

    @RequestMapping(value = { "/new-problem" }, method = RequestMethod.POST)
    public String saveProblem(@Valid Problem problem, BindingResult result,
                           ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            return "change-problem";
        }
        problemService.saveProblem(problem);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/edit-problem-{id}" }, method = RequestMethod.GET)
    public String editProblem(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("problem", problemService.findById(id));
        model.addAttribute("edit", true);
        return "change-problem";
    }

    @RequestMapping(value = { "/edit-problem-{id}" }, method = RequestMethod.POST)
    public String updateProblem(@Valid Problem problem, BindingResult result,
                             ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors()) {
            model.addAttribute("edit", true);
            return "change-problem";
        }
        problemService.updateProblem(problem);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/delete-problem-{id}" }, method = RequestMethod.GET)
    public String deleteProblem(@PathVariable Integer id) {
        problemService.deleteProblemById(id);
        return "redirect:/list";
    }


    //!! Psychologist resolves

    @RequestMapping(value = { "/new-psychologist" }, method = RequestMethod.GET)
    public String newPsychologist(ModelMap model) {
        model.addAttribute("psychologist", new Psychologist());
        model.addAttribute("edit", false);
        return "change-psychologist";
    }

    @RequestMapping(value = { "/new-psychologist" }, method = RequestMethod.POST)
    public String savePsychologist(@Valid Psychologist psychologist, BindingResult result,
                              ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            return "change-psychologist";
        }
        psychologistService.savePsychologist(psychologist);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/edit-psychologist-{id}" }, method = RequestMethod.GET)
    public String editPsychologist(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("psychologist", psychologistService.findById(id));
        model.addAttribute("edit", true);
        return "change-psychologist";
    }

    @RequestMapping(value = { "/edit-psychologist-{id}" }, method = RequestMethod.POST)
    public String updatePsychologist(@Valid Psychologist psychologist, BindingResult result,
                                ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors()) {
            model.addAttribute("edit", true);
            return "change-psychologist";
        }
        psychologistService.updatePsychologist(psychologist);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/delete-psychologist-{id}" }, method = RequestMethod.GET)
    public String deletePsychologist(@PathVariable Integer id) {
        psychologistService.deletePsychologistById(id);
        return "redirect:/list";
    }

    //!! Publication resolves

    @RequestMapping(value = { "/new-publication" }, method = RequestMethod.GET)
    public String newPublication(ModelMap model) {
        model.addAttribute("publication", new Publication());
        model.addAttribute("problems", problemService.findAllProblem());
        model.addAttribute("psychologists", psychologistService.findAllPsychologist());
        model.addAttribute("edit", false);
        return "change-publication";
    }

    @RequestMapping(value = { "/new-publication" }, method = RequestMethod.POST)
    public String savePublication(@Valid Publication publication, BindingResult result,
                                   ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            model.addAttribute("problems", problemService.findAllProblem());
            model.addAttribute("psychologists", psychologistService.findAllPsychologist());
            return "change-publication";
        }
        publicationService.savePublication(publication);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/edit-publication-{id}" }, method = RequestMethod.GET)
    public String editPublication(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("publication", publicationService.findById(id));
        model.addAttribute("problems", problemService.findAllProblem());
        model.addAttribute("psychologists", psychologistService.findAllPsychologist());
        model.addAttribute("edit", true);
        return "change-publication";
    }

    @RequestMapping(value = { "/edit-publication-{id}" }, method = RequestMethod.POST)
    public String updatePublication(@Valid Publication publication, BindingResult result,
                                     ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors()) {
            model.addAttribute("problems", problemService.findAllProblem());
            model.addAttribute("psychologists", psychologistService.findAllPsychologist());
            model.addAttribute("edit", true);
            return "change-publication";
        }
        publicationService.updatePublication(publication);
        return "redirect:/list";
    }

    @RequestMapping(value = { "/delete-publication-{id}" }, method = RequestMethod.GET)
    public String deletePublication(@PathVariable Integer id) {
        publicationService.deletePublicationById(id);
        return "redirect:/list";
    }


}