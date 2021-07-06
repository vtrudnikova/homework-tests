package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        enterMobilePhone("9109101634");
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
        $("#firstName").setValue(name);
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
        $(".react-datepicker__month-select").selectOption("February");
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
        $("#uploadPicture").uploadFile(file);
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
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Student Name']/following-sibling::td").shouldHave(text("Violetta Trudnikova"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Student Email']/following-sibling::td").shouldHave(text("test@gmail.com"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Gender']/following-sibling::td").shouldHave(text("Female"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Mobile']/following-sibling::td").shouldHave(text("9109101634"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Date of Birth']/following-sibling::td").shouldHave(text("01 February,1995"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Hobbies']/following-sibling::td").shouldHave(text("Reading"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Picture']/following-sibling::td").shouldHave(text("test.png"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='Address']/following-sibling::td").shouldHave(text("Leninsky Prospect 76"));
        Selenide.$x("//*[@class='modal-body']//*[text() ='State and City']/following-sibling::td").shouldHave(text("NCR Gurgaon"));

    }
}
