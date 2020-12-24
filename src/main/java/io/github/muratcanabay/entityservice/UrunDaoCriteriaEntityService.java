package io.github.muratcanabay.entityservice;

import io.github.muratcanabay.criteria.UrunDaoCriteria;
import io.github.muratcanabay.domain.Urun;

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
