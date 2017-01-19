package recruitmenttask.snookermanagement.api;


public class PlayerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String country;

    public PlayerDTO() {
    }

    public PlayerDTO(Long id, String firstName, String lastName, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void validate() throws InvalidRequestException{
        if(firstName == null || firstName.trim().isEmpty())
            throw new InvalidRequestException("value FIRST NAME can not be empty");
        if(lastName == null || lastName.trim().isEmpty())
            throw new InvalidRequestException("value LAST NAME can not be empty");
        if(country == null || country.trim().isEmpty())
            throw new InvalidRequestException("value COUNTRY can not be empty");
    }
}
