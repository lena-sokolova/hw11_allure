package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(baseUrl);

        $(".header-search-button").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example");
        $("#query-builder-test").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_" + "81" + "_link").shouldHave(text("issue_to_test_allure_report"));
    }
}
