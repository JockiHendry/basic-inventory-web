package com.jocki.inventory.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Sales extends DomainClass implements Comparable<Sales> {
	
	private static final long serialVersionUID = 8431994563295003999L;

	@NotBlank @Size(min=2, max=100)
    private String nama;

    @Size(min=2, max=200)
	private String alamat;

    @Size(min=3, max=100)
	private String nomorTelepon;       
    
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

	public String getNomorTelepon() {
		return nomorTelepon;
	}

	public void setNomorTelepon(String nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}

	@Override
    public String toString() {
        return nama;
    }

	@Override
	public int compareTo(Sales salesLain) {
		if (salesLain == null) return -1;
		if (!(salesLain instanceof Sales)) return -1;
		return nama.compareToIgnoreCase(salesLain.nama);			
	}

}
