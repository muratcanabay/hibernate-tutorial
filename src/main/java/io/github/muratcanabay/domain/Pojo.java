package io.github.muratcanabay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "POJO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pojo {

    @SequenceGenerator(name = "sequence", sequenceName = "POJO_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    /**
     * insertable = false adi alanı setlense de veritabanına yazılmasını engeller.
     */
    @Column(name = "adi", length = 100, nullable = false)
    private String adi;

    @Column(name = "randomDeger", precision = 15, scale = 2)
    private BigDecimal randomDeger;

    @Temporal(TemporalType.DATE)
    private Date tarih;

    @Temporal(TemporalType.TIME)
    private Date saat;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tarihSaat;

    /**
     * Tabloda olmasını istemediğimiz alana transient anotasyonu yazıyoruz.
     */
    @Transient
    private String temporalField;

    /**
     * Database büyük veri olarak kaydetmek istiyorsak yazıyoruz.
     */
    @Lob
    private String buyukVeriStr;

    @Lob
    private byte[] buyukVeriByte;

    @Lob
    private char[] buyuVeriChar;
}
