import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage extends BasePage {
    private final SelenideElement pageTitle = $("a[class='dp-1abiuov-root-root-root']");
    private final SelenideElement logo = $("a[class='dp-1abiuov-root-root-root'] img[alt='«Авиакомпания «Победа», Группа «Аэрофлот»']");
    private final SelenideElement infoLink = $("html > body > div > div > header > div > div > div:nth-of-type(1) > div:nth-of-type(1) > a:nth-of-type(1)");
    private final SelenideElement dropdownMenu = $("html > body > div > div > header > div > div > div:nth-of-type(1) > div:nth-of-type(1) > a:nth-of-type(1)");
    private final SelenideElement fromInput = $("html > body > div > div > main > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > form > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > input");
    private final SelenideElement toInput = $("html > body > div > div > main > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > form > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div:nth-of-type(4) > div > div > input");
    private final SelenideElement searchButton = $("button[class='dp-g0u6ma-root-root'] span");
    private final SelenideElement searchError = $(".search-form .error");


    public void verifyPageLoaded() {
        pageTitle.shouldHave(attribute("text",
                ""));
        logo.shouldBe(visible);
    }

    public void hoverInfoLink() {
        infoLink.hover();
    }

    public void verifyDropdownMenu() {
        dropdownMenu.shouldBe(visible)
                .shouldHave(text("Подготовка к полету"))
                .shouldHave(text("Полезная информация"))
                .shouldHave(text("О компании"));
    }

    public void searchFlights(String from, String to) {
        fromInput.setValue(from).pressEnter();
        toInput.setValue(to).pressEnter();
        searchButton.click();
    }

    public void searchFlightsWithoutSelectingAirport(String from, String to) {
        fromInput.setValue(from).pressEnter();
        toInput.setValue(to).pressEnter();
        searchButton.click();
    }

    public void verifyToFieldError() {
        toInput.parent().shouldHave(attribute("data-failed", "true"));
    }

}