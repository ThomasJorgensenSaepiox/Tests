package tester;

import java.util.Objects;
import java.util.Optional;

public class TheMasterVariables implements AgreementVariables, userVariables, PositionVariables, PortfolioVariables, ScreenshotVariables{
    private final String webBrowser;
    private final String host;
    private final String adminLogin;
    private final String adminPass;
    private final String userToCreate;
    private final String screenSaveLocation;
    private final String agreementType;
    private final Optional<String> importPortfoliosScript;
    private final Optional<String> importPositionsScript;
    private final Optional<String> eMail;
    private final Optional<String> pass;
    private final Optional<String> userName;
    public TheMasterVariables(String host, String adminLogin, String adminPass, String webBrowser, String userToCreate, String agreementType, Optional<String> importPortfoliosScript,
                              Optional<String> importPositionsScript, Optional<String> eMail, Optional<String> pass, Optional<String> userName, String screenSaveLocation){
        Objects.requireNonNull(webBrowser);
        Objects.requireNonNull(host);
        Objects.requireNonNull(adminLogin);
        Objects.requireNonNull(adminPass);
        this.screenSaveLocation = screenSaveLocation;
        this.userToCreate = userToCreate;
        this.agreementType = agreementType;
        this.webBrowser = webBrowser;
        this.adminLogin= adminLogin;
        this.adminPass = adminPass;
        this.host = host;
        this.importPortfoliosScript = importPortfoliosScript;
        this.importPositionsScript = importPositionsScript;
        this.eMail = eMail;
        this.pass = pass;
        this.userName = userName;
    }


    public String getWebBrowser(){
        return webBrowser;
    }

    public  String getAdminlogin(){
        return adminLogin;
    }

    public  String getAdminPass() {
        return adminPass;
    }
    public String getUserToCreate() {return userToCreate;}

    public String getHost() {
        return host;
    }

    public String getwebBrowser(){return webBrowser;}

    public  Optional<String> getImportPortfoliosScript(){return importPortfoliosScript;}
    public Optional<String> getImportPositionsScript(){return importPositionsScript;}
    @Override
    public Optional<String> geteMail() {
        return eMail;
    }
    @Override
    public String getTest_User_To_Create() {
        return userToCreate;
    }
    @Override
    public Optional<String>getPass() {
        return pass;
    }

    @Override
    public Optional<String> getUserName() {
        return userName;
    }

    @Override
    public String getagreementType() {
        return agreementType;
    }

    @Override
    public String getScreenSaveLocation() {
        return screenSaveLocation;
    }
}
