package io.github.muratcanabay.entityservice;

import io.github.muratcanabay.dao.UrunDao;
import io.github.muratcanabay.domain.Urun;
import io.github.muratcanabay.dto.UrunBilgiDto;
import io.github.muratcanabay.dto.UrunDto;
import org.hibernate.criterion.MatchMode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

    public List<Urun> findAllOrderByFiyatAsc() {
        return urunDao.findAllOrderByFiyatAsc();
    }

    public List<Urun> findAllOrderByFiyatDesc() {
        return urunDao.findAllOrderByFiyatDesc();
    }

    public List<Urun> findAllUrunWithLimit(int limit) {
        return urunDao.findAllUrunWithLimit(limit);
    }

    public List<Urun> findUrunBySonKullanmaTarihiGreaterThanEqual(Date sonKullanmaTarihi) {
        return urunDao.findUrunBySonKullanmaTarihiGreaterThanEqual(sonKullanmaTarihi);
    }

    public Long sumStokMiktariByUrunTuruId(Long id) {
        return urunDao.sumStokMiktariByUrunTuruId(id);
    }

    public List<UrunDto> findAllUrunDto() {
        return urunDao.findAllUrunDto();
    }

    public List<UrunBilgiDto> findAllUrunBilgiDto() {
        return urunDao.findAllUrunBilgiDto();
    }
}
