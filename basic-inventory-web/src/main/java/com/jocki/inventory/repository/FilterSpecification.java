package com.jocki.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class FilterSpecification<T> implements Specification<T> {
	
	public enum Operation { EQ, LIKE, MIN };

	private List<Filter> filters = new ArrayList<>();
	
	public void and(String name, Operation op, Object...args) {
		filters.add(new Filter(name, op, args));
	}
	
	public void and(Filter filter) {
		filters.add(filter);
	}
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {				
		Predicate result = cb.conjunction();
		for (Filter filter: filters) {
			result = cb.and(result, filter.toPredicate(cb, root));			
		}
		return result;		
	}
	
	class Filter {
		
		private String name;
		private Operation op;
		private Object[] args;
		
		public Filter(String name, Operation op, Object... args) {
			this.name = name;
			this.op = op;
			this.args = args;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
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
				
	}		

}
