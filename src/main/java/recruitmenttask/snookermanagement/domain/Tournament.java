package recruitmenttask.snookermanagement.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bartosz on 2017-01-23.
 */
@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;

    private String year;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Player> players;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Game> games;

    public Tournament() {
    }

    public Tournament(String year, String name) {
        this.year = year;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
