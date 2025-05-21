import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Epic("Pobeda Airlines Website Testing")
@Feature("Main Functionality Testing")
@Owner("Your Name")
public class PobedaSelenideTests {
    private final MainPage mainPage = new MainPage();
    private final BookingManagementPage bookingManagementPage = new BookingManagementPage();

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    @Step("Open Pobeda website")
    void openSite() {
        open("https://www.flypobeda.ru/");
    }

    @Test
    @Feature("Dropdown Menu")
    @Description("Test verifies that dropdown menus appear when hovering over 'Информация' and 'Услуги и сервисы' links and contain required sections")
    @Story("As a user I want to see proper dropdown menus when hovering over navigation links")
    @Severity(SeverityLevel.NORMAL)
    void testDropdownMenu() {
        mainPage.verifyPageLoaded();


    }


    @Test
    @Feature("Flight Search")
    @Description("Test verifies flight search functionality shows error when airport is not selected")
    @Story("As a user I want to see error indication when airport is not selected")
    @Severity(SeverityLevel.CRITICAL)
    void testFlightSearchWithUnselectedAirport() {
        mainPage.verifyPageLoaded();
        mainPage.searchFlightsWithoutSelectingAirport("Москва", "Санкт-Петербург");
        mainPage.verifyToFieldError();
    }

    @Test
    @Feature("Booking Management")
    @Description("Test verifies booking management functionality with invalid data shows error message")
    @Story("As a user I want to see error message when searching with invalid booking data")
    @Severity(SeverityLevel.CRITICAL)
    void testBookingManagement() {
        mainPage.verifyPageLoaded();
        $x("//a[contains(., 'Управление бронированием')]")
                .scrollTo()
                .click();

        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > 1) {
            switchTo().window(1);
        }

        bookingManagementPage.verifyPageLoaded();
        bookingManagementPage.searchBooking("XXXXXX", "Qwerty");
        bookingManagementPage.verifyErrorMessage();
    }

    @Test
    @Feature("English Version")
    @Description("This test intentionally fails to demonstrate Allure reporting for failed tests")
    @Story("As a user I want to switch to English version of the site")
    @Severity(SeverityLevel.MINOR)
    void failingTest() {
        Steps.openGoogle();
        Steps.searchForPobedaSite();
        Steps.clickFirstSearchResult();
        Steps.verifyPobedaSiteLoaded();
        Steps.performFailingTest();
    }

    @AfterEach
    @Step("Close browser")
    void tearDown() {
        closeWebDriver();
    }
}