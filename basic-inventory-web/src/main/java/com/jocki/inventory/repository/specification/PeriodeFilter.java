package com.jocki.inventory.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.joda.time.ReadablePartial;

public class PeriodeFilter<T> extends Filter<T> {
    
    private String name;
    private ReadablePartial tanggalMulai, tanggalSelesai;
    
    public PeriodeFilter(String name, ReadablePartial tanggalMulai, ReadablePartial tanggalSelesai) {
        this.name = name;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
    }

    @Override @SuppressWarnings({ "unchecked" })
    public Predicate toPredicate(CriteriaBuilder cb, Root<T> root) {        
        return cb.between(toPath(root, name), tanggalMulai, tanggalSelesai);        
    }

}
