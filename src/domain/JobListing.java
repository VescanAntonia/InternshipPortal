package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class JobListing {
    private static int nextOne=1;
    private int id;
    private final String companyName;
    private final String employeName;
    private final String jobPosition;
    private final String[] neededSkills;
    private final LocalDate deadline;

    public JobListing(String company,String employe, String jobPosition, String[] skills, LocalDate deadline){
        this.id=nextOne++;
        this.companyName=company;
        this.jobPosition=jobPosition;
        this.neededSkills=skills;
        this.deadline=deadline;
        this.employeName=employe;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public String[] getNeededSkills() {
        return neededSkills;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getEmployeName() {
        return employeName;
    }

    @Override
    public String toString() {
        return "JobListing{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", employeName='" + employeName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", neededSkills=" + Arrays.toString(neededSkills) +
                ", deadline=" + deadline +
                '}';
    }
}
