import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.title;

public class BasePage {
    protected SelenideElement logo = $("a[class='dp-1abiuov-root-root-root'] img[alt='«Авиакомпания «Победа», Группа «Аэрофлот»']");
    protected SelenideElement alternativeLogo = $("a[class='dp-1abiuov-root-root-root'] img[alt='«Авиакомпания «Победа», Группа «Аэрофлот»']");

    public void verifyPageOpened() {
        Configuration.timeout = 15000;

        $("body").shouldBe(visible, Duration.ofSeconds(15));

        try {
            logo.shouldBe(visible, Duration.ofSeconds(5));
        } catch (Throwable e) {
            alternativeLogo.shouldBe(visible, Duration.ofSeconds(5));
        }

        webdriver().shouldHave(title("Авиакомпания «Победа», Группа «Аэрофлот»"));
    }
}