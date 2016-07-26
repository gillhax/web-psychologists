package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.Problem;

import java.util.List;

/**
 * Created by alex on 25.07.2016.
 */

public interface ProblemDao {

    public Problem findById(int id);

    public List<Problem> findAllProblem();

     void save(Problem problem);

     void deleteById(int id);

}
