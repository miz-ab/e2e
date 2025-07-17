package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.erm_e2e.crm_e2e.config.InitData.COMPANY_URL;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyPage extends BasePage implements CrmPage {
    public CompanyPage(Page page) {
        super(page);
    }

    @Override
    public void isPageVisible() {
        assertThat(page).hasTitle("Jobmail");
    }

    public void verifyCompanyInTable(String companyName){
        Locator table = page.locator("p-table");
        table.waitFor();
        Locator row = table.locator("tr:has-text('" + companyName + "')");
        assertTrue(row.locator("td:has-text('" + companyName + "')").first().isVisible());
    }

    public void redirectToCompanyPage(){
        page.navigate(COMPANY_URL);
    }

}
