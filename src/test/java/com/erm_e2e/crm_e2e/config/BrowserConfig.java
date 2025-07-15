package com.erm_e2e.crm_e2e.config;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserConfig {

    private boolean runHeadless = false;

    @Value("${server.slow-mo:0}")
    private int slowMo;

    @Value("${server.viewport-width:1024}")
    private int width;

    @Value("${server.viewport-height:768}")
    private int height;

    @Bean
    public BrowserType.LaunchOptions launchOptions() {
        return new BrowserType.LaunchOptions().setHeadless(runHeadless).setSlowMo(slowMo);
    }

    @Bean
    public Browser.NewContextOptions browserContext() {
        return new Browser.NewContextOptions()
                .setViewportSize(width, height);
    }
}
