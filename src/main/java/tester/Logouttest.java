package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logouttest {
    public void logout(WebDriver bdriver, SessionVariables variables){
        bdriver.findElement(By.id("logout")).click();
        if (bdriver.findElement(By.id("login")).isDisplayed() && bdriver.findElement(By.id("password")).isDisplayed() && bdriver.findElement(By.id("button-submit")).isDisplayed()){
            System.out.println("logout works");
            bdriver.findElement(By.id("login")).sendKeys(variables.getAdminlogin());
            bdriver.findElement(By.id("password")).sendKeys(variables.getAdminPass());
            bdriver.findElement(By.id("button-submit")).click();
        }
        }

}
