package org.jhipster.health.repository.repositoryImpl;

import org.jhipster.health.domain.Points;
import org.jhipster.health.repository.PointsRepository;
import org.jhipster.health.repository.PointsRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("safe")
@Transactional
public class PointsRepositoryImplSafe implements PointsRepositoryInterface {

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public void updatePoints(Points points) {
        pointsRepository.save(points);
    }
}
