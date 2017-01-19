package recruitmenttask.snookermanagement.infrastructure;

import org.springframework.stereotype.Repository;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.PlayerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JPAPlayerRepository implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Player load(String firstName, String lastName, String country) {
        return entityManager.createQuery("FROM Player p WHERE p.firstName =:firstName " +
                "AND p.lastName =:lastName AND p.country =:country", Player.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("country", country).getSingleResult();
    }

    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }
}
