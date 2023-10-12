package repository;

import domain.Applicant;
import domain.Employer;
import domain.JobListing;
import exceptions.MyException;

import java.util.List;
import java.util.Map;

public interface IRepository {
    void addEmployer(Employer givenEmployer);
    void addJobListing(JobListing givenJob);
    void addApplicant(Applicant givenApplicant);
    void applyToJob(Integer key, String value) throws MyException;
    List<Employer> getAllEmployes();
    List<Applicant> getAllApplicants();
    List<JobListing> getJobListings();
    Map<Integer,List<String>> getApplications();
    void removeJobListing(int id);
}
