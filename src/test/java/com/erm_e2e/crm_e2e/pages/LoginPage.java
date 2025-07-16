package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends BasePage implements CrmPage {

    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public void isPageVisible() {
        assertThat(page).hasTitle("Sign in to crm_realm");
    }

    public void fillPassword(String password){
        page.locator("#password").fill(password);
    }
}
