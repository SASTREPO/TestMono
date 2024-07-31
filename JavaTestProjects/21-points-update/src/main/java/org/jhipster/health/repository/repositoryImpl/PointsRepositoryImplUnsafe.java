package org.jhipster.health.repository.repositoryImpl;

import org.jhipster.health.domain.Points;
import org.jhipster.health.repository.PointsRepositoryInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component("unsafe")
@Transactional
public class PointsRepositoryImplUnsafe implements PointsRepositoryInterface {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void updatePoints(Points points) {
        String sql = "UPDATE points SET notes = '" + points.getNotes() +"' WHERE id = " + points.getId();
        System.out.println(sql);
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }
}
