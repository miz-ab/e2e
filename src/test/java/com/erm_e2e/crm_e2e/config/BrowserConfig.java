package com.erm_e2e.crm_e2e.config;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.erm_e2e.crm_e2e.config.InitData.*;

@Configuration
public class BrowserConfig {

    @Bean
    public BrowserType.LaunchOptions launchOptions() {
        return new BrowserType.LaunchOptions().setHeadless(HEADLESS_MODE).setSlowMo(SLOW_MO);
    }

    @Bean
    public Browser.NewContextOptions browserContext() {
        return new Browser.NewContextOptions()
                .setViewportSize(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
    }
}
