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
package mabay.dao;

import mabay.domain.Urun;
import mabay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * UrunDao
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
public class UrunDao {
    private SessionFactory sessionFactory;

    public UrunDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Urunleri kaydeder.
     *
     * @param urun
     */
    public void save(Urun urun) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(urun);
        transaction.commit();
        sessionFactory.close();
    }

    /**
     * Urunlerin hepsini getirir.
     *
     * @return
     */
    public List<Urun> findAll() {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("Select urun from Urun urun");
        return hql.list();
    }

    /**
     * Urunleri id'ye göre getirir.
     *
     * @param id
     * @return
     */
    public Urun findUrunById(Long id) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("Select urun from Urun urun where id=:id")
                .setParameter("id", id);
        return (Urun) hql.uniqueResult();
    }

    /**
     * Minimum ve maximum fiyata göre urun listesi döner.
     *
     * @param minFiyat
     * @param maxFiyat
     * @return
     */
    public List<Urun> findUrunByFiyatBetween(BigDecimal minFiyat, BigDecimal maxFiyat) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("Select urun from Urun urun where " +
                "urun.fiyat>=:minFiyat and urun.fiyat<=:maxFiyat")
                .setParameter("minFiyat", minFiyat)
                .setParameter("maxFiyat", maxFiyat);
        return hql.list();
    }

    /**
     * Minimum ve maximum fiyata göre urun listesi döner.
     *
     * @param minFiyat
     * @param maxFiyat
     * @return
     */
    public List<Urun> findUrunByFiyatBetween2(BigDecimal minFiyat, BigDecimal maxFiyat) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("Select urun from Urun urun " +
                "where urun.fiyat between :minFiyat and :maxFiyat")
                .setParameter("minFiyat", minFiyat)
                .setParameter("maxFiyat", maxFiyat);
        return hql.list();
    }

    /**
     * Verilen string ile başlayan ürünleri listeler.
     *
     * @param urunAdi
     * @return
     */
    public List<Urun> findUrunByUrunAdiStartingWith(String urunAdi) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("Select urun from Urun urun " +
                "where urun.adi like concat(:urunAdi, '%')")
                .setParameter("urunAdi", urunAdi);
        return hql.list();
    }

    /**
     * Verilen urunAdi ve matchMode'a göre ürünleri listeler.
     * @param urunAdi
     * @param matchMode
     * @return
     */

    public List<Urun> findUrunByUrunAdiLike(String urunAdi, MatchMode matchMode) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("select urun from Urun urun" +
                " where urun.adi like :urunAdi");

        switch (matchMode) {
            case START:
                hql.setParameter("urunAdi", urunAdi + '%');
                break;

            case ANYWHERE:
                hql.setParameter("urunAdi", '%' + urunAdi + '%');
                break;

            case END:
                hql.setParameter("urunAdi", '%' + urunAdi);
                break;

            case EXACT:
                hql.setParameter("urunAdi", urunAdi);
        }

        return hql.list();
    }
}
