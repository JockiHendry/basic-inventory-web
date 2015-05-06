package com.jocki.inventory.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity @Table(name="barang")
public class Produk extends DomainClass implements Comparable<Produk> {
	
	private static final long serialVersionUID = 5461257065411694467L;

	@NotBlank @Size(min=2, max=50)
    private String kode;

    @NotBlank @Size(min=2, max=100)
    private String nama;

    @NotNull @ManyToOne
    private JenisProduk jenis;

    @NotNull @Min(0l) @Column(name="hargaPatokan")
    private BigDecimal harga;
    
    @Column(name="total")
    private Integer qty; 
    
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

	public JenisProduk getJenis() {
		return jenis;
	}

	public void setJenis(JenisProduk jenis) {
		this.jenis = jenis;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public int compareTo(Produk produkLain) {
		return (produkLain == null)? -1: getNama().compareToIgnoreCase(produkLain.getNama());		
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
		Produk other = (Produk) obj;
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
