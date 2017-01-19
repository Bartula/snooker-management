package recruitmenttask.snookermanagement.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.domain.Player;
import recruitmenttask.snookermanagement.domain.PlayerRepository;


@Service
public class AdminPanel {

    private PlayerRepository playerRepository;

    public AdminPanel(PlayerRepository playerRepository) {
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
}
