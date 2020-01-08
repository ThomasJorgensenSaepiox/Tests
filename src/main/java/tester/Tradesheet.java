package tester;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Tradesheet {
public static void Navigate_to_Tradesheet(WebDriver adriver) {
    WebDriverWait wait = new WebDriverWait(adriver, 10);
    adriver.navigate().to(testingVariablesPile.getHost() + "#!trade-sheet");
    wait.until(presenceOfElementLocated(By.id("tradesheet")));
}

public static void take_screenshot_tradesheet(WebDriver adriver){
    File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("C:\\screenshots\\"+ testingVariablesPile.getWebbrowser() +"_tradesheet.jpg"));
    }
    catch (IOException e){

    }

}
}
