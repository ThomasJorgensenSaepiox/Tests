package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class position_history {
    public static void Navigate_to_position_history(WebDriver adriver) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(testingVariablesPile.getHost() + "#!position-change-view-new");
        wait.until(presenceOfElementLocated(By.id("position_history")));
    }

    public static void take_screenshot_position_history(WebDriver adriver) {
        File screenshot = ((TakesScreenshot) adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\screenshots\\" + testingVariablesPile.getWebbrowser() + "_tradesheet.jpg"));
        } catch (IOException e) {

        }
    }
}
