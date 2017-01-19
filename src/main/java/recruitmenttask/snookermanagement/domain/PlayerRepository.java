package recruitmenttask.snookermanagement.domain;


/**
 * Created by Bartosz on 2017-01-17.
 */
public interface PlayerRepository {
    Player load(String playerFirstName, String playerLastName, String playerCountry);

    void save(Player player);
}
