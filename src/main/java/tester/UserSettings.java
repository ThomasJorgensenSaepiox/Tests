package tester;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.EnumUtils;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserSettings{
    static Integer i = 1;
    public void Navigate_to_user_settings(WebDriver adriver, TheMasterVariables variables) {
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.navigate().to(variables.getHost() + "#!user-settings");
        wait.until(presenceOfElementLocated(By.id("UserSettings_DateTimeStylePicker")));
    }

    public void take_screenshot_user_settings(WebDriver adriver, ScreenshotVariables variables){
        File screenshot = ((TakesScreenshot)adriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(variables.getScreenSaveLocation()+ variables.getWebBrowser() +"_user_settings.jpg"));
        }
        catch (IOException e){

        }}
public void dateCheck(WebDriver adriver, TheMasterVariables variables){
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.get(variables.getHost()+"#!user-settings");
        wait.until(presenceOfElementLocated(By.id("dateStylePicker")));
        WebElement a= adriver.findElement(By.xpath("//*[@id=\"dateStylePicker\"]/span[2]/label"));
        a.click();
        adriver.navigate().to(variables.getHost()+"#!positions-admin");
        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"dateTo\"]/input")));
    while (adriver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).size() > 0){
        if(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText().length()>6){

            i++;
        }
      else{
          break;
        }
    }
        for(int j=1; j<i; j++){

          if(!EnumUtils.isValidEnumIgnoreCase(MyEnums.months3Letter.class,adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+j+"]/td[1]")).getText().replaceAll(",.*", ""))){
              System.out.println("Test Failure, position admin date formate not correct");

          }


        }

    adriver.get(variables.getHost()+"#!user-settings");
    wait.until(presenceOfElementLocated(By.id("dateStylePicker")));
    a= adriver.findElement(By.xpath("//*[@id=\"dateStylePicker\"]/span[1]/label"));
    a.click();
    adriver.navigate().to(variables.getHost()+"#!positions-admin");
    wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"dateTo\"]/input")));
    while (adriver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).size() > 0){
        if(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText().length()>6){

            i++;
        }
        else{
            break;
        }
    }
    for(int j=1; j<i; j++){

        if(!EnumUtils.isValidEnumIgnoreCase(MyEnums.months.class,adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+j+"]/td[1]")).getText().replaceAll(",.*", ""))){
            System.out.println("Test Failure, position admin date formate not correct");

        }


    }
    adriver.get(variables.getHost()+"#!user-settings");
    wait.until(presenceOfElementLocated(By.id("dateStylePicker")));
    a= adriver.findElement(By.xpath("//*[@id=\"dateStylePicker\"]/span[3]/label"));
    a.click();
    adriver.navigate().to(variables.getHost()+"#!positions-admin");
    wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"dateTo\"]/input")));
    while (adriver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).size() > 0){
        if(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText().length()>6){

            i++;
        }
        else{
            break;
        }
    }
    for(int j=1; j<i; j++){

        if(!(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+j+"]/td[1]")).getText().charAt(4)=='-')){
            System.out.println("Test Failure, position admin date formate not correct");

        }


    }
    adriver.get(variables.getHost()+"#!user-settings");
    wait.until(presenceOfElementLocated(By.id("dateStylePicker")));
    a= adriver.findElement(By.xpath("//*[@id=\"dateStylePicker\"]/span[4]/label"));
    a.click();
    adriver.navigate().to(variables.getHost()+"#!positions-admin");
    wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"dateTo\"]/input")));
    while (adriver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).size() > 0){
        if(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+i+"]/td[1]")).getText().length()>6){

            i++;
        }
        else{
            break;
        }
    }
    for(int j=1; j<i; j++){

        if(!(adriver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div[3]/div[3]/table/tbody/tr["+j+"]/td[1]")).getText().charAt(2)=='-')){
            System.out.println("Test Failure, position admin date formate not correct");

        }


    }
}}