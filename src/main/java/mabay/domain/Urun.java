/*
 * Copyright 2020 Universal Bilgi Teknolojileri.
 *
 * UKL 1.1 lisansı ile lisanslanmıştır. Bu dosyanın lisans koşullarına uygun
 * olmayan şekilde kullanımı yasaklanmıştır. Lisansın bir kopyasını aşağıdaki
 * linkten edinebilirsiniz.
 *
 * http://www.uni-yaz.com/lisans/ukl_1_1.pdf
 *
 * Yasalar aksini söylemediği veya yazılı bir sözleşme ile aksi belirtilmediği sürece,
 * bu yazılım mevcut hali ile hiç bir garanti vermeden veya herhangi bir şart ileri
 * sürmeden dağıtılır. Bu yazılımın edinim izinleri ve limitler konusunda lisans
 * sözleşmesine bakınız.
 *
 */
package mabay.domain;

import mabay.enums.EnumUrunBirim;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Urun
 *
 * @author Murat Can Abay
 * @since 0.22.0
 */
@Entity
@Table(name = "URUN")
public class Urun {

    @Id
    @GeneratedValue(generator = "urun", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "urun", sequenceName = "URUN_ID_SEQ")
    private Long id;

    @Column(name = "ADI")
    private String adi;

    @Column(name = "FIYAT", precision = 6, scale = 2)
    private BigDecimal fiyat;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENUM_URUN_BIRIM")
    private EnumUrunBirim enumUrunBirim;

    @Column(name = "SON_KULLANMA_TARIHI")
    @Temporal(TemporalType.DATE)
    private Date sonKullanmaTarihi;

    @Column(name = "STOK_MIKTARI")
    private Long stokMiktari;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_URUN_TURU", foreignKey = @ForeignKey(name = "FK_URUN_URUN_TURU"))
    private UrunTuru urunTuru;

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

    public EnumUrunBirim getEnumUrunBirim() {
        return enumUrunBirim;
    }

    public void setEnumUrunBirim(EnumUrunBirim enumUrunBirim) {
        this.enumUrunBirim = enumUrunBirim;
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

    public UrunTuru getUrunTuru() {
        return urunTuru;
    }

    public void setUrunTuru(UrunTuru urunTuru) {
        this.urunTuru = urunTuru;
    }
}
