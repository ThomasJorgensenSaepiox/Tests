package tester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

public class Tester {
    private static String targethost = "http://www.localhost:5000/";

    public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/","tj@saepiox.com","pass","chrome","Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"),Optional.of("C:\\Tests\\FileUpload2.exe"),Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"),Optional.of("Bad User"),"C:\\screenshots\\");

        System.out.println();

      try {

       //   GenerateUser.Delete_test_user(driver);
        //
     //   Login.admin(driver);
         // GenerateUser.auser(driver);

       //   Agreement.createagreement(driver);
         //Login.charles(driver);
        // portfolios.uploadTestPortfolios(driver);
       // Positions.uploadTestPositions(driver);
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

