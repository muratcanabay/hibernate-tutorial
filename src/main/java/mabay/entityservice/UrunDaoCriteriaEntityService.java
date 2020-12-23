package mabay.entityservice;

import mabay.criteria.UrunDaoCriteria;
import mabay.domain.Urun;

import java.util.List;

public class UrunDaoCriteriaEntityService {

    private UrunDaoCriteria urunDaoCriteria;

    public UrunDaoCriteriaEntityService() {
        urunDaoCriteria = new UrunDaoCriteria();
    }

    public List<Urun> findAllWithCriteria() {
        return urunDaoCriteria.findAllWithCriteria();
    }

    public Urun findByIdWithCriteria(Long id) {
        return urunDaoCriteria.findByIdWithCriteria(id);
    }

}
