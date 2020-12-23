package mabay.domain;

import mabay.enums.EnumUrunTuru;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
