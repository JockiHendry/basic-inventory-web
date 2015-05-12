package com.jocki.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
public class ItemStok extends DomainClass {
    
    private static final long serialVersionUID = 2549732248280770720L;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime tanggalInput;

    @NotNull @Column(name="jumlah")
    private Integer qty;

    @NotNull @ManyToOne @JoinColumn(name="barang_id")
    private Produk produk;

    @NotNull
    private Boolean hapus = Boolean.FALSE;
    
    @Size(min=3, max=200)
    private String keterangan;

    public LocalDateTime getTanggalInput() {
        return tanggalInput;
    }

    public void setTanggalInput(LocalDateTime tanggalInput) {
        this.tanggalInput = tanggalInput;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Boolean getHapus() {
        return hapus;
    }

    public void setHapus(Boolean hapus) {
        this.hapus = hapus;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }        
    
}
