package recruitmenttask.snookermanagement.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bartosz on 2017-01-23.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private Long playerAId;
    private Long playerBId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Frame> frames;
    @ManyToOne(cascade = CascadeType.ALL)
    private Tournament tournament;

    public Game() {
    }

    public Game(Tournament tournament, Long playerAId, Long playerBId) {
        this.tournament = tournament;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
    }

    public Long getId() {
        return id;
    }

    public Long getPlayerAId() {
        return playerAId;
    }

    public Long getPlayerBId() {
        return playerBId;
    }

    public Set<Frame> getFrames() {
        return frames;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setFrames(Set<Frame> frames) {
        this.frames = frames;
    }
}
