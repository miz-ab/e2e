package com.erm_e2e.crm_e2e;

import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BrowserManager implements AutoCloseable{

    private String baseUrl;

    @Getter
    private Page page;
    private final Playwright playwright;
    private final Browser browser;
    private final BrowserContext browserContext;

    public BrowserManager(BrowserType.LaunchOptions launchOptions, Browser.NewContextOptions options) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOptions);
        browserContext = browser.newContext(options);
    }

    public void createNewPage() {
        page = browserContext.newPage();
        setupConsoleLogger();
    }

    private void setupConsoleLogger() {
        page.onConsoleMessage(msg -> {
            if ("error".equals(msg.type())) {
                log.error("Received error in console: {}", msg.text());
            } else {
                log.info("Received console message: {}", msg.text());
            }
        });
    }

    public void closePage() {
        page.close();
    }

    @Override
    public void close() throws Exception {
        closePage();
        browser.close();
        playwright.close();
    }

    public void openLandingspagina() {
        page.navigate(baseUrl);
    }

}
