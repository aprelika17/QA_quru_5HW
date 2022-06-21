package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestPageObject extends TestBase {

    @Test
    void fillForm() {

        //Переменные
        String firstName = "Тест";
        String lastName = "Гуру";
        String email = "test_quru@gmail.com";
        String gender = "Male";
        String phone = "9505555555";
        String year = "1970";
        String subject = "Hindi";
        String hobby = "Sports";
        String address = "г.Первый ул.Вторая д.1 кв. 2";
        String picture = "src/test/resources/File.jpeg";
        String state = "Haryana";
        String city = "Karnal";
        String happy_text = "Thanks for submitting the form";

        //Старт теста
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender()
                .setUserNumber(phone)
                .setDateOfBirth(year)
                .setSubject(subject)
                .setHobby()
                .setPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        //Проверки
        registrationFormPage.happyTestForm(happy_text)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", "02 August"  + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "File.jpeg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
