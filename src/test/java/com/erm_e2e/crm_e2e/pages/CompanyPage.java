package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CompanyPage extends BasePage implements CrmPage {
    public CompanyPage(Page page) {
        super(page);
    }

    @Override
    public void isPageVisible() {
        assertThat(page).hasTitle("Jobmail");
    }

    public void redirectToCompanyPage(){
        page.navigate("http://localhost:4200/company");
    }

}
