
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AutomationProjectOne {
        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahim\\Downloads\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

            driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");



            String actualTitle = driver.getTitle();
            String expectedTitle = "Welcome to Duotify!";
//        if(actualTitle.equals(expectedTitle)){
//            System.out.println("pass");
//
//        }else{
//            throw new RuntimeException("Test Failed");
//        }

            Assert.assertEquals(actualTitle,expectedTitle);




            driver.findElement(By.id("hideLogin")).click();
            driver.findElement(By.id("username")).sendKeys("JSMITH9");
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Smith");
            driver.findElement(By.id("email")).sendKeys("jsmith9@duotech.io");
            driver.findElement(By.id("email2")).sendKeys("jsmith9@duotech.io");
            driver.findElement(By.id("password")).sendKeys("duojohnsmithtech");
            driver.findElement(By.id("password2")).sendKeys("duojohnsmithtech");
            WebElement fname= driver.findElement(By.id("firstName"));
            WebElement lname= driver.findElement(By.id("lastName"));
            String firstName = fname.getAttribute("value");
            String lastName = lname.getAttribute("value");


            driver.findElement(By.name("registerButton")).click();


            String actualRegisterLink = driver.getCurrentUrl();
            String expectedRegisterLink = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";
            Assert.assertEquals(actualRegisterLink,expectedRegisterLink);

            Thread.sleep(2000);
            driver.findElement(By.id("nameFirstAndLast")).click();
            Thread.sleep(2000);


            String actualname = driver.findElement(By.id("nameFirstAndLast")).getText();
            String expectedName = firstName + " " + lastName;
            Assert.assertEquals(actualname,expectedName);

            Thread.sleep(2000);

            String currentUser = driver.findElement(By.tagName("h1")).getText();
            String expectedUser = firstName + " " + lastName;
            Assert.assertEquals(currentUser,expectedUser);

            driver.findElement(By.id("rafael")).click();
            Thread.sleep(2000);


            String actualLogoutLink = driver.getCurrentUrl();
            String expectedLogoutLink = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";
            Assert.assertEquals(actualLogoutLink,expectedLogoutLink);

            Thread.sleep(2000);

            driver.findElement(By.id("loginUsername")).sendKeys("JSMITH9");
            driver.findElement(By.id("loginPassword")).sendKeys("duojohnsmithtech");
            driver.findElement(By.name("loginButton")).click();

            Thread.sleep(2000);

            String expectedText = "You Might Also Like";
            Assert.assertTrue(driver.getPageSource().contains(expectedText));

            Thread.sleep(2000);

            driver.findElement(By.id("nameFirstAndLast")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("rafael")).click();
            Thread.sleep(2000);

            driver.close();




        }
    }


