package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * This class represent to a form to create or edit a opportunity
 */
public class OpportunityForm extends AbstractBasePage {

    // to manage window popup
    private String mainWindowId;
    private Set<String> windows;

    /* Top Button Row */
    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;

    /* Opportunity Information */
    @FindBy(id = "opp2")
    @CacheLookup
    private WebElement privateFlag;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityNameTextBox;

    @FindBy(id = "opp4")
    @CacheLookup
    private WebElement accountNameTextBox;

    @FindBy(xpath = ".//*[@id='opp4_lkwgt']/img")
    @CacheLookup
    private WebElement accountNameLookupIconBtn;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement multiSelectType;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement multiSelectLeadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement amountTextBox;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateTextBox;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    private WebElement todayLink;

    @FindBy(id = "opp10")
    @CacheLookup
    private WebElement nextStepTextBox;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement multiSelectStage;

    @FindBy(id = "opp12")
    @CacheLookup
    private WebElement probabilityTextBox;

    @FindBy(id = "opp17")
    @CacheLookup
    private WebElement primaryCampaignSourceTextBox;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement primaryCampaignSourceLookupIconBtn;

    /* Additional Information */
    // TODO: change it to xpath locator

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::input")
    @CacheLookup
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//td[contains(.,'Delivery')]/following::span/select")
    @CacheLookup
    private WebElement multiSelectDeliveryInstallationStatus;

    /* Description Information */

    @FindBy(id = "opp14")
    @CacheLookup
    private WebElement descriptionTextArea;

    //endregion

    public OpportunityForm() {
        mainWindowId = driver.getWindowHandle();
    }


    /* Set Opportunity Information */
    public OpportunityForm checkPrivateFlag(final boolean flag) {
        if (!privateFlag.isSelected() && flag) {
            privateFlag.click();
        }
        return this;
    }

    public OpportunityForm uncheckPrivateFlag(final boolean flag) {

        if (privateFlag.isSelected() && flag) {
            privateFlag.click();
        }

        return this;
    }

    public OpportunityForm setOpportunityName(final String opportunityName) {
        opportunityNameTextBox.clear();
        opportunityNameTextBox.sendKeys(opportunityName);

        return this;
    }

    public OpportunityForm setAccountName(final String accountName) {
        accountNameTextBox.clear();
        accountNameTextBox.sendKeys(accountName);

        return this;
    }

    public OpportunityForm chooseTypeDdl(final String type) {
        Select selectBox = new Select(multiSelectType);
        selectBox.selectByVisibleText(type);

        return this;
    }

    public OpportunityForm chooseLeadSourceDdl(final String leadSource) {
        Select selectBox = new Select(multiSelectLeadSource);
        selectBox.selectByVisibleText(leadSource);
        return this;
    }

    public OpportunityForm setAmount(final String amount) {
        amountTextBox.clear();
        amountTextBox.sendKeys(amount);
        return this;
    }

    public OpportunityForm setCloseDate(final String closeDate) {
        closeDateTextBox.clear();
        closeDateTextBox.sendKeys(closeDate);
        return this;
    }

    public OpportunityForm setCurrentCloseDate() {
        closeDateTextBox.clear();
        todayLink.click();
        return this;
    }

    public OpportunityForm setNextStep(final String nextStep) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(nextStep);
        return this;
    }

    public OpportunityForm chooseStageDdl(final String stage) {
        Select selectBox = new Select(multiSelectStage);
        selectBox.selectByVisibleText(stage);

        return this;
    }

    public OpportunityForm setProbability(final String probability) {
        nextStepTextBox.clear();
        nextStepTextBox.sendKeys(probability);

        return this;
    }

    public OpportunityForm setPrimaryCampaignSource(final String primaryCampaignSource) {
        primaryCampaignSourceTextBox.clear();
        primaryCampaignSourceTextBox.sendKeys(primaryCampaignSource);

        return this;
    }

    /* Set Additional Information */
    public OpportunityForm setOrderNumber(final String orderNumber) {
        orderNumberTextBox.clear();
        orderNumberTextBox.sendKeys(orderNumber);
        return this;
    }

    /**
     * This method
     * @param deleveryInstallationStatus
     * @return
     */
    public OpportunityForm chooseDeliveryInstallationStatusDdl(final String deleveryInstallationStatus) {
        Select selectBox = new Select(multiSelectDeliveryInstallationStatus);
        selectBox.selectByVisibleText(deleveryInstallationStatus);
        return this;
    }

    /**
     * This method sets a description
     *
     * @param description a string to sets.
     * @return a opportunity form.
     */
    public OpportunityForm setDescription(final String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);
        return this;
    }

    /**
     * This method makes click to save button.
     *
     * @return Opportunity Detail page object.
     */
    public OpportunityDetail pressSaveBtn() {
        saveBtn.click();
        return new OpportunityDetail();
    }

    /**
     * This method makes click on account name.
     *
     * @return LookUpWindow object.
     */
    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.clickElement(accountNameLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method maks click on primary campaingn.
     *
     * @returnLookUpWindow object.
     */
    public LookUpWindow clickPrimaryCampaignSrcLookUpIcon() {
        CommonActions.clickElement(primaryCampaignSourceLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * Method that to permit set values to create a new Opportunity.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, Steps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, Steps> strategyMap = new HashMap();

        strategyMap.put("opportunityName", () -> setOpportunityName(String.valueOf(values.get("opportunityName"))));
        strategyMap.put("type", () -> chooseTypeDdl(String.valueOf(values.get("type"))));
        strategyMap.put("leadSource", () -> chooseLeadSourceDdl(String.valueOf(values.get("leadSource"))));
        strategyMap.put("amount", () -> setAmount(String.valueOf(values.get("amount"))));
        strategyMap.put("nextStep", () -> setNextStep(String.valueOf(values.get("nextStep"))));
        strategyMap.put("stage", () -> chooseStageDdl(String.valueOf(values.get("stage"))));
        strategyMap.put("orderNumber", () -> setOrderNumber(String.valueOf(values.get("orderNumber"))));
        strategyMap.put("deliveryInstallStatus", () -> chooseDeliveryInstallationStatusDdl(String.valueOf(values.get("deliveryInstallStatus"))));
        strategyMap.put("accountName", () -> setAccountName(String.valueOf(values.get("accountName"))));
        strategyMap.put("CurrentCloseDate", () -> setCurrentCloseDate());
        strategyMap.put("PrivateFlag", () -> checkPrivateFlag(Boolean.valueOf(values.get("PrivateFlag"))));

        return strategyMap;
    }


    public void fillValues(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
