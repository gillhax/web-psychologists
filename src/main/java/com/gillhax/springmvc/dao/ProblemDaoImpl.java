package com.gillhax.springmvc.dao;

/**
 * Created by alex on 25.07.2016.
 */

import java.util.Collection;
import java.util.List;

import com.gillhax.springmvc.model.Problem;
import org.springframework.stereotype.Repository;

@Repository("problemDao")
public class ProblemDaoImpl extends AbstractDao<Integer, Problem> implements ProblemDao {

    public Problem findById(int id) {
        Problem problem = getByKey(id);
        if(problem!=null){
            initializeCollection(problem.getPublications());
        }
        return problem;
    }


    @SuppressWarnings("unchecked")
    public List<Problem> findAllProblem() {
        List<Problem> problems = getEntityManager()
                .createQuery("SELECT p FROM Problem p ORDER BY p.name ASC")
                .getResultList();
        return problems;
    }

    public void save(Problem problem) {
        persist(problem);
    }

    public void deleteById(int id) {
        delete(getByKey(id));
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}