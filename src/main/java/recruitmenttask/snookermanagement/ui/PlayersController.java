package recruitmenttask.snookermanagement.ui;

import org.springframework.web.bind.annotation.*;
import recruitmenttask.snookermanagement.api.AdminPanel;
import recruitmenttask.snookermanagement.api.CreatePlayerRequest;
import recruitmenttask.snookermanagement.api.ListAllPlayersResponse;
import recruitmenttask.snookermanagement.api.PlayersCatalog;


@RestController
@RequestMapping("/player")
public class PlayersController {

    private AdminPanel adminPanel;
    private PlayersCatalog playersCatalog;

    public PlayersController(AdminPanel adminPanel, PlayersCatalog playersCatalog) {
        this.adminPanel = adminPanel;
        this.playersCatalog = playersCatalog;
    }

    @PutMapping
    public void createNewPlayer(@RequestBody CreatePlayerRequest request){
        adminPanel.createNewPlayer(request);
    }

    @GetMapping
    public ListAllPlayersResponse listAll(){
        return playersCatalog.listAll();
    }

    @DeleteMapping("/{playerId}")
    public void removePlayer(@PathVariable Long playerId){
        adminPanel.removePlayer(playerId);
    }
}
