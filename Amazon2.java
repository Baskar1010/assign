package practice;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon2 {
 public static void main(String[] args) {
	
	 ChromeDriver driver = new  ChromeDriver();
	 
     driver.get("https://www.amazon.in/");
	 
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
	 
	 WebElement firstPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
	 
	 String price = firstPrice.getText().replaceAll("[^0-9]", "");
	 
	 System.out.println(price);
	 
	 WebElement ratings = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']"));
	 
	 String text = ratings.getText();
	 
	 System.out.println(text);
	 
	 WebElement mobile = driver.findElement(By.xpath("//div[@class='aok-relative']"));
	 
	 mobile.click();
	 
	 Set<String> windowHandles = driver.getWindowHandles();
	 
	 List<String> windowHandle1=new ArrayList<String>(windowHandles);
	 
	 driver.switchTo().window(windowHandle1.get(1));
	 
	// File source = driver.getScreenshotAs(OutputType.FILE);
     
    // File destination =new File("./snap/001png");
     
    // FileUtils.copy(source, destination);
	 
	 WebElement cart = driver.findElement(By.id("add-to-cart-button"));
	 
	 cart.click();
	 
	 WebElement subTotal = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
	 
	 String text2 = subTotal.getText().replaceAll("[^0-9]", "");
	 
	 System.out.println(text2);
	 
	 if(price.equals(text2)) {
		 
		 System.out.println("verified");
	 }
	 else {
		 System.out.println("not verified");
	 }
}
}
 /* 1.Load the URL https://www.amazon.in/
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Click the first text link of the first image
6. Take a screen shot of the product displayed
7. Click 'Add to Cart' button
8. Get the cart subtotal and verify if it is correct.
9.close the browser */