package com.erm_e2e.crm_e2e.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@UtilityClass
public class ScreenshotUtil {
    public static void saveScreenshot(String name, byte[] screenshot) throws IOException {
        Path screenshotFolder = Paths.get("target", "screenshots");
        if(!Files.exists(screenshotFolder)) {
            Files.createDirectory(screenshotFolder);
        }

        Path screenshotPath = screenshotFolder.resolve(name);
        Files.write(screenshotPath, screenshot);
    }
}
