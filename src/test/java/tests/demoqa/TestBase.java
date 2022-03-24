package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";


//        System.setProperty("login", "user1");
//        System.setProperty("password", "1234");
//        System.setProperty("url", "selenoid.autotests.cloud/wd/hub");
//        String login = System.getProperty("login_qa_guru");
//        String password = System.getProperty("password_qa_guru");
//        String url = System.getProperty("url_qa_guru");
        String login = System.getProperty("login");
        String password = System.getProperty("password");
        String url = System.getProperty("url");
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        String remoteUrl = "https://" + login + ":" + password + "@" + url;
//        String remoteUrl = "https://" + login + ":" + password + "@" + url;
        Configuration.remote = remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}


