package com.erm_e2e.crm_e2e.steps;

import com.erm_e2e.crm_e2e.BrowserManager;
import com.erm_e2e.crm_e2e.pages.CompanyPage;
import com.erm_e2e.crm_e2e.pages.HomePage;
import com.erm_e2e.crm_e2e.pages.LoginPage;
import com.erm_e2e.crm_e2e.pages.dialog.CompanyForm;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.erm_e2e.crm_e2e.config.InitData.TEMP_PASSWORD;
import static com.erm_e2e.crm_e2e.config.InitData.TEMP_USERNAME;

public class UiSteps {

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
        iAmOnLoginPage();
        iEnterCorrectUsernameAndPassword(TEMP_USERNAME, TEMP_PASSWORD);
        CompanyPage companyPage = new CompanyPage(page);
        companyPage.redirectToCompanyPage();
        Locator locator = companyPage.getHeadingText("Company List");
        locator.isVisible();
        Locator btn = companyPage.getButton("New Company");
        btn.click();
    }

    @When("i enter {string} and {string} and press create company button")
    public void enterCompanyNameAndemail(String companyName, String email) {
        CompanyForm companyForm = new CompanyForm(page);
        companyForm.fillFormField("name",companyName, "input");
        companyForm.fillFormField("email",email, "input");
        companyForm.fillFormField("phoneNumber","+3199887744", "input");
        companyForm.fillFormField("website","BYD.com", "input");
        companyForm.fillFormField("description","some random description", "textarea");
        Locator btn = companyForm.getCreateCompanyButton();
        btn.click();
    }

    @Then("i am able see newly added Company Name {string} in the table")
    public void iAmAbleToSeeNewlyAddedCompanyInTheTable(String companyName){
        CompanyPage companyPage = new CompanyPage(page);
        companyPage.verifyCompanyInTable(companyName);
    }


}
