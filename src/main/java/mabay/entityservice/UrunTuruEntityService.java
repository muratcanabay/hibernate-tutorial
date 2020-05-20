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

import mabay.dao.UrunTuruDao;
import mabay.domain.UrunTuru;

import java.util.List;

/**
 * UrunTuruEntityService
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
public class UrunTuruEntityService {

    private UrunTuruDao urunTuruDao;

    public UrunTuruEntityService() {
        urunTuruDao = new UrunTuruDao();
    }

    public List<UrunTuru> findAll() {
        return urunTuruDao.findAll();
    }

    public void save(UrunTuru urunTuru) {
        urunTuruDao.save(urunTuru);
    }

    public UrunTuru findUrunTuruById(Long id) {
        return urunTuruDao.findById(id);
    }
}
