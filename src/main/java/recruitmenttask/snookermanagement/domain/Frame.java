package recruitmenttask.snookermanagement.domain;

import javax.persistence.*;

/**
 * Created by Bartosz on 2017-01-23.
 */
@Entity
public class Frame {

    @Id
    @GeneratedValue
    private Long id;

    private Long playerAScore;
    private Long playerBScore;

    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;

    public Frame() {
    }

    public Frame(Game game, Long playerAScore, Long playerBScore) {
        this.game = game;
        this.playerAScore = playerAScore;
        this.playerBScore = playerBScore;
    }

    public Long getId() {
        return id;
    }

    public Long getPlayerAScore() {
        return playerAScore;
    }

    public Long getPlayerBScore() {
        return playerBScore;
    }

    public Game getGame() {
        return game;
    }
}
