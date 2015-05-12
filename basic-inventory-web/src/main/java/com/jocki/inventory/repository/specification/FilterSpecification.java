package com.jocki.inventory.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.ReadablePartial;
import org.springframework.data.jpa.domain.Specification;

public class FilterSpecification<T> implements Specification<T> {
	
	public enum Operation { EQ, LIKE, MIN };

	private List<Filter<T>> filters = new ArrayList<>();
	
	public void and(String name, Operation op, Object...args) {
		filters.add(new BasicFilter<T>(name, op, args));
	}
	
	public void and(String name, ReadablePartial tanggalMulai, ReadablePartial tanggalSelesai) {
	    filters.add(new PeriodeFilter<T>(name, tanggalMulai, tanggalSelesai));
	}
	
	public void and(Filter<T> filter) {
		filters.add(filter);
	}
	
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {				
		Predicate result = cb.conjunction();
		for (Filter<T> filter: filters) {
			result = cb.and(result, filter.toPredicate(cb, root));			
		}
		return result;		
	}	

}
