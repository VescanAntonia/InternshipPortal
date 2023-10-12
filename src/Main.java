import controller.Controller;
import domain.Employer;
import exceptions.MyException;
import repository.IRepository;
import repository.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;
//
//public class Main {
//    public static void main(String[] args) throws MyException {
//        //Employer emp1= new Employer("Andrei","Puscas","puscas.andre@gmail.com");
////        IRepository repo= new Repository();
////        Controller controller=new Controller(repo);
//        //controller.addEmployer("Andrei","Puscas","puscas.andre@gmail.com");
//        //controller.addEmployer("Sophia","Beth","sophiabeth12@yahoo.com");
//        StringBuilder employesToPrint=controller.displayAllEmployes();
//        System.out.println(employesToPrint);
//
//
////        controller.addApplicant("Maria","Pop","maria.pop@gmail.com","0748521388","str. B.P.Hasdeu","Romania","Cluj-Napoca");
////        controller.addApplicant("Rebeca","Marian","rebecamarian@gmail.com","0748551388","str. Memorandumului","Romania","Cluj-Napoca");
////        controller.addApplicant("Daniela","Stelian","daniela.stelian@gmail.com","0748512348","str. B.P.Hasdeu","Romania","Cluj-Napoca");
////        controller.addApplicant("Aurora","Tanase","auroratanase60@gmail.com","0748521598","str. Frasinului","Romania","Cluj-Napoca");
////        controller.addApplicant("Amalia","Ardelean","amaliaardelean14@gmail.com","0747568121","str. 1 Mai","Romania","Cluj-Napoca");
//
//
//
//        StringBuilder applicantsToPrint=controller.displayAllApplicants();
//        System.out.println(applicantsToPrint);
//
////        controller.addJobListing("Company1","Andrei","Java Internship",new String[]{"Java","SQL","OOP"}, LocalDate.of(2023,10,10));
////        controller.addJobListing("Company1","Andrei","Python Internship",new String[]{"Python"}, LocalDate.of(2023,11,10));
////        controller.addJobListing("Company1","Andrei",".NET Internship",new String[]{".NET", "SQL"}, LocalDate.of(2023,11,15));
////        controller.addJobListing("Company1","Andrei","DevOps Internship",new String[]{"Linux","Cloud","Coding"}, LocalDate.of(2023,9,17));
////        controller.addJobListing("Company2","Sophia","QA Internship",new String[]{"Java","C#"}, LocalDate.of(2023,12,16));
////        controller.addJobListing("Company2","Sophia","Java Internship",new String[]{"Java","OOP"}, LocalDate.of(2023,11,19));
////        controller.addJobListing("Company2","Sophia",".NET Internship",new String[]{"C#","SQL"}, LocalDate.of(2023,10,26));
////        controller.addJobListing("Company2","Sophia","Python Internship",new String[]{"Python","SQL"}, LocalDate.of(2023,10,6));
//
//        controller.applyToJob("Maria","Company1","Java Internship");
//        controller.applyToJob("Rebeca","Company1","Java Internship");
//        controller.applyToJob("Rebeca","Company1","Python Internship");
//        StringBuilder jobsToPrint=controller.displayAllJobs();
//
//        controller.removeJobListing("Company1","Java Internship");
//        jobsToPrint=controller.displayAllJobs();
//        System.out.println(jobsToPrint);
//
//        StringBuilder jobsForGivenEmployer=controller.displayJobListingForGivenEmployer("Andrei");
//        System.out.println(jobsForGivenEmployer);
//
//        System.out.println("----All aplicants for given job listing----");
//        String applicantsForGivenJobListing=controller.displayAllApplicantsForGivenJobListing("Company1","Python Internship");
//        System.out.println(applicantsForGivenJobListing);
//
//        System.out.println("++++++For given employer+++++++");
//        System.out.println(controller.displayAllApplicantsForAnEmployer("Andrei"));
//
//    }
//}