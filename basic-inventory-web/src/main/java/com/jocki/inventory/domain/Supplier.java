package com.jocki.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Supplier extends DomainClass {

	private static final long serialVersionUID = 1266165282362066462L;

	@NotBlank @Size(min=2, max=100)
    private String nama;

    @Size(min=3, max=200)
    private String alamat;

    @NotNull @ManyToOne
    private Kota kota;
    
    public Supplier() {}    

    public Supplier(String nama, String alamat, Kota kota) {		
		this.nama = nama;
		this.alamat = alamat;
		this.kota = kota;
	}    

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Kota getKota() {
		return kota;
	}

	public void setKota(Kota kota) {
		this.kota = kota;
	}

	@Override
    public String toString() {
        return nama + " - " + kota.getNama();
    }
	
}

