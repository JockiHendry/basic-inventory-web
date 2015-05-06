package com.jocki.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="jenis")
public class JenisProduk extends DomainClass implements Comparable<JenisProduk> {
	
	private static final long serialVersionUID = 4700550907892081419L;

	@NotBlank @Size(min=2, max=50)
    private String kode;

    @NotBlank @Size(min=3, max=100)
    private String nama;       

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
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

	@Override
	public int compareTo(JenisProduk jenisProdukLain) {
        return (jenisProdukLain == null)? -1: getNama().compareToIgnoreCase(jenisProdukLain.getNama());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kode == null) ? 0 : kode.hashCode());
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
		JenisProduk other = (JenisProduk) obj;
		if (kode == null) {
			if (other.kode != null)
				return false;
		} else if (!kode.equals(other.kode))
			return false;
		if (nama == null) {
			if (other.nama != null)
				return false;
		} else if (!nama.equals(other.nama))
			return false;
		return true;
	}    	
	
}
