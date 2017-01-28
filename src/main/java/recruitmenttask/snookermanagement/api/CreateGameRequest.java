package recruitmenttask.snookermanagement.api;

/**
 * Created by Bartosz on 2017-01-27.
 */
public class CreateGameRequest {

    private GameDTO game;

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public Long getGamePlayerAId(){
        return game.getPlayerAId();
    }

    public Long getGamePlayerBId(){
        return game.getPlayerBId();
    }

    public void validate() throws InvalidRequestException{
        if (game == null)
            throw new InvalidRequestException("game is required");
        game.validate();
    }
}
