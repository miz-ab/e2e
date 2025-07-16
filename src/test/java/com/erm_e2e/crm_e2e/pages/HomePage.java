package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends BasePage implements CrmPage {

    public HomePage(Page page){
        super(page);
    }
    @Override
    public void isPageVisible() {
        assertThat(page).hasTitle("Jobmail");
    }

    @Override
    public void clickButton(String label) {

    }

    @Override
    public void clickLinkButton(String label) {

    }

    @Override
    public void checkErrorMessage(String message) {

    }
}
