package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login {
  //登陆功能	
@BeforeSuite	
 public void loginBeforSuit(){
	//System.setProperty("webdriver.firefox.bin","C://Program Files//firefox53//firefox.exe");
	System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\Administrator\\Desktop\\111\\Maven_Selenium_Jenkins_TestNG\\geckodriver.exe");	
			
	//webdriver.chrome.driver或者webdriver.chrome.bin都可以
	System.setProperty("webdriver.chrome.bin", "C://Users//Administrator//AppData//Local//Google//Chrome//Application//chrome.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");		
 }	
  @Test(groups="Login")
  public void login() throws InterruptedException, IOException {	  
	//登陆
	//Implement   imp = new Implement();
	Implement imp = Implement.getInstance();		
	 
	//正式环境地址		
	//imp.InputURL("http://eliepay-web-dashboard-prod-1256068900.cos.ap-guangzhou.myqcloud.com/login.html");		
	//测试环境地址
	imp.InputURL("http://elifepay-web-dashboard-1256068900.cos.ap-chengdu.myqcloud.com/home.html#productList");
	try {
		//系统名称"微信宽带中心后台管理系统"断言
		Assert.assertEquals("微信宽带中心后台管理系统", imp.xpathGetText("/html/body/section/section[1]/section/section/h6"));
		System.out.println("微信宽带中心后台管理系统"+"\t"+"断言成功");
		
		imp.maxSize();
		
		//输入用户名和密码，此处专门将密码输入错误，造出异常现象
 		imp.xpathTextInput("html/body/section/section[1]/section/section/section/section[1]/input", "18520042490");
 		imp.Thread(1200);
 		imp.xpathTextInput("html/body/section/section[1]/section/section/section/section[2]/input", "Zq940826");
 		imp.Thread(1200);
 		imp.xpathClick("html/body/section/section[1]/section/section/section/section[3]/button"); 		
 		imp.implicitlyWait(10);
 		// 由于密码输入错误，所以无法进入登陆后页面，也就无法进行点击“平台管理”的操作，因此如我们所愿，进入catch分支
 		//imp.xpathClick("html/body/section/section[2]/div/div[2]/div[1]/p/span[1]"); 
 		
	} catch (Exception e) {
		// TODO: 异常时这里自动截图
		System.out.println("======exception reason=======" + e);
		imp.ScreenShot();
		e.printStackTrace();
	}
	
	
	
	
	//截图操作
	//imp.snapshot((TakesScreenshot)imp.chromeDriver,"问题.png");
	
	

	

		
  }
}
