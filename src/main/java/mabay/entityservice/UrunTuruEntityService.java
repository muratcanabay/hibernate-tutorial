package mabay.entityservice;

import mabay.dao.UrunTuruDao;
import mabay.domain.UrunTuru;

import java.util.List;

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
