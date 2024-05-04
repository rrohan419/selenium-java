package com.mb.seleniumpoc.controller;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("selenium/test")
public class Test {

    @GetMapping("/1")
    public String getTitle(@RequestParam String url){

        //calss name db_B has text Images (google.com)

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // WebElement webElement = driver.findElement(By.className("db_B"));
        
        // return webElement.getText();

        return driver.getTitle();
    }

    @GetMapping("/2")
    public void searchTextOnGoogle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.navigate().to("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("APjFqb")).sendKeys("NetFlix");
        driver.findElement(By.name("btnK")).click();
    }

    @GetMapping("/login/startupos")    
    public void loginToStartupOsDevAccount(@RequestParam String email, @RequestParam String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.navigate().to("https://app.dev.startupos.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.className("css-q7xv1b")).click();

    }

    @GetMapping("/login/gmail")
    public void loginToGmail(@RequestParam String email, @RequestParam String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.navigate().to("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=ASKXGp1hJwg3qKpgpNp-zfAY0XHFR34JEuJel1Tp0oiNdQ27KayZDanlX-p0hrY4z5KkGyefJj1Pvw&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-905708982%3A1704545997485101&theme=glif");
        driver.findElement(By.id("identifierId")).sendKeys(email);
        driver.findElement(By.className("VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b")).click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // driver.findElement(By.name("password")).sendKeys(password);
        // driver.findElement(By.className("VfPpkd-RLmnJb")).click();
    }

    @GetMapping("/login/aws")
    public void loginToAws(@RequestParam Boolean isRoot, @RequestParam String userName, @RequestParam String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://console.aws.amazon.com");
        if(isRoot) {
            driver.findElement(By.id("aws-signin-general-user-selection-root")).click();
            
        } else{
            driver.findElement(By.id("aws-signin-general-user-selection-iam")).click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.id("resolving_input")).sendKeys("rrohan419@gmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.id("next_button")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("signin_button")).click();

    }
    
}
