package recruitmenttask.snookermanagement.infrastructure;

import org.springframework.stereotype.Component;
import recruitmenttask.snookermanagement.api.ListAllPlayersResponse;
import recruitmenttask.snookermanagement.api.PlayerDTO;
import recruitmenttask.snookermanagement.api.PlayersCatalog;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.Player_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Bartosz on 2017-01-20.
 */
@Component
public class JPAPlayersCatalog implements PlayersCatalog{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListAllPlayersResponse listAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PlayerDTO> query = builder.createQuery(PlayerDTO.class);
        Root<Player> root = query.from(Player.class);
        query.getOrderList();
        selectPlayerDTO(builder, query, root);
        Query jpaQuery = entityManager.createQuery(query);
        return new ListAllPlayersResponse(jpaQuery.getResultList());
    }

    private void selectPlayerDTO(CriteriaBuilder builder, CriteriaQuery<PlayerDTO> query, Root<Player> root) {
        query.select(builder.construct(PlayerDTO.class,
                root.get(Player_.id),
                root.get(Player_.firstName),
                root.get(Player_.lastName),
                root.get(Player_.country)));
    }
}
