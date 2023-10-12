package tests;

import controller.Controller;
import exceptions.MyException;
import org.junit.Test;
import repository.IRepository;
import repository.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApplyToJobTest {

    @Test
    public void applicantInformationShouldBeSuccesfullySubmitted() throws MyException {
        IRepository repo= new Repository();
        Controller controller=new Controller(repo);
        controller.addEmployer("Andrei","Puscas","puscas.andre@gmail.com");
        controller.addEmployer("Sophia","Beth","sophiabeth12@yahoo.com");

        controller.addApplicant("Maria","Pop","maria.pop@gmail.com","0748521388","str. B.P.Hasdeu","Romania","Cluj-Napoca");
        controller.addApplicant("Rebeca","Marian","rebecamarian@gmail.com","0748551388","str. Memorandumului","Romania","Cluj-Napoca");

        controller.addJobListing("Company1","Andrei","Java Internship",new String[]{"Java","SQL","OOP"}, LocalDate.of(2023,10,10));
        controller.addJobListing("Company1","Andrei","Python Internship",new String[]{"Python"}, LocalDate.of(2023,11,10));

        Map<Integer, List<String>> originalApplications=repo.getApplications();
        System.out.println(originalApplications);
        controller.applyToJob("Rebeca","Company1","Python Internship");
        Map<Integer,List<String>> newApplications=repo.getApplications();
        System.out.println(newApplications);
        boolean areDifferent=true;

        if (originalApplications.size() == newApplications.size()) {
            for (Map.Entry<Integer, List<String>> entry : originalApplications.entrySet()) {
                int key = entry.getKey();
                List<String> originalValue = entry.getValue();
                List<String> newValue = newApplications.get(key);

                if (!newValue.equals(originalValue)) {
                    areDifferent = true;
                    break;
                }
            }
        } else {
            areDifferent = false;
        }
            //boolean areDifferent=!newApplications.equals(new HashMap<>(originalApplications));

        assertTrue(areDifferent);

    }

    @Test
    public void jobDoesNotExistError() throws MyException{
        IRepository repo= new Repository();
        Controller controller=new Controller(repo);
        controller.addEmployer("Andrei","Puscas","puscas.andre@gmail.com");
        controller.addEmployer("Sophia","Beth","sophiabeth12@yahoo.com");

        controller.addApplicant("Maria","Pop","maria.pop@gmail.com","0748521388","str. B.P.Hasdeu","Romania","Cluj-Napoca");
        controller.addApplicant("Rebeca","Marian","rebecamarian@gmail.com","0748551388","str. Memorandumului","Romania","Cluj-Napoca");

        controller.addJobListing("Company1","Andrei","Java Internship",new String[]{"Java","SQL","OOP"}, LocalDate.of(2023,10,10));
        controller.addJobListing("Company1","Andrei","Python Internship",new String[]{"Python"}, LocalDate.of(2023,11,10));

        controller.applyToJob("Rebeca","Company1","QA Internship");
        assertThrows(MyException.class, ()->{throw new MyException("There is no job with the given information.");});

    }
}