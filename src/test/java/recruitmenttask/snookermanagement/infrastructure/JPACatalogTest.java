package recruitmenttask.snookermanagement.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.api.ListAllPlayersResponse;
import recruitmenttask.snookermanagement.api.PlayersCatalog;

import static org.junit.Assert.assertTrue;

/**
 * Created by Bartosz on 2017-01-20.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/application.xml")
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
@Sql("/fixtures/players.sql")
public class JPACatalogTest {

    @Autowired
    private PlayersCatalog playersCatalog;

    @Sql("/fixtures/players.sql")
    @Test
    @Transactional
    public void shouldLoadPlayers(){
        ListAllPlayersResponse result = playersCatalog.listAll();

        assertTrue(result.getPlayers().size() == 3);

    }
}
