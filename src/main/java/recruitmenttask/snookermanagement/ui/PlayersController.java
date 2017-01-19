package recruitmenttask.snookermanagement.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recruitmenttask.snookermanagement.api.AdminPanel;
import recruitmenttask.snookermanagement.api.CreatePlayerRequest;


@RestController
@RequestMapping("/player")
public class PlayersController {

    private AdminPanel adminPanel;

    public PlayersController(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    @PutMapping
    public void createNewPlayer(@RequestBody CreatePlayerRequest request){
        adminPanel.createNewPlayer(request);
    }
}
