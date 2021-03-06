package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Accounts.AccountAbstractPage;
import Pages.Accounts.AccountProfile;
import Pages.Accounts.NewAccountPage;
import Pages.Campaigns.CampaignProfile;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.MainApp;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesAbstractPage;
import Pages.Opportunities.OpportunityProfile;
import Pages.TabBar;


/**
 * Created by Ruber Cuellar on 8/31/2015.
 */
public class DeleteOpportunity {

    //region Objects
    private TabBar          tabBar;
    private LookUpWindow    lookUpWindow;
    private LoginPage loginPage;

    private OpportunitiesAbstractPage opportunitiesHome;
    private NewOpportunityForm  newOpportunityForm;
    private OpportunityProfile  opportunityProfile;

    private CampaignsHome   campaignsHome;
    private NewCampaignForm newCampaignForm;
    private CampaignProfile campaignProfile;

    private AccountAbstractPage accountsHome;
    private NewAccountPage newAccountForm;
    private AccountProfile  accountProfile;
    private MainApp mainApp;
    //endregion

    //region values
    private String campaignName;
    private String campaingUrl;

    private String accountUrl;

    private String opportunityName          = "Opp_name1";
    private String type                     = "Existing Customer - Replacement";
    private String leadSource               = "Partner Referral";
    private String amount                   = "100";
    private String nextStep                 = "Conquer the world";
    private String stage                    = "Needs Analysis";
    private String orderNumber              = "00001";
    private String deliveryInstallStatus    = "Yet to begin";
    private String accountName = "RuberAccount";

    //endregion

    @BeforeTest
    public void BeforeTest()
    {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        newAccountForm = accountsHome.clickNewButton();
        accountProfile = newAccountForm
                .setAccountName(accountName)
                .pressSaveBtn();

        accountUrl = accountProfile.getUrl();

        opportunitiesHome = tabBar.clickOnOpportunitiesHome();
        newOpportunityForm = opportunitiesHome.clickNewButton();
        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(true)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)
                .chooseTypeDdl(type)
                .chooseLeadSourceDdl(leadSource)
                .setAmount(amount)
                .setCurrentCloseDate()
                .setNextStep(nextStep)
                .chooseStageDdl(stage)
                .setPrimaryCampaignSource(campaignName)
                .setOrderNumber(orderNumber)
                .chooseDeliveryInstallationStatusDdl(deliveryInstallStatus)
                .pressSaveBtn();

    }

    @Test
    public void CreateOpportunity()
    {
        opportunityProfile.clickDeteleBtn();
        Assert.assertFalse(opportunityProfile.isOpportunityDisplayed(opportunityName), "Product Deleted");
    }

    @AfterTest
    public void afterTest()
    {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountProfile = accountsHome.clickOnAccount(accountName);
        mainApp = accountProfile.deleteAccount();
        mainApp.clickUserButton().clickLogout();
    }

}
