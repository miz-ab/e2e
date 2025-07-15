package com.erm_e2e.crm_e2e.core;

import com.microsoft.playwright.Page;

public abstract class BasePage implements CrmPage {
    public Page page;

    public BasePage(Page page) {
        this.page = page;
    }
}
