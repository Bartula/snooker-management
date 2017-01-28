package recruitmenttask.snookermanagement.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.domain.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Service
public class TournamentPanel {

    private TournamentRepository tournamentRepository;
    private PlayerRepository playerRepository;

    public TournamentPanel(TournamentRepository tournamentRepository, PlayerRepository playerRepository) {
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    public void createTournament(CreateTournamentRequest request) {
        request.validate();
        Tournament tournament = tournamentRepository.load(request.getTournamentYear(), request.getTournamentName());
        if (tournament == null) {
            tournament = new Tournament(request.getTournamentYear(), request.getTournamentName());
            tournamentRepository.save(tournament);
        } else
            throw new InvalidRequestException("Tournament already exist");
    }

    @Transactional
    public void addPlayerToTournament(Long tournamentId, Long playerId) {
        if (tournamentId == null || playerId == null)
            throw new InvalidRequestException("Tournament Id or player Id can not be null");
        Tournament tournament = tournamentRepository.findById(tournamentId);
        checkNullTournament(tournament);
        Player player = getPlayerFromDB(playerId);
        Set<Player> players = tournament.getPlayers();
        if (players == null){
            players = new HashSet<>();
            players.add(player);
            tournament.setPlayers(players);
        }else {
            players.add(player);
        }
    }

    @Transactional
    public void createNewGame(Long tournamentId, CreateGameRequest request) {
        Tournament tournament = tournamentRepository.findById(tournamentId);
        checkNullTournament(tournament);
        Player playerA = getPlayerFromDB(request.getGamePlayerAId());
        checkIfPlayerIsInTournamentPlayersSet(tournament,playerA);
        Player playerB = getPlayerFromDB(request.getGamePlayerBId());
        checkIfPlayerIsInTournamentPlayersSet(tournament,playerB);
        Game game = new Game(tournament,playerA.getId(),playerB.getId());
        Set<Game> games = tournament.getGames();
        if (games == null){
            games = new HashSet<>();
            games.add(game);
            tournament.setGames(games);
        }else {
            games.add(game);
        }
    }

    private Player getPlayerFromDB(Long playerId) {
        Player player = playerRepository.findById(playerId);
        if (player == null)
            throw new InvalidRequestException("Wrong player id.");
        return player;
    }

    private void checkNullTournament(Tournament tournament) {
        if (tournament == null)
            throw new InvalidRequestException("Wrong tournament id.");
    }

    private void checkIfPlayerIsInTournamentPlayersSet(Tournament tournament, Player player){
        Set<Player> players = tournament.getPlayers();
        if (players == null)
            throw new InvalidRequestException("Tournament does not have any players");
        if(!players.contains(player))
            throw new InvalidRequestException("Player does not belong to the tournament");
    }


}
