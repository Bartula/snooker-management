package recruitmenttask.snookermanagement.api;

/**
 * Created by Bartosz on 2017-01-27.
 */
public class GameDTO {

    private Long id;
    private Long playerAId;
    private Long playerBId;

    public GameDTO(Long id, Long playerAId, Long playerBId) {
        this.id = id;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(Long playerAId) {
        this.playerAId = playerAId;
    }

    public Long getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(Long playerBId) {
        this.playerBId = playerBId;
    }

    public void validate() {
        if(playerAId == null || playerBId == null)
            throw new InvalidRequestException("values of players Id can not be empty");
        if (playerAId.equals(playerBId))
            throw new InvalidRequestException("Ids can not be the same");
    }
}
