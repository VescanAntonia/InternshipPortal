package domain;

public class Applicant {
    private final  String firstName, lastName;
    private final String emailAddress;
    private final String phoneNumber;
    private final String address;
    private final String country;
    private final String city;

    public Applicant(String fName, String lName,String emailAddress, String phoneNr,String address, String country,String city){
        this.firstName=fName;
        this.lastName=lName;
        this.emailAddress=emailAddress;
        this.phoneNumber=phoneNr;
        this.address=address;
        this.country=country;
        this.city=city;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
