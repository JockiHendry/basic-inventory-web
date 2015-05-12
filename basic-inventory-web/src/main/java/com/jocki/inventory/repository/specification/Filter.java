package com.jocki.inventory.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

public abstract class Filter<T> {
    
    @SuppressWarnings("rawtypes")
    public Expression toPath(Root root, String name) {
        Path result = null;
        if (name.contains("_")) {
            for (String node: name.split("_")) {
                node = StringUtils.uncapitalize(node);                  
                if (result == null) {
                    result = root.get(node);
                } else {
                    result = result.get(node);
                }
            }
        } else {
            result = root.get(name);
        }
        return (Expression) result;
    }

    public abstract Predicate toPredicate(CriteriaBuilder cb, Root<T> root);
    
}
