package recruitmenttask.snookermanagement.ui;

import org.springframework.web.bind.annotation.*;
import recruitmenttask.snookermanagement.api.CreateFrameRequest;
import recruitmenttask.snookermanagement.api.GamePanel;

/**
 * Created by Bartosz on 2017-01-28.
 */
@RestController
@RequestMapping("/game")
public class GameController {

    private GamePanel gamePanel;

    public GameController(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @PutMapping("/{gameId}/frame")
    public void createFrame(@PathVariable Long gameId, @RequestBody CreateFrameRequest request){
        gamePanel.createNewFrame(gameId, request);
    }
}
