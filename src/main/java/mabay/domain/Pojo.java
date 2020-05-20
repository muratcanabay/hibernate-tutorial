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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Pojo
 *
 * @author Murat Can Abay
 * @since 0.21.0
 */

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
