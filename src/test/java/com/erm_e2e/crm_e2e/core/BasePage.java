package com.erm_e2e.crm_e2e.core;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage implements CrmPage {
    public Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public Locator getLinkButton(String label) {
        return page.locator("a, button, input, span").filter(new Locator.FilterOptions().setHasText(label));
    }
    public void fillInputByLabel(String labelText, String value) {
        page.getByLabel(labelText).fill(value);
    }

    public Locator getButton(String text) {
        return  page.locator(String.format("button:has-text('%s'), a:has-text('%s')", text, text))
                .first();
    }

    @Override
    public void isPageVisible() {
        // gets overridden in the actual Page
    }

    public Locator logoutButton() {
        Locator locator = page.locator("a").filter(new Locator.FilterOptions()
                .setHasText("Uitloggen"));
        return locator;
    }

    @Override
    public void clickButton(String label) {
        Locator button = getButton(label);
        assertThat(button).isVisible();
        button.click();
    }

    @Override
    public void clickLinkButton(String label) {
        Locator button = getLinkButton(label);
        assertThat(button).isVisible();
        button.click();
    }

    @Override
    public void checkErrorMessage(String errorMessage) {
        Locator alert = page.getByRole(AriaRole.ALERT);
        assertThat(alert).containsText(errorMessage);
    }

    public void selectOption(String label) {
        Locator option = page.getByLabel(label);
        option.setChecked(true);
    }

    public void selectedOptionHasText(String label) {
        Locator selectedOption = page.locator("input[type=\"radio\"]:checked");
        Locator optionWrapper = page.locator(".radio-option").filter(new Locator.FilterOptions().setHas(selectedOption));
        assertThat(optionWrapper).containsText(label);
    }

    public void pageHasChanged(String oldUrl) {
        assertThat(page).not().hasURL(oldUrl);
    }
}
