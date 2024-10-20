package com.example.jetbrainstest.pages;

// https://www.jetbrains.com/rider/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RiderPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='rider-download-button__wrapper']//a[@href='/rider/download/']")
    public WebElement secondButtonDownloadRider;

    @FindBy(xpath = "//div//a[@href='/']")
    public WebElement mainPageButton;

    @FindBy(xpath = "//div//a[contains(@href, '/docker-dotnet/')]")
    public WebElement dockerButton;

    @FindBy(xpath = "//a[contains(@class, 'menu-item')]//span[contains(text(), 'Pricing')]")
    public WebElement pricingButton;

    public Boolean checkIfMainPageButtonIsClickable(){
        System.out.println("Кнопка перехода на главную страницу активна");
        return mainPageButton.isEnabled();
    }

    public void downloadSecondButtonClick(){
        System.out.println("Средняя кнопка Download кликабельна");
        secondButtonDownloadRider.click();
    }

    public void dockerButtonClick(){
        System.out.println("Кнопка Docker кликабельна");
        dockerButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        System.out.println("Переключились на новую вкладку с Docker.");
    }

    public void pricingButtonClick(){
        System.out.println();
        pricingButton.click();
    }

    public RiderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }









}
