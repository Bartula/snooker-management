package recruitmenttask.snookermanagement.infrastructure;

import org.springframework.stereotype.Repository;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.PlayerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class JPAPlayerRepository implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Player load(String firstName, String lastName, String country) {
        List<Player> players = entityManager.createQuery("FROM Player p WHERE p.firstName =:firstName " +
                "AND p.lastName =:lastName AND p.country =:country", Player.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("country", country).getResultList();
        return Utils.returnSingleResult(players);
    }

    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Override
    public void removePlayer(Player player) {
        entityManager.remove(player);
    }

    @Override
    public Player findById(Long playerId) {
        List<Player> players = entityManager.createQuery("FROM Player p WHERE p.id =:id", Player.class)
                .setParameter("id",playerId).getResultList();
        return Utils.returnSingleResult(players);
    }

}
