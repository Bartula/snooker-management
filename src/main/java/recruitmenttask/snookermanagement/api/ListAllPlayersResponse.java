package recruitmenttask.snookermanagement.api;

import java.util.List;

/**
 * Created by Bartosz on 2017-01-20.
 */
public class ListAllPlayersResponse {

    private List<PlayerDTO> players;

    public ListAllPlayersResponse(List<PlayerDTO> players) {
        this.players = players;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
