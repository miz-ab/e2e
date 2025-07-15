package com.erm_e2e.crm_e2e.steps;

import com.erm_e2e.crm_e2e.BrowserManager;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.nl.Als;

public class UiSteps {

    private final Page page;

    public UiSteps(BrowserManager browserManager) {
        page = browserManager.getPage();
    }

    @Given("the job opening page is visible")
    public void userStartThePortal() {
        page.navigate("http://localhost:4200/job-openings");
    }

}
