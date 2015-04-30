package com.jocki.inventory.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Kota extends DomainClass implements Comparable<Kota> {

	private static final long serialVersionUID = -374840617807885699L;
	
	@NotBlank @Size(min=2, max=100)
    private String nama;   
	
	public Kota() {}
	
	public Kota(String nama) {
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
        return getNama();
    }

	@Override
	public int compareTo(Kota kotaLain) {
		if (kotaLain == null) return -1;
        if (!(kotaLain instanceof Kota)) return -1;
        return getNama().compareToIgnoreCase(kotaLain.getNama());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nama == null) ? 0 : nama.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kota other = (Kota) obj;
		if (nama == null) {
			if (other.nama != null)
				return false;
		} else if (!nama.equals(other.nama))
			return false;
		return true;
	}	

}

