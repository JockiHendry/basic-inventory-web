package com.jocki.inventory.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.jocki.inventory.repository.specification.FilterSpecification.Operation;

public class BasicFilter<T> extends Filter<T> {
    
    public String name;
    public Operation op;
    public Object[] args;

    public BasicFilter(String name, Operation op, Object... args) {
        this.name = name;
        this.op = op;
        this.args = args;
    }
    
    @Override @SuppressWarnings({ "unchecked", "rawtypes" })
    public Predicate toPredicate(CriteriaBuilder cb, Root<T> root) {
        Expression path = toPath(root, name);
        switch (op) {
        case EQ:
            return cb.equal(path, args[0]);
        case LIKE:                              
            return cb.like(path, (String) args[0]);
        case MIN:   
            return cb.greaterThanOrEqualTo(path, Integer.parseInt((String) args[0]));
        default:
            return null;
        }
    }    
    
}