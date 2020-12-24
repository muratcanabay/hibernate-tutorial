package io.github.muratcanabay.dto;

import java.math.BigDecimal;

public class UrunDto {
    private Long id;
    private String adi;
    private BigDecimal fiyat;

    public UrunDto(Long id, String adi, BigDecimal fiyat) {
        this.id = id;
        this.adi = adi;
        this.fiyat = fiyat;
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

    @Override
    public String toString() {
        return "UrunDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
