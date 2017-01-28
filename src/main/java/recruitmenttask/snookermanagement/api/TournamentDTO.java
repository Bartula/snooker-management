package recruitmenttask.snookermanagement.api;

import recruitmenttask.snookermanagement.infrastructure.Utils;


public class TournamentDTO {

    private Long id;
    private String year;
    private String name;

    public TournamentDTO() {
    }

    public TournamentDTO(Long id, String year, String name) {
        this.id = id;
        this.year = year;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validate() throws InvalidRequestException{
        if (year == null)
            throw new InvalidRequestException("year can not be null");
        if (name == null || name.trim().isEmpty())
            throw new InvalidRequestException("name can not be empty");
        if (!Utils.checkYearFormat(year))
            throw new InvalidRequestException("Wrong year format");
    }
}
