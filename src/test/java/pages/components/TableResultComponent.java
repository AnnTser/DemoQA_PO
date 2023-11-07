package pages.components;

import com.codeborne.selenide.SelenideElement;
import data.User;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    SelenideElement
            tableField = $(".table-responsive");


    public TableResultComponent checkResult(String key, String value) {
        tableField.$(byText(key)).parent().shouldHave(text(value));

        return this;

    }


    public TableResultComponent checkAllResult(User user) {
        checkResult("Student Name", user.name + " " + user.lastName);
        checkResult("Student Email", user.email);
        checkResult("Gender", user.gender);
        checkResult("Mobile", user.mobile);
        checkResult("Date of Birth", user.dateofbirth);
        checkResult("Subjects", user.subjects);
        checkResult("Hobbies", user.hobbies);
        checkResult("Picture", user.picture);
        checkResult("Address", user.address);
        checkResult("State and City", user.state + " " + user.city);

        return this;
    }


}


