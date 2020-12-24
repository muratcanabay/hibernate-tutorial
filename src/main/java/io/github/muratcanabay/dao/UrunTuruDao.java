package io.github.muratcanabay.dao;

import io.github.muratcanabay.domain.UrunTuru;
import io.github.muratcanabay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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
