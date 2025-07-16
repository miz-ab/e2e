package com.erm_e2e.crm_e2e.steps;

import com.erm_e2e.crm_e2e.BrowserManager;
import com.erm_e2e.crm_e2e.pages.CompanyPage;
import com.erm_e2e.crm_e2e.pages.HomePage;
import com.erm_e2e.crm_e2e.pages.LoginPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UiSteps {

    private static final Logger log = LoggerFactory.getLogger(UiSteps.class);
    private final Page page;

    public UiSteps(BrowserManager browserManager) {
        page = browserManager.getPage();
    }

    @Given("i am on login page")
    public void iAmOnLoginPage() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.isPageVisible();
    }

    @When("i enter correct {string} and {string} and sign in")
    public void iEnterCorrectUsernameAndPassword(String username, String password) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.fillInputByLabel("Username or email", username);
        loginPage.fillPassword(password);
        Locator l = loginPage.getButton("Sign In");
        l.click();
    }
    @Then("i am able to see the home page")
    public void iAmAbleToSeeTheHomePage(){
        HomePage homePage = new HomePage(page);
        homePage.isPageVisible();
    }

    @Given("i am in the company page")
    public void iAmInTheCompanyPage(){
        iEnterCorrectUsernameAndPassword("crm_admin", "12345");
        CompanyPage companyPage = new CompanyPage(page);
        companyPage.redirectToCompanyPage();
        companyPage.isPageVisible();

    }


}
