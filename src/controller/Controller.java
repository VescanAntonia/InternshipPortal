package controller;

import domain.Applicant;
import domain.Employer;
import domain.JobListing;
import exceptions.MyException;
import repository.IRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Controller {
    IRepository repository;

    public Controller(IRepository repository){
        this.repository=repository;
    }

    public void initializeData() throws MyException {

        this.addEmployer("Andrei","Puscas","puscas.andre@gmail.com");
        this.addEmployer("Sophia","Beth","sophiabeth12@yahoo.com");

        this.addApplicant("Maria","Pop","maria.pop@gmail.com","0748521388","str. B.P.Hasdeu","Romania","Cluj-Napoca");
        this.addApplicant("Rebeca","Marian","rebecamarian@gmail.com","0748551388","str. Memorandumului","Romania","Cluj-Napoca");
        this.addApplicant("Daniela","Stelian","daniela.stelian@gmail.com","0748512348","str. B.P.Hasdeu","Romania","Cluj-Napoca");
        this.addApplicant("Aurora","Tanase","auroratanase60@gmail.com","0748521598","str. Frasinului","Romania","Cluj-Napoca");
        this.addApplicant("Amalia","Ardelean","amaliaardelean14@gmail.com","0747568121","str. 1 Mai","Romania","Cluj-Napoca");
        this.addApplicant("Antonia","Pop","antoniapop@gmail.com","0747568551","str. 1 Sept","Romania","Sibiu");
        this.addApplicant("Daria","Pasca","dariaapasca@gmail.com","0745868121","str. Primaverii","Romania","Brasov");
        this.addApplicant("Alin","Puscas","puscasalin@gmail.com","0712698121","str. Brasovului","Romania","Bucuresti");
        this.addApplicant("Cristian","Pavel","pavelcristian@gmail.com","0747128121","str. Republicii","Romania","Timisoara");
        this.addApplicant("Ana","Vlad","amaliaardelean14@gmail.com","0747125774","str. Unirii","Romania","Oradea");



        this.addJobListing("Company1","Andrei","Java Internship",new String[]{"Java","SQL","OOP"}, LocalDate.of(2023,10,10));
        this.addJobListing("Company1","Andrei","Python Internship",new String[]{"Python"}, LocalDate.of(2023,11,10));
        this.addJobListing("Company1","Andrei",".NET Internship",new String[]{".NET", "SQL"}, LocalDate.of(2023,11,15));
        this.addJobListing("Company1","Andrei","DevOps Internship",new String[]{"Linux","Cloud","Coding"}, LocalDate.of(2023,9,17));
        this.addJobListing("Company2","Sophia","QA Internship",new String[]{"Java","C#"}, LocalDate.of(2023,12,16));
        this.addJobListing("Company2","Sophia","Java Internship",new String[]{"Java","OOP"}, LocalDate.of(2023,11,19));
        this.addJobListing("Company2","Sophia",".NET Internship",new String[]{"C#","SQL"}, LocalDate.of(2023,10,26));
        this.addJobListing("Company2","Sophia","Python Internship",new String[]{"Python","SQL"}, LocalDate.of(2023,10,6));

        this.applyToJob("Maria","Company1","Java Internship");
        this.applyToJob("Rebeca","Company1","Java Internship");
        this.applyToJob("Rebeca","Company1","Python Internship");
        this.applyToJob("Ana","Company1",".NET Internship");
        this.applyToJob("Alin","Company1","Java Internship");
        this.applyToJob("Cristian","Company1","Python Internship");
        this.applyToJob("Antonia","Company1","Python Internship");
        this.applyToJob("Daria","Company1","Java Internship");
        this.applyToJob("Amalia","Company1","Python Internship");
        this.applyToJob("Aurora","Company1",".NET Internship");

        this.applyToJob("Maria","Company2","Java Internship");
        this.applyToJob("Rebeca","Company2","QA Internship");
        this.applyToJob("Rebeca","Company2","Python Internship");
        this.applyToJob("Ana","Company2",".NET Internship");
        this.applyToJob("Alin","CompanY2","Java Internship");
        this.applyToJob("Cristian","Company2","QA Internship");
        this.applyToJob("Antonia","Company2","QA Internship");
        this.applyToJob("Daria","Company2","Java Internship");
        this.applyToJob("Amalia","Company2","QA Internship");
        this.applyToJob("Aurora","Company2",".NET Internship");
    }

    public void addApplicant(String fName, String lName,String emailAddress, String phoneNr, String address, String country, String city){
        Applicant givenApplicant= new Applicant(fName,lName,emailAddress,phoneNr,address,country,city);
        this.repository.addApplicant(givenApplicant);
    }
    public void addJobListing(String company,String employe, String jobPosition, String[] skills, LocalDate deadline){
        JobListing givenJob=new JobListing(company,employe,jobPosition,skills,deadline);
        this.repository.addJobListing(givenJob);
    }
    public void addEmployer(String fName,String lName, String emailAddress){
        Employer givenEmployer= new Employer(fName,lName,emailAddress);
        this.repository.addEmployer(givenEmployer);
    }

    /**
     * Successfully adds an applicant to the applications list for a given job or throws an error if there is no job with the given
     * description
     * @param applicantName: the name of the applicant
     * @param companyName: the company the applicant wants to apply
     * @param positionName:the position the applicant wants to apply to
     * @throws MyException: if the job does not exist
     */
    public void applyToJob(String applicantName,String companyName, String positionName) throws MyException{
        try{
        //List<Applicant> applicants=this.repository.getAllApplicants();
        int jobListingId=0;
        List<JobListing> jobs=this.repository.getJobListings();
        for(JobListing job:jobs){
            if (job.getCompanyName().equals(companyName) && job.getJobPosition().equals(positionName)){
                jobListingId=job.getId();
            }
        }
        if(jobListingId!=0){
            this.repository.applyToJob(jobListingId,applicantName);
        }
        else{
            throw new MyException("There is no job with the given information.");
        }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }

    }

    public StringBuilder displayAllEmployes() throws MyException{
            try {
                List<Employer> employes = this.repository.getAllEmployes();
                StringBuilder employesToPrint = new StringBuilder();
                for (Employer emp : employes) {
                    employesToPrint.append(emp.toString()).append("\n");
                }
                if(employesToPrint.length()==0) {
                    throw new MyException("There are not employees to display.");
                }
                return employesToPrint;
            }catch(MyException e){
                System.out.println(e.getMessage());
            }

        return null;
    }

    public StringBuilder displayAllApplicants(){
        List<Applicant> applicants=this.repository.getAllApplicants();
        StringBuilder applicantsToPrint= new StringBuilder();
        for(Applicant applicant:applicants){
            applicantsToPrint.append(applicant.toString()).append("\n");
        }
        return applicantsToPrint;
    }
    public StringBuilder displayAllJobs(){
        List<JobListing> jobs=this.repository.getJobListings();
        StringBuilder jobsToPrint= new StringBuilder();
        for(JobListing job:jobs){
            jobsToPrint.append(job.toString()).append("\n");
        }
        return jobsToPrint;
    }

    public void removeJobListing(String givenCompanyName,String givenJobPosition) throws MyException{
        try{
            List<JobListing> jobs=this.repository.getJobListings();
            for(JobListing job:jobs){
                if(job.getCompanyName().equals(givenCompanyName)&&job.getJobPosition().equals(givenJobPosition)){
                    this.repository.removeJobListing(job.getId());
                    break;
                }
                else{
                    throw new MyException("The job with the given information does not exist.");
                }
            }

        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * returns the list with the job listings for the given employer
     * @param employeName: the given employer
     * @return : the list with the jobs
     * @throws MyException: if theere are no job listings for the given employer
     */
    public StringBuilder displayJobListingForGivenEmployer(String employeName)throws MyException{
        try{
            List<JobListing> jobs=this.repository.getJobListings();
            StringBuilder jobsToPrint= new StringBuilder();
            for(JobListing job:jobs){
                if(job.getEmployeName().equals(employeName)){
                    jobsToPrint.append(job.toString()).append("\n");
                }
            }
            if(jobsToPrint.length()!=0){
                return jobsToPrint;
            }
            else{
                throw new MyException("There are no job listings for the given employer.");
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * returns all applicants for an employer
     * @param employerName :the given employer
     * @return : the list with the corresponding applicants
     * @throws MyException : an exception if there are no applicants for the given employer
     */
    public StringBuilder displayAllApplicantsForAnEmployer(String employerName)throws MyException{
        try{
            List<JobListing> jobs=this.repository.getJobListings();
            StringBuilder applicantsToPrint=new StringBuilder();
            int[] jobsIds = new int[jobs.size()];
            int i=0;
            for(JobListing job:jobs){
                if(job.getEmployeName().equals(employerName)){
                    jobsIds[i]=job.getId();
                    i++;
                }
            }
            if(jobsIds.length!=0){
                for (int jobsId : jobsIds) {
                    StringBuilder result=displayAllApplicantsForGivenJobListingById(jobsId);
                    if(result!=null){
                        applicantsToPrint.append(result);
                    }
                }
                if(applicantsToPrint.length()!=0){
                    return applicantsToPrint;
                }
                else{
                    throw new MyException("There are no applicants for the given employer.");
                }
            }
            else{
                throw new MyException("There are no jobs for the given employer.");
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * displays all the applicants for a given job id
     * @param givenId : the given id of the job listing
     * @return : the list of the applicants
     */
    public StringBuilder displayAllApplicantsForGivenJobListingById(int givenId){
        Map<Integer,List<String>> allApplications=this.repository.getApplications();
        List<String> values=allApplications.get(givenId);
        if(values!=null){
        StringBuilder applicantsToPrint=new StringBuilder(values.toString());
        return applicantsToPrint;}
        else{
            return null;
        }

    }

    /**
     * returns the list of the applicants for a given job listing
     * @param company : the company that has the job
     * @param givenJobPosition : the name of the job
     * @return: the list of the applicants
     * @throws MyException : an exception if there are no applications for the given job or if there is no job that matches the
     * information
     */
    public String displayAllApplicantsForGivenJobListing(String company, String givenJobPosition) throws MyException{
        try{
            int jobId=-1;
            List<JobListing> jobs=this.repository.getJobListings();
            for(JobListing job:jobs){
                if(job.getCompanyName().equals(company)&&job.getJobPosition().equals(givenJobPosition)){
                    jobId=job.getId();
                    break;
                }
            }
            Map<Integer,List<String>> allApplications=this.repository.getApplications();
            if(jobId==-1){
                throw new MyException("There are no applications for the given job.");
            }
            if (!allApplications.containsKey(jobId)){
                throw new MyException("There is no job for the given information.");
            }
            else{
                List<String> values=allApplications.get(jobId);
                String applicantsToPrint=values.toString();
                return applicantsToPrint;
            }

        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }




}
