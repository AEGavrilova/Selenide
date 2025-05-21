import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;

public class Steps {
    @Step("Открыть Google")
    public static void openGoogle() {
        open("https://www.google.com");
    }

    @Step("Выполнить поиск сайта Победы")
    public static void searchForPobedaSite() {
        $("[name='q']").setValue("Сайт компании Победа").pressEnter();
    }

    @Step("Кликнуть на первую ссылку в результатах поиска")
    public static void clickFirstSearchResult() {
        $$("div.g a").first().click();
    }

    @Step("Проверить что загрузился сайт Победы")
    public static void verifyPobedaSiteLoaded() {
        $(".header-logo").shouldBe(visible);
    }

    @Step("Проверить промо-текст: {expectedText}")
    public static void verifyPromoText(String expectedText) {
        $(".promo-banner").shouldHave(text(expectedText));
    }

    @Step("Выполнить специально падающий тест")
    public static void performFailingTest() {
        $(".non-existent-element").shouldBe(visible);
    }
    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }
}