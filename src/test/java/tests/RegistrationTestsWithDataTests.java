package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationTestsWithDataTests extends TestBase {

//    String firstName ="Alex",
//           lastName ="Tser",
//           userEmail ="ann@tser.com",
//           gender ="Other";


//    public static final  String firstName ="Alex",
//           lastName ="Tser",
//           userEmail ="ann@tser.com",
//           gender ="Other";


//    static String firstName,
//           lastName,
//           userEmail,
//           gender;

//    @BeforeEach
//    void prepareTestData(){
//        firstName ="Alex";
//           lastName ="Tser";
//           userEmail ="ann@tser.com";
//           gender ="Other";
//    }

    @Test
    void succesfulRegistrationTest() {
        open("/automation-practice-form");
        String userName = firstName;
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ann" + " Tser"));
        $(".table-responsive").shouldHave(text("ann@tser.com"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("30 July,1990"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Moscow BC 11"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }

}