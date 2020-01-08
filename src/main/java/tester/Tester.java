package tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Tester {
    private static String targethost = "http://www.localhost:5000/";

    public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        testingVariablesPile.setAdminPass("pass");
        testingVariablesPile.setAdminlogin("rg@saepiox.com");
        testingVariablesPile.setHost(targethost);

      try {

       //   GenerateUser.Delete_test_user(driver);
        //
        Login.admin(driver);
         // GenerateUser.auser(driver);

          Agreement.createagreement(driver);
         //Login.charles(driver);
        // portfolios.uploadTestPortfolios(driver);
        Positions.uploadTestPositions(driver);
      //UserSettings.dateCheck(driver);
        // FileUtils.copyFile(importTestExcel.parseExcellFormulas(new File("C:\\Tests\\20Positions.xlsx")),new File("C:\\Tests\\20191202 Positions.xlsx"));
        //  Positions.setMypositions(importTestExcel.positionstobeloaded_excell(new File("C:\\Tests\\20191202 Positions.xlsx")));
          //Positions.Test(driver);
// Dashboard.Test(driver);
            // Dashboard.Test(driver);
            //  logouttest.logout(driver);

        //
            // System.out.println(Agreement.testAgreementCreation(driver));
     //       GenerateUser.auser(driver);
         //
          // Login.admin(driver);
  // GenerateUser.Delete_test_user(driver);
      //Login.charles(driver);
  //  Agreement.createAndDestroyAgreement(driver);
      //    importTestExcel.maturityDateUpdatingForTestingDoNotUseOnProductionData(new File("C:\\Users\\exist\\IdeaProjects\\atester\\src\\main\\resources\\20191202 Positions.xlsx"));
   //     Positions.setMypositions(importTestExcel.positionstobeloaded_excell(new File("C:\\Users\\exist\\IdeaProjects\\atester\\src\\main\\resources\\20191202 Positions.xlsx")));
    //  Positions.uploadTestPositions(driver);
        } finally {
           //  driver.quit();
        }
    }
}

