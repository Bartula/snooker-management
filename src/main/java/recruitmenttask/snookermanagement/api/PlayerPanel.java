package recruitmenttask.snookermanagement.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.PlayerRepository;


@Service
public class PlayerPanel {

    private PlayerRepository playerRepository;

    public PlayerPanel(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public void createNewPlayer(CreatePlayerRequest request) {
        request.validate();
        Player player = playerRepository.load(request.getPlayerFirstName(), request.getPlayerLastName(), request.getPlayerCountry());
        if (player == null) {
            player = new Player(request.getPlayerFirstName(), request.getPlayerLastName(), request.getPlayerCountry());
            playerRepository.save(player);
        } else
            throw new InvalidRequestException("player already exist");
    }

    @Transactional
    public void removePlayer(Long playerId) {
        if (playerId == null)
            throw new InvalidRequestException(("Player id can not be null"));
        Player player = playerRepository.findById(playerId);
        if (player == null)
            throw new InvalidRequestException("Wrong Id. Such player does not exist");
        playerRepository.removePlayer(player);

    }
}
