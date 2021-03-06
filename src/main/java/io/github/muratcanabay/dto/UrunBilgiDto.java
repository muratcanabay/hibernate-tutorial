package io.github.muratcanabay.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UrunBilgiDto {
    private Long id;
    private String adi;
    private BigDecimal fiyat;
    private Date sonKullanmaTarihi;
    private Long stokMiktari;
    private String urunTuruAdi;

    public UrunBilgiDto(Long id, String adi, BigDecimal fiyat, Date sonKullanmaTarihi, Long stokMiktari, String urunTuruAdi) {
        this.id = id;
        this.adi = adi;
        this.fiyat = fiyat;
        this.sonKullanmaTarihi = sonKullanmaTarihi;
        this.stokMiktari = stokMiktari;
        this.urunTuruAdi = urunTuruAdi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public BigDecimal getFiyat() {
        return fiyat;
    }

    public void setFiyat(BigDecimal fiyat) {
        this.fiyat = fiyat;
    }

    public Date getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(Date sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public Long getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Long stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public String getUrunTuruAdi() {
        return urunTuruAdi;
    }

    public void setUrunTuruAdi(String urunTuruAdi) {
        this.urunTuruAdi = urunTuruAdi;
    }
}
