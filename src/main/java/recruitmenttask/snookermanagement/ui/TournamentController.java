package recruitmenttask.snookermanagement.ui;

import org.springframework.web.bind.annotation.*;
import recruitmenttask.snookermanagement.api.CreateGameRequest;
import recruitmenttask.snookermanagement.api.CreateTournamentRequest;
import recruitmenttask.snookermanagement.api.TournamentPanel;

/**
 * Created by Bartosz on 2017-01-23.
 */

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    private TournamentPanel tournamentPanel;

    public TournamentController(TournamentPanel tournamentPanel) {
        this.tournamentPanel = tournamentPanel;
    }

    @PutMapping
    public void createTournament(@RequestBody CreateTournamentRequest request){
        tournamentPanel.createTournament(request);
    }

    @PutMapping("/{tournamentId}/{playerId}")
    public void addPlayerTotournament(@PathVariable Long tournamentId, @PathVariable Long playerId){
        tournamentPanel.addPlayerToTournament(tournamentId,playerId);
    }

    @PutMapping("/{tournamentId}/game")
    public void createGame(@PathVariable Long tournamentId, @RequestBody CreateGameRequest request){
        tournamentPanel.createNewGame(tournamentId, request);
    }

}
