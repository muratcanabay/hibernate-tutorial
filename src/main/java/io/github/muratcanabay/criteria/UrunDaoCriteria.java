package io.github.muratcanabay.criteria;

import io.github.muratcanabay.domain.Urun;
import io.github.muratcanabay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UrunDaoCriteria {

    private SessionFactory sessionFactory;

    public UrunDaoCriteria() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Urun> findAllWithCriteria() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    public Urun findByIdWithCriteria(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Urun> query = criteriaBuilder.createQuery(Urun.class);
        Root<Urun> root = query.from(Urun.class);
        query.select(root).where(
                criteriaBuilder.equal(root.get("id"), id)
        );
        return session.createQuery(query).uniqueResult();
    }
}
