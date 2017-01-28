package recruitmenttask.snookermanagement.infrastructure;

import org.springframework.stereotype.Repository;
import recruitmenttask.snookermanagement.domain.Game;
import recruitmenttask.snookermanagement.domain.GameRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by Bartosz on 2017-01-28.
 */
@Repository
public class JPAGameRepository implements GameRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Game findById(Long id) {
        List<Game> games = entityManager.createQuery("FROM Game g WHERE g.id =:id", Game.class)
                .setParameter("id",id).getResultList();
        return Utils.returnSingleResult(games);
    }
}
