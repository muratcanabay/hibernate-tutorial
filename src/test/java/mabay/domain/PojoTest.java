package mabay.domain;

import mabay.dto.UrunBilgiDto;
import mabay.dto.UrunDto;
import mabay.entityservice.UrunEntityService;
import mabay.entityservice.UrunTuruEntityService;
import mabay.enums.EnumUrunBirim;
import mabay.enums.EnumUrunTuru;
import org.hibernate.criterion.MatchMode;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void saveUrun() {
        Urun urun = new Urun();
        urun.setAdi("Süt");
        urun.setFiyat(BigDecimal.valueOf(5));
        urun.setEnumUrunBirim(EnumUrunBirim.LITRE);
        urun.setSonKullanmaTarihi(new Date());

        urunEntityService.save(urun);
    }

    @Test
    public void saveUrunTuru() {
        UrunTuru urunTuru = new UrunTuru();
        urunTuru.setAdi("Bakkal ürünü");
        urunTuru.setEnumUrunTuru(EnumUrunTuru.YIYECEK);

        urunTuruEntityService.save(urunTuru);
    }

    @Test
    public void findAllUrun() {
        List<Urun> urunList = urunEntityService.findAll();
        assertThat(urunList.isEmpty(), is(false));
    }

    @Test
    public void findAllUrunTuru() {
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

    @Test
    public void findAllOrderByFiyatAsc() {
        List<Urun> urunList = urunEntityService.findAllOrderByFiyatAsc();
    }

    @Test
    public void findAllOrderByFiyatDesc() {
        List<Urun> urunList = urunEntityService.findAllOrderByFiyatDesc();
    }

    @Test
    public void findAllUrunWithLimit() {
        List<Urun> urunList = urunEntityService.findAllUrunWithLimit(1);
    }

    @Test
    /**
     * @see: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
     */
    public void findUrunBySonKullanmaTarihiGreaterThanEqual() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sonKullanmaTarihi = null;

        try {
            sonKullanmaTarihi = simpleDateFormat.parse("2020-05-21");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Urun> urunList = urunEntityService
                .findUrunBySonKullanmaTarihiGreaterThanEqual(sonKullanmaTarihi);
    }

    @Test
    public void sumStokMiktariByUrunTuruId() {
        Long stokMiktari = urunEntityService.sumStokMiktariByUrunTuruId(Long.valueOf(52));
    }

    @Test
    public void findAllUrunDto() {
        List<UrunDto> urunDtoList = urunEntityService.findAllUrunDto();
    }

    @Test
    public void findAllUrunBilgiDto() {
        List<UrunBilgiDto> urunBilgiDtoList = urunEntityService.findAllUrunBilgiDto();
    }
}
