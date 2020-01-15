package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Session {

    public void admin(WebDriver adriver, SessionVariables variables){
        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.get(variables.getHost());
        wait.until(presenceOfElementLocated(By.tagName("html")));
        WebElement a =adriver.findElement(By.tagName("html"));
        adriver.findElement(By.id("login")).sendKeys(variables.getAdminlogin());
        adriver.findElement(By.id("password")).sendKeys(variables.getAdminPass());
        adriver.findElement(By.id("button-submit")).click();
        wait.until(stalenessOf(a));
    }
    public void testUser(WebDriver adriver, userVariables variables) {

        WebDriverWait wait = new WebDriverWait(adriver, 10);
        adriver.get(variables.getHost());
        wait.until(presenceOfElementLocated(By.tagName("html")));
        WebElement a =adriver.findElement(By.tagName("html"));
        adriver.findElement(By.id("login")).sendKeys(variables.getUserName().orElse("bad Client"));
        adriver.findElement(By.id("password")).sendKeys(variables.getPass().orElse("@TerriblePass1"));
        adriver.findElement(By.id("button-submit")).click();
        wait.until(stalenessOf(a));
    }
}
