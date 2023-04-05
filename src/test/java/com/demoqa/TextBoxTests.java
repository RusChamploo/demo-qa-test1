package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;




public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void succesfullFillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@mail.ru");
        $("[class=custom-control-label]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").setValue("25 Apr 1995");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/example.jpg"));
        $("#currentAddress").setValue("Unknown");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".table").shouldHave(
                text("Ivan Ivanov"),
                text("Ivan@mail.ru"),
                text("Male"),
                text("1234567890"),
                text("25 Apr 1995"),
                text("English"),
                text("Sports, Reading, Music"),
                text("example.jpg"),
                text("NCR"),
                text("Delhi")
        );

    }
}
