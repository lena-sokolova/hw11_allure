package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

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
        $("#query-builder-test").setValue("lena-sokolova/hw11_allure");
        $("#query-builder-test").submit();

        $(linkText("lena-sokolova/hw11_allure")).click();
        $("#issues-tab").shouldBe(Condition.visible);
    }
}
