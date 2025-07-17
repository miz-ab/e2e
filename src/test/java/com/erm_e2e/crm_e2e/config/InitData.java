package com.erm_e2e.crm_e2e.config;

public interface InitData {
    int VIEWPORT_WIDTH = 1080;
    int VIEWPORT_HEIGHT = 740;
    int SLOW_MO = 1000;
    boolean HEADLESS_MODE = false;

    String BASE_URL = "http://localhost:4200";
    String COMPANY_URL = BASE_URL + "/company";
    String TEMP_USERNAME = "crm_admin";
    String TEMP_PASSWORD = "12345";
}
