package com.gillhax.springmvc.service;

/**
 * Created by alex on 26.07.2016.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gillhax.springmvc.dao.ProblemDao;
import com.gillhax.springmvc.model.Problem;


@Service("problemService")
@Transactional
public class ProblemServiceImpl implements ProblemService{

    @Autowired
    private ProblemDao dao;

    public Problem findById(int id) {
        return dao.findById(id);
    }

    public void saveProblem(Problem problem) {
        dao.save(problem);
    }

    public void updateProblem(Problem problem) {
        Problem entity = dao.findById(problem.getId());
        if(entity!=null){
            entity.setName(problem.getName());
        }
    }


    public void deleteProblemById(int id) {
        dao.deleteById(id);
    }

    public List<Problem> findAllProblem() {
        return dao.findAllProblem();
    }

}

