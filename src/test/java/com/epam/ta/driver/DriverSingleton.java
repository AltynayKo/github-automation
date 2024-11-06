package com.epam.ta.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class DriverSingleton {
    private static final String RESOURCES_PATH = "firefox";
    private static WebDriver driver;
    private DriverSingleton(){}
        public static WebDriver getDriver(){
            if (driver==null){
                switch (System.getProperty("browser")){
                    case "firefox": { driver = new FirefoxDriver(); break;}
                    case "edge": {driver = new EdgeDriver(); break;}
                    default: {driver = new ChromeDriver(); break;}
                }
                driver.manage().window().maximize();
            }
            return driver;
        }
        public static void closeDriver(){
            driver.quit();
            driver=null;
        }
}
