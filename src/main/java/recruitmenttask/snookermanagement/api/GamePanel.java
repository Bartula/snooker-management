package recruitmenttask.snookermanagement.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import recruitmenttask.snookermanagement.domain.Frame;
import recruitmenttask.snookermanagement.domain.Game;
import recruitmenttask.snookermanagement.domain.GameRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bartosz on 2017-01-28.
 */
@Service
public class GamePanel {

    private GameRepository gameRepository;

    public GamePanel(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void createNewFrame(Long gameId, CreateFrameRequest request) {
        Game game = gameRepository.findById(gameId);
        if (game == null)
            throw new InvalidRequestException("Wrong game id.");
        Frame frame = new Frame(game, request.getPLayerAScore(), request.getPLayerBScore());
        Set<Frame> frames = game.getFrames();
        if (frames == null){
            frames = new HashSet<>();
            frames.add(frame);
            game.setFrames(frames);
        }else {
            frames.add(frame);
        }
    }
}
