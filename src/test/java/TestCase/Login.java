package TestCase;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login {
	
	//找到浏览器
	@BeforeSuite
	public void OpenBrowser(){
			//System.setProperty("webdriver.firefox.bin", "C://Program Files//firefox53//firefox.exe");
			//System.setProperty("webdriver.geckodriver.driver", "F://geckodriver//geckodriver.exe");			
		System.setProperty("webdriver.chrome.bin", "C://Users//Administrator//AppData//Local//Google//Chrome//Application//chrome.exe");			
	}	
	
	//实现登录
	@Test(groups="Login")
	public void login() throws InterruptedException, IOException{
		Share sha = Share.getInstance();		
		try {
			sha.inputUrl("http://120.76.156.35:2016/html/login.html?code=zjyx");
			//sha.inputUrl("http://elifepay-web-dashboard-1256068900.cos.ap-chengdu.myqcloud.com/login.html");
			sha.thread(1200);
			sha.Driver.findElement(By.name("account")).sendKeys("18520042490");
			sha.thread(1200);
			sha.Driver.findElement(By.name("password")).sendKeys("Zq940826");
			sha.thread(3000);
			sha.Driver.findElement(By.name("captcha"));
			sha.thread(3000);
			sha.xpathClick("//*[@id='signInForm']/button");			
			sha.maxSize();							
			//Assert.assertEquals(sha.xpathGetText("//*[@id='changeName']"), "欢迎使用浙江云销管理平台");
			//Assert.assertEquals(sha.Driver.findElement(By.className("btn btn-primary block full-width m-b")).getText(), "登录");				
			//s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary success')]")).click();			
			System.out.println("登录成功！");
			sha.implicitlyWait(10);							
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);	
			sha.ScreenShot();
			e.printStackTrace();
		}		
	}
	
	/*//测试登陆
	public static void main(String[] args) {		
		Share sha = Share.getInstance();		
		sha.inputUrl("https://www.baidu.com/");
	}*/
}
