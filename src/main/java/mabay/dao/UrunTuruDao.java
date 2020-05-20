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

import mabay.domain.UrunTuru;
import mabay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * UrunTuruDao
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
public class UrunTuruDao {

    private SessionFactory sessionFactory;

    public UrunTuruDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * UrunTuru kaydeder.
     *
     * @param urunTuru
     */
    public void save(UrunTuru urunTuru) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(urunTuru);
        transaction.commit();
        sessionFactory.close();
    }

    /**
     * UrunTurlerinin hepsini getirir.
     *
     * @return
     */
    public List<UrunTuru> findAll() {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("select urunturu from UrunTuru urunturu");
        return hql.list();
    }

    /**
     * UrunTuru'nu id'ye göre getirir.
     *
     * @param id
     * @return
     */
    public UrunTuru findById(Long id) {
        Session session = sessionFactory.openSession();
        Query hql = session.createQuery("select urunTuru from UrunTuru urunTuru where id=:id")
                .setParameter("id", id);
        return (UrunTuru) hql.uniqueResult();
    }
}
