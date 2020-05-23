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
package mabay.criteria;

import mabay.domain.Urun;
import mabay.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * UrunDaoCriteria
 *
 * @author Murat Can Abay
 * @since 0.23.0
 */
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
}
