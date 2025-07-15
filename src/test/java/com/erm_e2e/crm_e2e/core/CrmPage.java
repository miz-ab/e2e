package com.erm_e2e.crm_e2e.core;

public interface CrmPage {
    void isPageVisible();
    void clickButton(String label);
    void clickLinkButton(String label);
    void checkErrorMessage(String message);
}
