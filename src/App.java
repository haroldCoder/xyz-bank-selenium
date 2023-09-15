import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import org.junit.*;

public class App {
    WebDriver driver;
    String buttons[];

    public App(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\koderx\\Desktop\\Nueva carpeta\\banco\\src\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();

        // Abre la página web
        this.driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void Ejecutar(){
        buttons = new String[4];

        buttons[0] = "//button[contains(@class, 'btn btn-primary btn-lg')]";
        buttons[1] = "//button[contains(@class, 'btn btn-default')]";
        buttons[2] = "//button[contains(@class, 'btn btn-lg tab')]";
        buttons[3] = "//button[contains(@class, 'btn btn-default')]";
        // darle tiempo de espera a la pagina

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Encuentra el elemento del botón
        ClickBtn(buttons[0], false, 0);
        List<WebElement> buttonSelect = driver
                .findElements(By.xpath("//option[contains(@class, 'ng-binding ng-scope')]"));
        buttonSelect.get(1).click();

        ClickBtn(buttons[1], false, 0);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ClickBtn(buttons[2], true, 1);

        WebElement inputAmout = driver.findElement(By.cssSelector("input[ng-model='amount']"));
        inputAmout.sendKeys("10");

        ClickBtn(buttons[3], false, 0);
        WebElement spansuccess = this.driver.findElement(By.cssSelector("span[ng-show='message']"));

        System.out.println(spansuccess.isDisplayed());
    }

    public void ClickBtn(String xpath, boolean list, int index){
        if(!list){
            WebElement button = driver.findElement(By.xpath(xpath));
            button.click();
        }
        else{
            List<WebElement> buttonSelect = driver
                .findElements(By.xpath(xpath));
            buttonSelect.get(index).click();
        }
    }

    @Test 
    public void ExisteDeposito(){
        Ejecutar();
        WebElement spansuccess = this.driver.findElement(By.cssSelector("span[ng-show='message']"));;
        Assert.assertTrue(spansuccess.isDisplayed());
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.ExisteDeposito();
    }
}
