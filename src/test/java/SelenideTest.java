
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(".search-input").click();
        $("#query-builder-test").sendKeys("qa-guru/qa_guru_14_10");
        $("#query-builder-test").submit();

        $(linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();
        $(withText("#2")).should(Condition.exist);


    }
}
