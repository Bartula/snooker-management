package recruitmenttask.snookermanagement.api;

/**
 * Created by Bartosz on 2017-01-28.
 */
public class FrameDTO {

    private Long id;
    private Long playerAScore;
    private Long playerBScore;

    public FrameDTO() {
    }

    public FrameDTO(Long id, Long playerAScore, Long playerBScore) {
        this.id = id;
        this.playerAScore = playerAScore;
        this.playerBScore = playerBScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerAScore() {
        return playerAScore;
    }

    public void setPlayerAScore(Long playerAScore) {
        this.playerAScore = playerAScore;
    }

    public Long getPlayerBScore() {
        return playerBScore;
    }

    public void setPlayerBScore(Long playerBScore) {
        this.playerBScore = playerBScore;
    }

    public void validate() {
        if(playerAScore == null || playerBScore == null)
            throw new InvalidRequestException("values of players scores can not be empty");
    }
}
