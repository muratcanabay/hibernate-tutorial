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
package mabay.entityservice;

import mabay.dao.UrunDao;
import mabay.domain.Urun;
import org.hibernate.criterion.MatchMode;

import java.math.BigDecimal;
import java.util.List;

/**
 * UrunEntityService
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
public class UrunEntityService {
    private UrunDao urunDao;

    public UrunEntityService() {
        urunDao = new UrunDao();
    }

    public List<Urun> findAll() {
        return urunDao.findAll();
    }

    public void save(Urun urun) {
        urunDao.save(urun);
    }

    public Urun findUrunTuruById(Long id) {
        return urunDao.findUrunById(id);
    }

    public List<Urun> findUrunByFiyatBetween(BigDecimal min, BigDecimal max) {
        return urunDao.findUrunByFiyatBetween(min, max);
    }

    public List<Urun> findUrunByFiyatBetween2(BigDecimal min, BigDecimal max) {
        return urunDao.findUrunByFiyatBetween2(min, max);
    }

    public List<Urun> findUrunByUrunAdiStartingWith(String urunAdi) {
        return urunDao.findUrunByUrunAdiStartingWith(urunAdi);
    }

    public List<Urun> findUrunByUrunAdiLike(String urunAdi, MatchMode matchMode) {
        return urunDao.findUrunByUrunAdiLike(urunAdi, matchMode);
    }
}
