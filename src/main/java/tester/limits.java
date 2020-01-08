package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class limits {
    public static void Navigate_to_Limits(WebDriver adriver) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(testingVariablesPile.getHost() + "#!limits-admin");
        wait.until(presenceOfElementLocated(By.id("limits_list")));
    }

    public static void take_screenshot_limits(WebDriver adriver){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\screenshots\\"+ testingVariablesPile.getWebbrowser() +"_Limits.jpg"));
        }
        catch (IOException e){

        }}

        static public void uploadTestLimits(WebDriver adriver) {
            adriver.manage().window().setPosition(new Point(-1000, 0));
            adriver.manage().window().maximize();
            adriver.navigate().to(testingVariablesPile.getHost() + "#!limits-admin");
            WebDriverWait wait = new WebDriverWait(adriver, 10);
            wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div[2]/div/div[2]/div/span")));
            adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div[2]/div/div[2]/div/span")).click();
            adriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/span[4]/span")).click();

            wait.until(presenceOfElementLocated(By.id("selectFileButton")));

            WebElement e = adriver.findElement(By.id("selectFileButton"));
            e.click();

            try {
                Runtime.getRuntime().exec("C:\\Tests\\FileUpload3.exe");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e = adriver.findElement(By.id("importButton"));
            wait.until(ExpectedConditions.textToBePresentInElement(adriver.findElement(By.id("processResult")), "Data successfully processed and ready to import"));
            e.click();

        }
}
