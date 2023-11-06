package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTestPO extends TestBase {
    @Test
    void succesfulRegistrationTest() {


        registrationPage.openPage("/automation-practice-form")
                .executeJS("$('#fixedban').remove()")
                .executeJS("$('footer').remove()")
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
                .clickSubmit()

                .checkResult("Student Name", "Ann Tser")
                .checkResult("Student Email", "ann@tser.com")
                .checkResult("Mobile", "0123456789")
                .checkResult("Subjects", "Math")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Moscow BC 11")
                .checkResult("State and City", "NCR Noida");

    }

}




