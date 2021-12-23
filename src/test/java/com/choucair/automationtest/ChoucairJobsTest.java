package com.choucair.automationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChoucairJobsTest {
	
	private WebDriver driver;
	//created object webDriver
	By whatIsChou = By.linkText("¿Qué es ser Choucair?");
	By whatIsChouPage = By.id("ser");
	By beChourIs = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/elementor/thumbs/empleosazulMesa-de-trabajo-1-nzblzb24p786w77efm7z2wa94jtit8h8jglrtfqm08.png']");
	
	By preparateToApplication = By.linkText("Prepararse para aplicar");
	By preparateToApplicacionPage = By.id("prepararse");
	By preparateSoftwareModelQuality = By.linkText("Modelo de calidad de software");
	By preparateDifferencesQualityTester = By.linkText("Diferencia entre calidad de software y pruebas");
	By preparateRolEngineer = By.linkText("Papel de los ingenieros");
	By preparateSoftwareAtEconomy = By.linkText("El software en la economía actual");
	By preparateSoftwareMistake = By.linkText("Los errores del software");
	By preparateSoftwareQuality = By.linkText("Calidad de software");
	
	By vacancy = By.linkText("Ir al portal de empleos");
	By vacancyContinue = By.linkText("Continuar");
	By vacancyMagneto = By.xpath("//a[@href='https://www.magneto365.com/choucair']");
	//Annotation JUnit
	@Before
	public void setUp() throws Exception {
		//this method use Chrome driver 
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}
	
	//close the navegator after test
	@After
	public void tearDown() throws Exception {
		driver.quit();
		}
	
	@Test
	public void testChoucairBe() throws InterruptedException {
			driver.findElement(whatIsChou).click();
			//Time of wait to upload page
			Thread.sleep(2000);
			if(driver.findElement(whatIsChouPage).isDisplayed()) {
				driver.findElement(beChourIs);
			}
			else {
				System.out.print("The page was not found");
			}
			
		}
	@Test
	public void testChoucairPreparateApplication() throws InterruptedException {
		driver.findElement(preparateToApplication).click();
		//Time of wait to upload page
		Thread.sleep(2000);
		if(driver.findElement(preparateToApplicacionPage).isDisplayed()) {
			driver.findElement(preparateSoftwareModelQuality).click();
			driver.findElement(preparateDifferencesQualityTester).click();
			driver.findElement(preparateRolEngineer).click();
			driver.findElement(preparateSoftwareAtEconomy).click();
			driver.findElement(preparateSoftwareMistake).click();
			driver.findElement(preparateSoftwareQuality).click();
		}
		else {
			System.out.print("The page of study was not found");
			
		}
		
	}
	
	@Test
	public void testChoucairApplicationVacancy() throws InterruptedException {
		driver.findElement(vacancy).click();
		//Time of wait to upload page
		Thread.sleep(2000);
		if(driver.findElement(vacancy).isDisplayed()){
			driver.findElement(vacancyContinue).isDisplayed();
			Thread.sleep(2000);
			assertTrue(driver.findElement(vacancyMagneto).isDisplayed());
			}
		else {
			System.out.print("The page of study was not found");	
			}
	}
}
