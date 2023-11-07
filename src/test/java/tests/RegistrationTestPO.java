package tests;

import data.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RegistrationTestPO extends TestBase {
    User user = new User();
    @BeforeEach

    public void before () {
        user.name = "Ann";
        user.lastName = "Tser";
        user.email = "ann@tser.com";
        user.gender = "Other";
        user.mobile = "0123456789";
        user.dateofbirth = "30 July,1990";
        user.subjects = "Maths";
        user.hobbies = "Music";
        user.picture = "1.png";
        user.address = "Moscow BC 11";
        user.state = "NCR";
        user.city= "Noida";


    }


    @Test
    void succesfulRegistrationTest() {


        registrationPage.openPage("/automation-practice-form")
                .removeBanners()
                .setFirstName("Ann")
                .setLastName("Tser")
                .setUserEmail("ann@tser.com")
                .setGender("Other")
                .setUserNumber("0123456789")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Music")
                .setFile("img/1.png")
                .setCurrentAddress("Moscow BC 11")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit();

//
               tableResultComponent.checkAllResult(user);




    //                .checkResult("Student Name", "Ann Tser")
//                .checkResult("Student Email", "ann@tser.com")
//                .checkResult("Mobile", "0123456789")
//                .checkResult("Subjects", "Math")
//                .checkResult("Picture", "1.png")
//                .checkResult("Address", "Moscow BC 11")
//                .checkResult("State and City", "NCR Noida");

    }

}




