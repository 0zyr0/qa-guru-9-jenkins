package tests.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {

    @Test
    void registrationTest() {
        open("https://demoqa.com/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Zero");
        $("#userEmail").setValue("ozero@mail.com");
        $("[for=\"gender-radio-3\"]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#userNumber").setValue("8800555353");
        $("#currentAddress").setValue("www.leningrad-spb.ru");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table").shouldHave(text("Student Name"), text("Max Zero"));
        $(".table").shouldHave(text("Student Email"), text("ozero@mail.com"));
        $(".table").shouldHave(text("Gender"), text("Other"));
        $(".table").shouldHave(text("Mobile"), text("8800555353"));
        $(".table").shouldHave(text("Date of Birth"), text("30 July,2008"));
        $(".table").shouldHave(text("Subjects"), text("Maths"));
        $(".table").shouldHave(text("Hobbies"), text("Music"));
        $(".table").shouldHave(text("Address"), text("www.leningrad-spb.ru"));
        $(".table").shouldHave(text("State and City"), text("NCR Delhi"));
        $("#closeLargeModal").scrollTo().pressEnter();
    }

    @Owner("zaytsevms")
    @Feature("Registration")
    @Story("Регистрация")
    @DisplayName("Регистрация")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void registrationStepAllureTest()  {
        // Open website

        step("Открываем страницу", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });


        step("Заполняем имя", () -> {
            $("#firstName").setValue("Max");
        });

        step("Заполняем фамилию", () -> {
            $("#lastName").setValue("Zero");
        });

        step("Заполняем email", () -> {
            $("#userEmail").setValue("ozero@mail.com");
        });

        step("Выбираем пол", () -> {
            $("[for=\"gender-radio-3\"]").click();
        });

        step("Заполняем номер телефона", () -> {
            $("#userNumber").setValue("8800555353");
//            $(".custom-control-label").click();
//            $("#userNumber").setValue("5648798798");
        });

        step("Заполняем дату", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2008");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        });

        step("Заполняем хобби", () -> {
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
        });


        step("Заполняем адрес", () -> {
            $("#currentAddress").setValue("www.leningrad-spb.ru");
        });

        step("Заполняем штат", () -> {
            $("#state").scrollTo().click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
        });

        step("Заполняем город", () -> {
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
        });

        step("Отправляем форму", () -> {
            $("#submit").click();
        });

        // Assertion

        step("Проверяем отображения модальной формы", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
        });

        step("Проверяем правильность заполнения формы", () -> {
            $(".table").shouldHave(text("Student Name"), text("Max Zero"));
            $(".table").shouldHave(text("Student Email"), text("ozero@mail.com"));
            $(".table").shouldHave(text("Gender"), text("Other"));
            $(".table").shouldHave(text("Mobile"), text("8800555353"));
            $(".table").shouldHave(text("Date of Birth"), text("30 July,2008"));
            $(".table").shouldHave(text("Subjects"), text("Maths"));
            $(".table").shouldHave(text("Hobbies"), text("Music"));
            $(".table").shouldHave(text("Address"), text("www.leningrad-spb.ru"));
            $(".table").shouldHave(text("State and City"), text("NCR Delhi"));
        });

        step("Закрываем окно", () -> {
            $("#closeLargeModal").scrollTo().pressEnter();
        });

    }


//    @Test
//    @Tag("properties")
//    void someTest5() {
//        String browser = System.getProperty("browser");
//
//        System.out.println(browser);
//
//    }
//
//    @Test
//    @Tag("properties")
//    void someTest6() {
//        String browser = System.getProperty("browser");
//
//        System.out.println(browser);
//
//    }

}




