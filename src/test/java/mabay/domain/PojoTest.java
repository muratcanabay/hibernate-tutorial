package mabay.domain;

import mabay.entityservice.UrunEntityService;
import mabay.entityservice.UrunTuruEntityService;
import mabay.enums.EnumUrunBirim;
import mabay.enums.EnumUrunTuru;
import org.hibernate.criterion.MatchMode;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PojoTest
 *
 * @author Murat Can Abay
 * @since 0.21.0
 */

public class PojoTest {

    private UrunEntityService urunEntityService = new UrunEntityService();
    private UrunTuruEntityService urunTuruEntityService = new UrunTuruEntityService();

    @Test
    public void saveUrunTest() {
        Urun urun = new Urun();
        urun.setAdi("Domates");
        urun.setFiyat(BigDecimal.valueOf(15));
        urun.setEnumUrunBirim(EnumUrunBirim.KILO);
        urun.setSonKullanmaTarihi(new Date());

        urunEntityService.save(urun);
    }

    @Test
    public void saveUrunTuruTest() {
        UrunTuru urunTuru = new UrunTuru();
        urunTuru.setAdi("Bakkal ürünü");
        urunTuru.setEnumUrunTuru(EnumUrunTuru.YIYECEK);

        urunTuruEntityService.save(urunTuru);
    }

    @Test
    public void findAllUrunTest() {
        List<Urun> urunList = urunEntityService.findAll();
        assertThat(urunList.isEmpty(), is(false));
    }

    @Test
    public void findAllUrunTuruTest() {
        List<UrunTuru> urunTuruList = urunTuruEntityService.findAll();
        assertThat(urunTuruList.isEmpty(), is(false));
    }

    @Test
    public void findUrunById() {
        Urun urun = urunEntityService.findUrunTuruById(1L);
    }

    @Test
    public void findUrunTuruById() {
        UrunTuru urunTuru = urunTuruEntityService.findUrunTuruById(52L);
    }

    @Test
    public void findUrunByfindUrunByFiyatBetween() {
        List<Urun> urunList = urunEntityService
                .findUrunByFiyatBetween(BigDecimal.valueOf(10), BigDecimal.valueOf(15));
    }

    @Test
    public void findUrunByfindUrunByFiyatBetween2() {
        List<Urun> urunList = urunEntityService
                .findUrunByFiyatBetween2(BigDecimal.valueOf(10), BigDecimal.valueOf(12));
    }

    @Test
    public void findUrunByUrunAdiStartingWith() {
        List<Urun> urunList = urunEntityService.findUrunByUrunAdiStartingWith("s");
    }

    @Test
    public void findUrunByUrunAdiExact() {
        List<Urun> urunList = urunEntityService
                .findUrunByUrunAdiLike("Patates", MatchMode.EXACT);
    }

    @Test
    public void findUrunByUrunAdiAnywhere() {
        List<Urun> urunList = urunEntityService
                .findUrunByUrunAdiLike("at", MatchMode.ANYWHERE);
    }

    @Test
    public void findUrunByUrunAdiStart() {
        List<Urun> urunList = urunEntityService
                .findUrunByUrunAdiLike("D", MatchMode.START);
    }

    @Test
    public void findUrunByUrunAdiEnd() {
        List<Urun> urunList = urunEntityService
                .findUrunByUrunAdiLike("s", MatchMode.END);
    }
}
