package ui;

import controller.Controller;
import exceptions.MyException;
import repository.IRepository;
import repository.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Ui {

    public static void showMenu(){
        System.out.println(" 1. Add a new job listing.");
        System.out.println(" 2. Apply to job listing.");
        System.out.println(" 3. Display all job listings for an employer.");
        System.out.println(" 4. Display all applicants for an employer.");
        System.out.println(" 5. Display all applicants for a job listing.");
        System.out.println(" 6. Delete a job listing.");
        System.out.println(" If you do not want to perform any other operation please insert 0.");
    }

    public static void main(String[] args) throws MyException {
        Scanner scanner=new Scanner(System.in);
        IRepository repo= new Repository();
        Controller controller=new Controller(repo);
        int option;
        controller.initializeData();
        System.out.println("----All employers----");
        System.out.println(controller.displayAllEmployes());
        System.out.println("----All applicants----");
        System.out.println(controller.displayAllApplicants());
        System.out.println("----All jobs----");
        System.out.println(controller.displayAllJobs());
        do{
            showMenu();
            System.out.println("Choose an option: ");
            option=scanner.nextInt();
            scanner.nextLine();


            switch(option){
                case 1:
                    try{
                    System.out.println("Please complete the required fields.");
                    System.out.println("Company name: ");
                    String companyName=scanner.nextLine();
                    System.out.println("Job position: ");
                    String jobPosition=scanner.nextLine();
                    System.out.println("Needed skills with coma between each one of them: ");
                    String[] skills=scanner.nextLine().split(",");
                    System.out.println("Deadline(yyyy-mm-dd): ");
                    String deadline=scanner.nextLine();
                    System.out.println("Employe name: ");
                    String employeName=scanner.nextLine();
                    if(companyName== null ||jobPosition==null||skills.length==0|| deadline==null|| employeName==null){
                        throw new MyException("All fields should be completed. ");
                    }
                    LocalDate localDate = LocalDate.parse(deadline);
                    controller.addJobListing(companyName,employeName,jobPosition,skills,localDate);
                    System.out.println("Added successfully!");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                    System.out.println("Please complete the required fields.");
                    System.out.println("First name: ");
                    String firstName=scanner.nextLine();
                    System.out.println("Last name: ");
                    String lastName=scanner.nextLine();
                    System.out.println("Email address: ");
                    String emailAddress=scanner.nextLine();
                    System.out.println("Phone number: ");
                    String phoneNumber=scanner.nextLine();
                    System.out.println("Address: ");
                    String address=scanner.nextLine();
                    System.out.println("Country: ");
                    String country=scanner.nextLine();
                    System.out.println("City: ");
                    String city=scanner.nextLine();
                        System.out.println("The company you want to apply: ");
                        String company=scanner.nextLine();
                        System.out.println("The job you want to apply to: ");
                        String job=scanner.nextLine();
                        if(firstName== null ||lastName==null||emailAddress==null|| phoneNumber==null|| address==null||country==null||city==null){
                            throw new MyException("All fields should be completed. ");
                        }
                        controller.addApplicant(firstName,lastName,emailAddress,phoneNumber,address,country,city);

                        controller.applyToJob(firstName,company,job);
                        System.out.println("Applied successfully! ");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try{
                        System.out.println("-----All available employers-----");
                        System.out.println(controller.displayAllEmployes());
                        System.out.println("Employer name: ");
                        String employerName=scanner.nextLine();
                        if(employerName == null){
                            throw new MyException("No employer name inserted.");
                        }
                        System.out.println(controller.displayJobListingForGivenEmployer(employerName));

                    }catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try{
                        System.out.println("-----All employers-----");
                        System.out.println(controller.displayAllEmployes());
                        System.out.println("Employer name: ");
                        String employerName=scanner.nextLine();
                        if(employerName == null) {
                            throw new MyException("No employer name inserted.");
                        }
                        if(controller.displayAllApplicantsForAnEmployer(employerName)==null){
                            throw new MyException("There are no applicants for the given employer.");
                        }
                        System.out.println(controller.displayAllApplicantsForAnEmployer(employerName));
                    }catch (MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        System.out.println("-----All jobs-----");
                        System.out.println(controller.displayAllJobs());
                        System.out.println("Company name: ");
                        String companyName=scanner.nextLine();
                        System.out.println("Job position: ");
                        String jobPosition=scanner.nextLine();
                        if(companyName == null|| jobPosition==null) {
                            throw new MyException("All fields must be completed.");
                        }
                        System.out.println(controller.displayAllApplicantsForGivenJobListing(companyName,jobPosition));
                    }catch (MyException e){
                            System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try{
                        System.out.println("---Initial jobs---");
                        System.out.println(controller.displayAllJobs());
                        System.out.println("Company name: ");
                        String companyName=scanner.nextLine();
                        System.out.println("Job position: ");
                        String jobPosition=scanner.nextLine();
                        if(companyName == null|| jobPosition==null) {
                            throw new MyException("No employer name inserted.");
                        }
                        controller.removeJobListing(companyName,jobPosition);
                        System.out.println("---After the deletion---");
                        System.out.println(controller.displayAllJobs());
                    }catch (MyException e){
                        System.out.println(e.getMessage());
                    }
                    break;



                case 0:
                    System.out.println("See you later!");
                    break;
                default:
                    System.out.println("There entered option is invalid.");
                    break;
            }

        }while(option!=0);
        scanner.close();

    }
}
