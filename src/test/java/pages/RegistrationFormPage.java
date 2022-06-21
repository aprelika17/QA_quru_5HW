package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $(byText("Male")),
            userNumber = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            currentAddress = $("#currentAddress"),
            subject = $("#subjectsInput"),
            hobby = $(byText("Sports")),
            picture = $("#uploadPicture"),
            state = $("#state"),
            stateValue =  $("#stateCity-wrapper"),
            city =  $("#city"),
            cityValue = $("#stateCity-wrapper"),
            submit = $("#submit"),
            happyText = $("#example-modal-sizes-title-lg");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {

        firstName.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender() {
        gender.click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String year) {
        dateOfBirth.click();

        calendarComponent.setDate(year);

        return this;
    }


    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subject.sendKeys(value);
        subject.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby() {
        hobby.click();

        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        picture.uploadFile(new File(value));

        return this;
    }

    public RegistrationFormPage setState(String value) {
        state.click();
        stateValue.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        city.click();
        cityValue.$(byText(value)).click();

        return this;
    }
    public RegistrationFormPage submit() {
        submit.click();

        return this;
    }

    public RegistrationFormPage happyTestForm(String value) {
        happyText.shouldHave(Condition.text(value));

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
