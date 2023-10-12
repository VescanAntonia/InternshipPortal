package domain;

public class Employer {
    private final String fName, lName;
    private final String emailAdr;

    public Employer(String fName,String lName, String emailAdr){
        this.fName=fName;
        this.lName=lName;
        this.emailAdr=emailAdr;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmailAdr() {
        return emailAdr;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", emailAdr='" + emailAdr + '\'' +
                '}';
    }
}
