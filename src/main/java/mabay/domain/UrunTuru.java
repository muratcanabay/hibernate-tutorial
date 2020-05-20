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

import mabay.enums.EnumUrunTuru;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * UrunTuru
 *
 * @author Murat Can Abay
 * @since 0.22.0
 */
@Entity
@Table(name = "URUN_TURU")
public class UrunTuru {

    @GeneratedValue(generator = "urun", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(name = "urun", sequenceName = "URUN_TURU_ID_SEQ")
    private Long id;

    @Column(name = "ADI")
    private String adi;

    @Column(name = "ENUM_URUN_TURU")
    @Enumerated(EnumType.STRING)
    private EnumUrunTuru enumUrunTuru;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "urunTuru", targetEntity = Urun.class)
    private Set urun = new HashSet();

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

    public EnumUrunTuru getEnumUrunTuru() {
        return enumUrunTuru;
    }

    public void setEnumUrunTuru(EnumUrunTuru enumUrunTuru) {
        this.enumUrunTuru = enumUrunTuru;
    }

    public Set getUrun() {
        return urun;
    }

    public void setUrun(Set urun) {
        this.urun = urun;
    }
}
