package recruitmenttask.snookermanagement.domain;

/**
 * Created by Bartosz on 2017-01-28.
 */
public interface GameRepository {
    Game findById(Long gameId);
}
