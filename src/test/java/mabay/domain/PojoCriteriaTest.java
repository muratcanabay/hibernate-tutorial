package mabay.domain;

import mabay.entityservice.UrunDaoCriteriaEntityService;
import org.junit.Test;

import java.util.List;

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
