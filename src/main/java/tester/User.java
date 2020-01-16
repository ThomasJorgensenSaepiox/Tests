package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class User {
       private static WebElement a;
    public void Navigate_to_user(WebDriver adriver, TheMasterVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!user-admin");
        wait.until(presenceOfElementLocated(By.id("UserAdmin_Delete")));
    }

    public void take_screenshot_user(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser() +"_user_admin.jpg"));
        }
        catch (IOException e){

        }}

    public void auser(WebDriver adriver, TheMasterVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        WebElement a = adriver.findElement(By.id("UserAdmin_Form"));
        adriver.findElement(By.id("UserAdmin_Add")).click();
        adriver.findElement(By.id("UserAdmin_Email")).sendKeys(variables.geteMail().orElse("aMail@aMailService.com"));
        adriver.findElement(By.id("UserAdmin_UserName")).sendKeys(variables.getUserName().orElse("Bad Client"));
        adriver.findElement(By.id("UserAdmin_Name")).sendKeys(variables.getTest_User_To_Create());
        adriver.findElement(By.id("UserAdmin_Password")).sendKeys(variables.getPass().orElse("@TerriblePass01") + Keys.TAB + Keys.ARROW_DOWN+ Keys.ENTER + Keys.TAB + variables.getTest_User_To_Create() +Keys.ENTER+Keys.ENTER);
        adriver.findElement(By.id("UserAdmin_Update")).click();
        adriver.findElement(By.id("MainView_Logout")).click();
        wait.until(stalenessOf(a));
        a = adriver.findElement(By.tagName("html"));
        adriver.navigate().to(variables.getHost() + "#!login");
        adriver.findElement(By.id("login")).sendKeys(variables.getUserName().orElse("Bad Client"));
        adriver.findElement(By.id("password")).sendKeys(variables.getPass().orElse("@TerriblePass01"));
        adriver.findElement(By.id("button-submit")).click();
        wait.until(stalenessOf(a));
        adriver.navigate().to(variables.getHost() + "#!dashboard");
        wait.until(presenceOfElementLocated(By.id("ChangePassword_NewPass1t")));
        a = adriver.findElement(By.id("ChangePassword_NewPass1"));
        adriver.findElement(By.id("ChangePassword_NewPass1")).sendKeys(variables.getPass().orElse("@TerriblePass01"));
        adriver.findElement(By.id("ChangePassword_NewPass2")).sendKeys(variables.getPass().orElse("@TerriblePass01")+Keys.ENTER);
        wait.until(stalenessOf(a));
        a = adriver.findElement(By.id("MainView_Logout"));
        a.click();
        wait.until(stalenessOf(a));
        System.out.println(variables.getTest_User_To_Create() + " added to users");
    }
    public void Delete_test_user(WebDriver adriver, TheMasterVariables variables){
        int i = 1;
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!user-admin");
        wait.until(presenceOfElementLocated(By.id("list_of_users")));
        WebElement a = adriver.findElement(By.tagName("html"));
        while(i !=0 ){
            if (adriver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr["+i+"]/td[3]")).size()>0){
                if (adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr["+i+"]/td[3]")).getText().equalsIgnoreCase(variables.getTest_User_To_Create())){
                    adriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/table/tbody/tr["+i+"]/td[3]")).click();
                    adriver.findElement(By.id("delete")).click();
                    System.out.println("User"+ variables.getTest_User_To_Create() + " Righteously Deleted");
                i=0;
                }
                else {
                    i++;
                }

        }
            else{
                i=0;
                System.out.println("Failed to find "+variables.getTest_User_To_Create());
            }}

            adriver.findElement(By.id("logout")).click();
            wait.until(stalenessOf(a));
        }

        }

