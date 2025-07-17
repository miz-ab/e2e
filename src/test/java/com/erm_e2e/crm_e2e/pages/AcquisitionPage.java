package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;

import static com.erm_e2e.crm_e2e.config.InitData.ACQUISITION_URL;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j
public class AcquisitionPage extends BasePage implements CrmPage {
    public AcquisitionPage(Page page) {
        super(page);
    }

    public void redirectToAcquisitionPage(){
        page.navigate(ACQUISITION_URL);
    }

    public void selectFirstOption() {
        Locator dialog = page.locator("p-dialog");
        Locator dropdown = dialog.locator("p-select .p-dropdown");
        dropdown.click(new Locator.ClickOptions().setForce(true));
        dialog.locator(".p-dropdown-items .p-dropdown-item").first().click();

    }

    @Override
    public void isPageVisible() {
        Locator locator = getHeadingText("Cold Acquisition");
        assertThat(locator).isVisible();
    }
}
