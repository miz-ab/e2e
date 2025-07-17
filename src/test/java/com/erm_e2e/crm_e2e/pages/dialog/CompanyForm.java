package com.erm_e2e.crm_e2e.pages.dialog;

import com.erm_e2e.crm_e2e.core.BasePage;
import com.erm_e2e.crm_e2e.core.CrmPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class CompanyForm extends BasePage implements CrmPage {
    public CompanyForm(Page page) {
        super(page);
    }

    public void fillFormField(String fieldName, String value, String inputType) {
        page.locator("p-dialog")
                .locator(String.format("%s[formControlName='%s']", inputType, fieldName))
                .fill(value);
    }

    public Locator getCreateCompanyButton() {
        return page.locator("p-button")
                .filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile("Create Company|Saving...")))
                .first()
                .locator("button");
    }

}
