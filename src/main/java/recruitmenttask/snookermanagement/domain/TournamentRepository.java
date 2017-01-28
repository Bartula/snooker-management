package recruitmenttask.snookermanagement.domain;

/**
 * Created by Bartosz on 2017-01-24.
 */
public interface TournamentRepository {
    Tournament load(String tournamentYear, String tournamentName);

    void save(Tournament tournament);

    Tournament findById(Long tournamentId);
}
