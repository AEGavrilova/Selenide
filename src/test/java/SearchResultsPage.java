import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage extends BasePage {
    private final SelenideElement searchResults = $("html > body > div > div > main > div > div > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > form > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(1) > div > div:nth-of-type(1) > div");

    public void verifyResultsDisplayed() {
        searchResults.shouldBe(visible);
    }
}