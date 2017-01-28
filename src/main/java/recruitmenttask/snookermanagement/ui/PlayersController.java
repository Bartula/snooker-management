package recruitmenttask.snookermanagement.ui;

import org.springframework.web.bind.annotation.*;
import recruitmenttask.snookermanagement.api.PlayerPanel;
import recruitmenttask.snookermanagement.api.CreatePlayerRequest;
import recruitmenttask.snookermanagement.api.ListAllPlayersResponse;
import recruitmenttask.snookermanagement.api.PlayersCatalog;


@RestController
@RequestMapping("/player")
public class PlayersController {

    private PlayerPanel playerPanel;
    private PlayersCatalog playersCatalog;

    public PlayersController(PlayerPanel playerPanel, PlayersCatalog playersCatalog) {
        this.playerPanel = playerPanel;
        this.playersCatalog = playersCatalog;
    }

    @PutMapping
    public void createNewPlayer(@RequestBody CreatePlayerRequest request){
        playerPanel.createNewPlayer(request);
    }

    @GetMapping
    public ListAllPlayersResponse listAll(){
        return playersCatalog.listAll();
    }

    @DeleteMapping("/{playerId}")
    public void removePlayer(@PathVariable Long playerId){
        playerPanel.removePlayer(playerId);
    }
}
