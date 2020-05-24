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

import mabay.entityservice.UrunDaoCriteriaEntityService;
import org.junit.Test;

import java.util.List;

/**
 * PojoCriteriaTest
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
public class PojoCriteriaTest {

    private UrunDaoCriteriaEntityService urunDaoCriteriaEntityService = new UrunDaoCriteriaEntityService();

    @Test
    public void findAllWithCriteria() {
        List<Urun> urunList = urunDaoCriteriaEntityService.findAllWithCriteria();
    }

    @Test
    public void findByIdWithCriteria() {
        Urun urun = urunDaoCriteriaEntityService.findByIdWithCriteria(1L);
    }
}
