package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationsPageTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void registerUser() {
        openPage();
        enterFirstNameAndLastName("Violetta", "Trudnikova");
        enterEmail("test@gmail.com");
        selectGender("Female");
        enterMobilePhone("89109101634");
        selectDatOfBirth();
        selectSubject("English");
        selectHobbies("Reading");
        uploadPicture();
        enterAddress("Leninsky Prospect 76");
        selectStateAndCity("NCR", "Gurgaon");
        pressSubmit();
        checkSuccessfulForm();
    }

    void openPage() {
        open("/automation-practice-form");
    }

    void enterFirstNameAndLastName(String name, String lastName) {
        $(byId("firstName")).setValue(name);
        $(byId("lastName")).setValue(lastName);
    }

    void enterEmail(String email) {
        $(byId("userEmail")).setValue(email);
    }

    void selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    void enterMobilePhone(String mobilePhone) {
        $(byId("userNumber")).setValue(mobilePhone);
    }

    void selectDatOfBirth() {
        $(byId("dateOfBirthInput")).click();
        $(byClassName("react-datepicker__month-select")).selectOption("February");
        $(byClassName("react-datepicker__year-select")).selectOption("1995");
        Selenide.$x("//*[@class= 'react-datepicker__week']/*[text()=1]").click();
    }

    void selectSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    void selectHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    void uploadPicture() {
        File file = new File("src/test/resources/test.png");
        $("#uploadPicture").should(exist).uploadFile(file);
    }

    void enterAddress(String address) {
        $(byId("currentAddress")).setValue("Leninsky Prospect 76");
    }

    void selectStateAndCity(String state, String city) {
        $("#stateCity-wrapper").$(byText("Select State")).scrollTo().click();
        $("#state").$(byText(state)).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#city").$(byText(city)).click();
    }

    void pressSubmit() {
        $(byId("submit")).click();
    }

    void checkSuccessfulForm() {
        SelenideElement message = $("#example-modal-sizes-title-lg");
        Assertions.assertEquals("Thanks for submitting the form", message.getText());

    }
}
