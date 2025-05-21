import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class BookingManagementPage extends BasePage {
    private final SelenideElement orderNumberInput = $("input[placeholder='Номер бронирования или билета']");
    private final SelenideElement lastNameInput = $("input[placeholder='Фамилия клиента']");
    private final SelenideElement searchButton = $("button[class='dp-1a9gei0-root-root']");
    private final SelenideElement errorMessage = $("div[ng-if='vm.errorMessage']");
    private final SelenideElement privacyPolicyCheckbox = $("div[class='customCheckbox']");
    private final SelenideElement confirmSearchButton = $("button[ng-mouseenter='vm.swithcSubmitButtonHoverState();']");

    @Step("Verify booking management page is loaded")
    public void verifyPageLoaded() {
        orderNumberInput.shouldBe(visible);
        lastNameInput.shouldBe(visible);
        searchButton.shouldBe(visible);
    }

    @Step("Search booking with order number {orderNumber} and last name {lastName}")
    public void searchBooking(String orderNumber, String lastName) {
        orderNumberInput.setValue(orderNumber);
        lastNameInput.setValue(lastName);
        searchButton.click();

        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > 1) {
            switchTo().window(1);
        }

        confirmPrivacyPolicy();
        clickSearchOrderButton();
    }
    @Step("Confirm privacy policy")
    public void confirmPrivacyPolicy() {
        privacyPolicyCheckbox.shouldBe(visible).click();
    }

    @Step("Click search order button")
    public void clickSearchOrderButton() {
        confirmSearchButton.shouldBe(enabled).click();
    }


    @Step("Verify error message is displayed")
    public void verifyErrorMessage() {
        errorMessage.shouldBe(visible);
    }
}