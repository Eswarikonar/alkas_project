package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String name) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "screenshots/" + name + "_" + timestamp + ".png";

        // Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);

        try {
            FileHandler.copy(src, dest);
            System.out.println("✅ Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }

        return filePath;
    }
}