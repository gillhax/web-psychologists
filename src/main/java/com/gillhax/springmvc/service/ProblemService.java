package com.gillhax.springmvc.service;

import com.gillhax.springmvc.model.Problem;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */
public interface ProblemService {

    Problem findById(int id);

    void saveProblem(Problem problem);

    void updateProblem(Problem problem);

    void deleteProblemById(int id);

    List<Problem> findAllProblem();

}
