package com.gillhax.springmvc.controller;

/**
 * Created by alex on 26.07.2016.
 */

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.gillhax.springmvc.controller.form.PsychologistForm;
import com.gillhax.springmvc.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.gillhax.springmvc.model.*;
import com.gillhax.springmvc.service.*;
import org.springframework.web.multipart.MultipartFile;


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
    UserDocumentService userDocumentService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    FileValidator fileValidator;

    @InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }

    @RequestMapping(value = {  "/publication-{id}" }, method = RequestMethod.GET)
    public String listPublication(ModelMap model, @PathVariable Integer id) {
        List<Problem> problems = problemService.findAllProblem();
        model.addAttribute("problems", problems);

        model.addAttribute("publication", publicationService.findById(id));
        return "publication";
    }

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<Problem> problems = problemService.findAllProblem();
        List<Psychologist> psychologists = psychologistService.findAllPsychologist();
        List<Publication> publications = publicationService.findAllPublication();
        model.addAttribute("problems", problems);
        model.addAttribute("psychologists", psychologists);
        model.addAttribute("publications", publications);
        return "list";
    }

    //!!Admin pages

    @RequestMapping(value = {"/", "/admin/" }, method = RequestMethod.GET)
    public String adminIndex(ModelMap model) {
        return "admin/index";
    }

    @RequestMapping(value = { "/admin/problems" }, method = RequestMethod.GET)
    public String adminProblemList(ModelMap model) {
        List<Problem> problems = problemService.findAllProblem();
        model.addAttribute("problems", problems);
        return "admin/problem";
    }

    @RequestMapping(value = { "/admin/new-problem" }, method = RequestMethod.GET)
    public String adminNewProblem(ModelMap model) {
        model.addAttribute("problem", new Problem());
        model.addAttribute("edit", false);
        return "/admin/change-problem";
    }

    @RequestMapping(value = { "/admin/new-problem" }, method = RequestMethod.POST)
    public String adminSaveProblem(@Valid Problem problem, BindingResult result,
                              ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            return "/admin/change-problem";
        }
        problemService.saveProblem(problem);
        return "redirect:/admin/problems";
    }

    @RequestMapping(value = { "/admin/edit-problem-{id}" }, method = RequestMethod.GET)
    public String adminEditProblem(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("problem", problemService.findById(id));
        model.addAttribute("edit", true);
        return "/admin/change-problem";
    }

    @RequestMapping(value = { "/admin/edit-problem-{id}" }, method = RequestMethod.POST)
    public String adminUpdateProblem(@Valid Problem problem, BindingResult result,
                                ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors()) {
            model.addAttribute("edit", true);
            return "/admin/change-problem";
        }
        problemService.updateProblem(problem);
        return "redirect:/admin/problems";
    }

    @RequestMapping(value = { "/admin/delete-problem-{id}" }, method = RequestMethod.GET)
    public String adminDeleteProblem(@PathVariable Integer id) {
        problemService.deleteProblemById(id);
        return "redirect:/admin/problems";
    }


    //!!admin/publications
    @RequestMapping(value = { "/admin/publications" }, method = RequestMethod.GET)
    public String adminPublicationList(ModelMap model) {
        List<Publication> publications = publicationService.findAllPublication();
        model.addAttribute("publications", publications);
        return "admin/publication";
    }

    @RequestMapping(value = { "/admin/new-publication" }, method = RequestMethod.GET)
    public String adminNewPublication(ModelMap model) {
        model.addAttribute("publication", new Publication());
        model.addAttribute("problems", problemService.findAllProblem());
        model.addAttribute("psychologists", psychologistService.findAllPsychologist());
        model.addAttribute("edit", false);
        return "/admin/change-publication";
    }

    @RequestMapping(value = { "/admin/new-publication" }, method = RequestMethod.POST)
    public String adminSavePublication(@Valid Publication publication, BindingResult result,
                                  ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            model.addAttribute("problems", problemService.findAllProblem());
            model.addAttribute("psychologists", psychologistService.findAllPsychologist());
            return "/admin/change-publication";
        }
        publicationService.savePublication(publication);
        return "redirect:/admin/publications";
    }

    @RequestMapping(value = { "//admin/edit-publication-{id}" }, method = RequestMethod.GET)
    public String adminEditPublication(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("publication", publicationService.findById(id));
        model.addAttribute("problems", problemService.findAllProblem());
        model.addAttribute("psychologists", psychologistService.findAllPsychologist());
        model.addAttribute("edit", true);
        return "/admin/change-publication";
    }

    @RequestMapping(value = { "/admin/edit-publication-{id}" }, method = RequestMethod.POST)
    public String adminUpdatePublication(@Valid Publication publication, BindingResult result,
                                    ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors()) {
            model.addAttribute("problems", problemService.findAllProblem());
            model.addAttribute("psychologists", psychologistService.findAllPsychologist());
            model.addAttribute("edit", true);
            return "/admin/change-publication";
        }
        publicationService.updatePublication(publication);
        return "redirect:/admin/publications";
    }

    @RequestMapping(value = { "/admin/delete-publication-{id}" }, method = RequestMethod.GET)
    public String adminDeletePublication(@PathVariable Integer id) {
        publicationService.deletePublicationById(id);
        return "redirect:/admin/publications";
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
        model.addAttribute("psychologistForm", new PsychologistForm());
        model.addAttribute("edit", false);
        return "change-psychologist";
    }

    @RequestMapping(value = { "/new-psychologist" }, method = RequestMethod.POST)
    public String savePsychologist(@Valid@ModelAttribute(value = "psychologistForm") PsychologistForm psychologistForm, BindingResult result,
                                   ModelMap model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("edit", false);
            return "change-psychologist";
        }
        psychologistService.savePsychologist(psychologistForm.preparePsychologistToSave());
        return "redirect:/list";
    }

    @RequestMapping(value = { "/edit-psychologist-{id}" }, method = RequestMethod.GET)
    public String editPsychologist(@PathVariable Integer id, ModelMap model) {
        model.addAttribute("psychologistForm", new PsychologistForm(psychologistService.findById(id)));
        model.addAttribute("edit", true);
        return "change-psychologist";
    }

    @RequestMapping(value = { "/edit-psychologist-{id}" }, method = RequestMethod.POST)
    public String updatePsychologist(@Valid PsychologistForm psychologistForm, BindingResult result,
                                ModelMap model, @PathVariable Integer id) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("edit", true);
            return "change-psychologist";
        }
        if(psychologistForm.getFile().getContentType().equalsIgnoreCase("application/octet-stream")) {
            psychologistService.updatePsychologist(psychologistForm);
            return "redirect:/list";
            }
        else {
            if (PsychologistForm.preparePsychologistToDelete(psychologistService.findById(id).getPhoto())) {
                psychologistService.updatePsychologist(psychologistForm.preparePsychologistToSave());
                return "redirect:/list";
            } else {
                model.addAttribute("edit", true);
                return "change-psychologist";
            }
        }
    }

    @RequestMapping(value = { "/delete-psychologist-{id}" }, method = RequestMethod.GET)
    public String deletePsychologist(@PathVariable Integer id) {
        if (PsychologistForm.preparePsychologistToDelete(psychologistService.findById(id).getPhoto())) {
            psychologistService.deletePsychologistById(id);
            return "redirect:/list";
        }
        else return "/list";
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





    //!!User documents resolver

    @RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        Psychologist psychologist = psychologistService.findById(userId);
        model.addAttribute("user", psychologist);

        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);

        List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
        model.addAttribute("documents", documents);

        return "manage-document";
    }


    @RequestMapping(value = { "/download-document-{userId}-{docId}" }, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
        UserDocument document = userDocumentService.findById(docId);
        response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");

        FileCopyUtils.copy(document.getContent(), response.getOutputStream());

        return "redirect:/add-document-"+userId;
    }

    @RequestMapping(value = { "/delete-document-{userId}-{docId}" }, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
        userDocumentService.deleteById(docId);
        return "redirect:/add-document-"+userId;
    }

    @RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.POST)
    public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int userId) throws IOException{

        if (result.hasErrors()) {
            System.out.println("Validation errors");
            Psychologist psychologist = psychologistService.findById(userId);
            model.addAttribute("psychologist", psychologist);

            List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
            model.addAttribute("documents", documents);

            return "manage-document";
        } else {

            System.out.println("Fetching file");

            Psychologist psychologist = psychologistService.findById(userId);
            model.addAttribute("psychologist", psychologist);

            saveDocument(fileBucket, psychologist);

            return "redirect:/add-document-"+userId;
        }
    }

    private void saveDocument(FileBucket fileBucket, Psychologist psychologist) throws IOException{

        UserDocument document = new UserDocument();

        MultipartFile multipartFile = fileBucket.getFile();

        document.setName(multipartFile.getOriginalFilename());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());
        document.setPsychologist(psychologist);
        userDocumentService.saveDocument(document);
    }


}