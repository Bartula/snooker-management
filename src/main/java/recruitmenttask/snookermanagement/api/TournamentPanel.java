package recruitmenttask.snookermanagement.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.PlayerRepository;
import recruitmenttask.snookermanagement.domain.Tournament;
import recruitmenttask.snookermanagement.domain.TournamentRepository;

import java.util.HashSet;
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
        if (tournament == null)
            throw new InvalidRequestException("Wrong tournament id.");
        Player player = playerRepository.findById(playerId);
        if (player == null)
            throw new InvalidRequestException("Wrong player id.");
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

    }
}
