package com.klymchuk.rozetkaProject.core;

import org.openqa.selenium.WebDriver;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
       this.driver = driver;
    }

}
