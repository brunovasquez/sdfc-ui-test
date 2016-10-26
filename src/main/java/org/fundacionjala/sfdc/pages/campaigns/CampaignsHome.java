package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CampaignsHome extends AbstractBasePage {

    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement newButtton;

    @FindBy(className = "hotListElement")
    @CacheLookup
    WebElement allCampaigns;


    //endregion

    public CampaignForm clickNewButton() {
        CommonActions.clickElement(newButtton);
        return new CampaignForm();
    }

    public CampaignDetail goCampaingProfile(String url) {
        driver.navigate().to(url);
        return new CampaignDetail();
    }

    public boolean existCampaign(String campaignName) {
        List<WebElement> campaigns = allCampaigns.findElements(By.className("dataCell"));
        return campaigns.stream().filter(x -> x.equals(campaignName)).findAny().isPresent();

    }

    public MainApp goToHomePage(String homeUrl) {
        driver.navigate().to(homeUrl);
        return new MainApp();
    }
}
