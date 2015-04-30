package com.jocki.inventory.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.jocki.inventory.domain.DomainClass;

public abstract class PageableLazyDataModel<T extends DomainClass> extends LazyDataModel<T> {

	private static final long serialVersionUID = 8987659076518106667L;
	
	private Map<String, Object> filters;
	
	private List<T> data;
	
	private T selected;
	
	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		Sort sort = null;
		if ((sortField != null) && (sortOrder != null)) {
			sort = new Sort((sortOrder == SortOrder.DESCENDING)? Direction.DESC: Direction.ASC, sortField);
		}		
		PageRequest pageRequest = new PageRequest(first / pageSize, pageSize, sort);
		this.filters = filters;	
		Page<T> result = load(pageRequest);
		this.data = result.getContent();
		setRowCount((int) result.getTotalElements());
		return result.getContent();		
	}
	
	public Object getFilter(String filterName) {
		return (filters == null)? null: filters.get(filterName);
	}
	
	public String getFilterAsSearchExpr(String filterName) {
		if ((filters != null) && (filters.containsKey(filterName))) {
			return "%" + filters.get(filterName) + "%";
		}
		return "";
	}
	
	@Override
	public T getRowData(String rowKey) {
		Long id = Long.valueOf(rowKey);
		for (T entity: data) {
			if (entity.getId().equals(id)) {
				return entity;
			}
		}
		return null;
	}
	
	@Override
	public Object getRowKey(T entity) {
		return entity.getId();
	}
			
	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public abstract Page<T> load(Pageable pageable);

}
