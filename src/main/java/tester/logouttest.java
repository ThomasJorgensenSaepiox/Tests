package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logouttest {
    private WebDriver adriver;
    public static void logout(WebDriver bdriver){
        bdriver.findElement(By.id("logout")).click();
        if (bdriver.findElement(By.id("login")).isDisplayed() && bdriver.findElement(By.id("password")).isDisplayed() && bdriver.findElement(By.id("button-submit")).isDisplayed()){
            System.out.println("logout works");
            bdriver.findElement(By.id("login")).sendKeys("tm@saepiox.com");
            bdriver.findElement(By.id("password")).sendKeys("pass");
            bdriver.findElement(By.id("button-submit")).click();
        }
        }

}
