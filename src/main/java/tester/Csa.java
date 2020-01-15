package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.io.File;
import java.io.IOException;



public class Csa {
    public void Navigate_to_csa(WebDriver adriver, TheMasterVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!csa");
        wait.until(presenceOfElementLocated(By.id("csa_list")));
    }

    public void take_screenshot_csa(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser()+"_csa.jpg"));
        }
        catch (IOException e){

        }}
}
