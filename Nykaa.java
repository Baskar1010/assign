package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class Nykaa {
 public static void main(String[] args) throws InterruptedException {
	
	 ChromeDriver driver = new ChromeDriver();
	 
	 driver.get("https://www.nykaa.com/");
	 
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	 WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	 
	 Actions actions = new Actions(driver);
	 
	 actions.moveToElement(brands).perform();
	 
	 driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
	 
	 driver.findElement(By.linkText("L'Oreal Paris")).click();
	 
	 String title = driver.getTitle();
	 
	 System.out.println(title);
	 
	  WebElement sort = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
	  
	  sort.click();
	 
	 WebElement customer = driver.findElement(By.xpath("//span[text()='customer top rated']"));
	 
	 customer.click();
	 
	 WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
	 
	 category.click();
	 
	 WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
	 
	 hair.click();
	 
	 
	 WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
	 
	 hairCare.click();
	 
	 WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
	 
	 shampoo.click();
	 
	 WebElement concern = driver.findElement(By.xpath("//span[text()='Concern']"));
	 
	 concern.click();
	 
	 WebElement colorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
	 
	 colorProtection.click();
	 
	 WebElement filtersApplied = driver.findElement(By.xpath("//span[text()='Filters Applied']"));
	 
	 String text = filtersApplied.getText();
	 
	 System.out.println(text);
	 
	 Thread.sleep(7000);
	 
	 driver.findElement(By.xpath("//span[text()='MRP:']")).click();
	 
	 Set<String> windowHandles = driver.getWindowHandles();
	 
	 List<String> windowHandle1=new ArrayList<String>(windowHandles);
		
	 driver.switchTo().window(windowHandle1.get(1));
	 
	 WebElement mL = driver.findElement(By.xpath("//span[text()='180ml']"));
	 
	 mL.click();
	 
	 WebElement mrp = driver.findElement(By.xpath("//span[@class='css-1jczs19']"));
	 
	 String text2 = mrp.getText().replaceAll("[^0-9]", "");
	 
	 System.out.println("mrp: "+text2);
	 
	 WebElement add = driver.findElement(By.xpath("//span[text()='Add to Bag']"));
	 
	 add.click();
	 
	 WebElement shop = driver.findElement(By.xpath("//button[@class='css-g4vs13']"));
	 
	 shop.click();
	 
	 driver.switchTo().frame(0);
	 
	 WebElement total = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']"));
	 
	 String text3 = total.getText().replaceAll("[^0-9]", "");
	 
	 System.out.println(text3);
	 
	 Thread.sleep(4000);
	 
	 WebElement proceed = driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]"));
	 
	 proceed.click();
	 
	 
	 WebElement guest = driver.findElement(By.xpath("//button[text()='Continue as guest']"));
	 
	 guest.click();
	 
	 WebElement close=driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']"));
	
	 close.click();
	 	
	 WebElement priceDetail=driver.findElement(By.xpath("(//span[@class='css-1b232xc ehes2bo3'])[2]"));
	 
	 priceDetail.click();
	
	 WebElement youPay=driver.findElement(By.xpath("(//p[@class='css-masf0q eka6zu20'])[2]"));
	
	 String text4=youPay.getText().replaceAll("[^0-9]", "");
	
	 System.out.println(text4);
		
		if(text3.equals(text4)) {
		
			System.out.println("the grand total is same");
		}
		
		driver.quit();
}
}
/*1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows*/