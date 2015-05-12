package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.ItemStok;
import com.jocki.inventory.domain.Produk;
import com.jocki.inventory.repository.ItemStokRepository;
import com.jocki.inventory.repository.specification.FilterSpecification;
import com.jocki.inventory.repository.specification.FilterSpecification.Operation;

public class ItemStokLazyDataModel extends PageableLazyDataModel<ItemStok> {
    
    private static final long serialVersionUID = 3535503467894612179L;

    @Inject
    private transient ItemStokRepository itemStokRepository;
        
    private LocalDate tanggalMulai = LocalDate.now().minusMonths(1);
        
    private LocalDate tanggalSelesai = LocalDate.now();
        
    private Produk currentProduk;
                   
    public Produk getCurrentProduk() {
        return currentProduk;
    }

    public void setCurrentProduk(Produk currentProduk) {
        this.currentProduk = currentProduk;
    }

    @Override
    public Page<ItemStok> load(Pageable pageable) {
        FilterSpecification<ItemStok> filterSpecification = new FilterSpecification<>();
        if (currentProduk != null) {
            filterSpecification.and("produk", Operation.EQ, currentProduk);
        }
        filterSpecification.and("tanggalInput", tanggalMulai.toLocalDateTime(LocalTime.MIDNIGHT), tanggalSelesai.toLocalDateTime(LocalTime.MIDNIGHT));        
        if (getFilter("qty") != null) {
            filterSpecification.and("qty", Operation.MIN, (String) getFilter("qty")); 
        }
        if (getFilter("hapus") != null) {
            filterSpecification.and("hapus", Operation.EQ, getFilter("hapus"));
        }
        if (getFilter("keterangan") != null) {
            filterSpecification.and("keterangan", Operation.LIKE, getFilterAsSearchExpr("keterangan"));
        }        
        return itemStokRepository.findAll(filterSpecification, pageable);        
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }        

}
