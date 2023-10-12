package repository;

import domain.Applicant;
import domain.Employer;
import domain.JobListing;
import exceptions.MyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository implements IRepository{

    private List<Employer> listOfEmployers;
    private List<Applicant> listOfApplicants;
    private List<JobListing> listOfJobListings;
    private Map<Integer,List<String>> applications;

    public Repository(){
        this.listOfEmployers=new ArrayList<>();
        this.listOfApplicants=new ArrayList<>();
        this.listOfJobListings=new ArrayList<>();
        this.applications=new HashMap<>();
    }

    @Override
    public void addEmployer(Employer givenEmployer) {
        this.listOfEmployers.add(givenEmployer);
    }

    @Override
    public void addJobListing(JobListing givenJob) {
        this.listOfJobListings.add(givenJob);
    }

    @Override
    public void addApplicant(Applicant givenApplicant) {
        this.listOfApplicants.add(givenApplicant);
    }

    @Override
    public void applyToJob(Integer key, String value) throws MyException {
        //TODO
        try{
        if(this.applications.containsKey(key)){
            List<String> values=this.applications.get(key);
            if(values.contains(value)){
                throw new MyException("There is already an application under this name.");
            }
        }
        this.applications.computeIfAbsent(key, k -> new ArrayList<>()).add(value);}
        catch(MyException e){
            System.out.println(e.getMessage());
        }
        //System.out.println(this.applications);
    }

    @Override
    public List<Employer> getAllEmployes() {
        return this.listOfEmployers;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return this.listOfApplicants;
    }

    @Override
    public List<JobListing> getJobListings() {
        return this.listOfJobListings;
    }

    @Override
    public Map<Integer, List<String>> getApplications() {
        return this.applications;
    }

    @Override
    public void removeJobListing(int id) {
        this.listOfJobListings.remove(id-1);
    }


}
