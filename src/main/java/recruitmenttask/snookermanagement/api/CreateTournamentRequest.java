package recruitmenttask.snookermanagement.api;


public class CreateTournamentRequest {

    private TournamentDTO tournament;

    public TournamentDTO getTournament() {
        return tournament;
    }

    public void setTournament(TournamentDTO tournamentDTO) {
        this.tournament = tournamentDTO;
    }

    public void validate() {
        if (tournament == null)
            throw new InvalidRequestException("tournament is required");
        tournament.validate();
    }

    public String getTournamentName(){
        return tournament.getName();
    }

    public String getTournamentYear(){
        return tournament.getYear();
    }
}
