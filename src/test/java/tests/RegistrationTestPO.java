package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTestPO extends TestBase {
    @Test
    void succesfulRegistrationTest() {


        registrationPage.openPage()
                .setFirstName ("Ann")
                .setLastName ("Tser")
                .setUserEmail ("ann@tser.com")
                .setGender("Other")
                .setUserNumber ("0123456789")
                .setDateOfBirth("30", "July", "2008");







        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Moscow BC 11");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("30 July,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Moscow BC 11"));
        $(".table-responsive").shouldHave(text("NCR Noida"));

        registrationPage.checkResult ("Student Name", "Ann Tser")
                .checkResult ("Student Email", "ann@tser.com")
                .checkResult ("Mobile", "0123456789");
    }



    }




