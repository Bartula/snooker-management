package recruitmenttask.snookermanagement.api;


public class CreatePlayerRequest {

    private PlayerDTO player;

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public void validate() throws InvalidRequestException{
        if (player == null)
            throw new InvalidRequestException("player is required");
        player.validate();
    }

    public String getPlayerFirstName(){
        return player.getFirstName();
    }
    public String getPlayerLastName(){
        return player.getLastName();
    }
    public String getPlayerCountry(){
        return player.getCountry();
    }
}
