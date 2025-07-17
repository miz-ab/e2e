package com.erm_e2e.crm_e2e.hooks;

import com.erm_e2e.crm_e2e.BrowserManager;
import com.erm_e2e.crm_e2e.util.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.cucumber.java.Status.FAILED;
import static io.cucumber.java.Status.SKIPPED;

@Slf4j
public class WebHooks {
    private final List<Status> failedStatus = List.of(FAILED, SKIPPED);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss.SSSS");

    @Autowired
    private BrowserManager browserManager;

    @Before
    public void beforeScenario() {
        log.info("Starting a new scenario, creating a new browser page and opening the landing page.");
        browserManager.createNewPage();
        browserManager.openLandingspagina();
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (failedStatus.contains(scenario.getStatus())) {
                byte[] screenshot = browserManager.getPage().screenshot();
                String filename = String.format("%s.png", LocalDateTime.now().format(formatter));
                scenario.attach(screenshot, "image/png", filename);
                ScreenshotUtil.saveScreenshot(filename, browserManager.getPage().screenshot());
            }
        } catch (Exception e) {
            log.error("An exception occurred when trying to create screenshots", e);
        }

        browserManager.closePage();
    }
}
