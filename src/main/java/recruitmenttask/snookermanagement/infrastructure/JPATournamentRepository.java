package recruitmenttask.snookermanagement.infrastructure;

import org.springframework.stereotype.Repository;
import recruitmenttask.snookermanagement.domain.Tournament;
import recruitmenttask.snookermanagement.domain.TournamentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Bartosz on 2017-01-24.
 */
@Repository
public class JPATournamentRepository implements TournamentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tournament load(String year, String name) {
        List<Tournament> tournaments = entityManager.createQuery("FROM Tournament t WHERE t.year =:year AND t.name =:name", Tournament.class)
                .setParameter("year",year)
                .setParameter("name", name).getResultList();
        return Utils.returnSingleResult(tournaments);
    }

    @Override
    public void save(Tournament tournament) {
        entityManager.persist(tournament);
    }

    @Override
    public Tournament findById(Long tournamentId) {
        List<Tournament> tournaments = entityManager.createQuery("FROM Tournament t WHERE t.id =:id", Tournament.class).setParameter("id",tournamentId).getResultList();
        return Utils.returnSingleResult(tournaments);
    }
}
