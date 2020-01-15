package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Agreement {

    public void Navigate_to_Agreement(WebDriver adriver, AgreementVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!agreement");
        wait.until(presenceOfElementLocated(By.id("agreement_list")));
    }

    public void take_screenshot_agreement(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation() + variables.getWebBrowser() +"_agreement.jpg"));
        }
        catch (IOException e){

        }}
    public void createagreement(WebDriver adriver, AgreementVariables variables){

            adriver.navigate().to(variables.getHost()+"#!agreement");
            WebDriverWait wait = new WebDriverWait(adriver, 10);
            WebElement name = wait.until(presenceOfElementLocated(By.id("name")));

            if (name.isEnabled()) {
                System.out.println("name field improperly accessible");
            } else {
                System.out.println("Name field locked, as intended");
            }


            adriver.findElement(By.id("add")).click();
            name.sendKeys(variables.getTest_User_To_Create() + Keys.TAB + variables.getagreementType() + Keys.ENTER + Keys.ENTER + Keys.TAB + "DKK" + Keys.ENTER +  Keys.TAB + "3"+Keys.TAB+"5");
            WebElement a = adriver.findElement(By.id("update"));
            a.click();

            adriver.findElement(By.id("search")).sendKeys(variables.getTest_User_To_Create()+Keys.ENTER);
            wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[1]")));
            WebElement acell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[1]"));
            if(acell.getText().equalsIgnoreCase(variables.getTest_User_To_Create())){
                System.out.println("agreement succesfully created");
            }
            else{
                System.out.println("agrement creation failure");
            }

            adriver.findElement(By.id("logout")).click();

            wait.until(stalenessOf(a));
        }






    public void createAndDestroyAgreement(WebDriver adriver, AgreementVariables variables){
            adriver.navigate().to(variables.getHost()+"#!agreement");
            WebDriverWait wait = new WebDriverWait(adriver, 10);
            WebElement name = wait.until(presenceOfElementLocated(By.id("name")));

            if (name.isEnabled()) {
                System.out.println("name field improperly accessible");
            } else {
                System.out.println("Name field locked, as intended");
            }


            adriver.findElement(By.id("add")).click();
            name.sendKeys(variables.getTest_User_To_Create() + Keys.TAB + variables.getagreementType() + Keys.ENTER + Keys.ENTER + Keys.TAB + "DKK" + Keys.ENTER +  Keys.TAB + "3"+Keys.TAB+"5");
            WebElement a = adriver.findElement(By.id("update"));
            a.click();

            adriver.findElement(By.id("search")).sendKeys(variables.getTest_User_To_Create()+Keys.ENTER);
            wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[1]")));
            WebElement acell = adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr[1]/td[1]"));
            if(acell.getText().equalsIgnoreCase(variables.getTest_User_To_Create())){
                System.out.println("agreement succesfully created");
                adriver.findElement(By.id("delete")).click();
                System.out.println("and deleted");
            }
            else{
                System.out.println("agrement creation failure");
            }

            adriver.findElement(By.id("logout")).click();

            wait.until(stalenessOf(a));
        }

    }
