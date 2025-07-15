package com.erm_e2e.crm_e2e.pages;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Page;

public class LandingPage extends BasePage implements CrmPage {

    public  LandingPage(Page page){
        super(page);
    }
    @Override
    public void isPageVisible() {

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
