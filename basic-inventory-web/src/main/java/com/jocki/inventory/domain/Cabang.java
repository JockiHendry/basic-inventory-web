package com.jocki.inventory.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Cabang extends DomainClass {

	private static final long serialVersionUID = 8608269189802760304L;
	
	@NotBlank @Size(min=2, max=100)
    private String nama;     
    
    public Cabang() {}
    
    public Cabang(String nama) {		
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}	

	@Override
    public String toString() {
        return nama;
    }
	
}

