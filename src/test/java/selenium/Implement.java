package selenium;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterSuite;



	//封装方法
public class Implement {		
				
	//谷歌和火狐驱动	
	WebDriver chromeDriver = new ChromeDriver();	
	
	private static  Implement imp = new Implement();
	
	private Implement(){
	    
	}//这个方法的作用是避免其他的类中出现实例化，私有的只能在本类中使用 其他的类中使用就会报错
	  
	public static  Implement getInstance(){
	    return imp;
	}
	//静态方法的调用不需要实例化,直接类名.方法名() ，所以就不用每个类都去实例化 避免每个类都打开一个浏览器

	//WebDriver firefoxDriver = new FirefoxDriver();		
	
	//输入url
	public void InputURL(String url){
		chromeDriver.get(url);
	}
	
	//强制等待
	public void Thread(long thread) throws InterruptedException {
		Thread.sleep(thread);
	}
	
	//隐式等待
	public void implicitlyWait(long implicitlyWait){
		chromeDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);	
	}
	
	//显示等待
	public void WebDriverWait(String css_locator){
		//设置为15秒，如果15秒内没找到就会抛出异常，设置时间内查找也会等待
		new WebDriverWait(chromeDriver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("css_locator")));
	}
	
	//xpath文本输入框
	public void xpathTextInput(String xpath,String text){
		chromeDriver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	//id定位文本输入框
	public void idTextInput(String xpath,String text){
		chromeDriver.findElement(By.id(xpath)).sendKeys(text);
	}
	
	//xpath定位
	public void xpath(String xpath){
		chromeDriver.findElement(By.xpath(xpath));
	}
	
	//xpath定位并获取值
	public String xpathGetText(String xpath){		
		return chromeDriver.findElement(By.xpath(xpath)).getText();
	}
	
	//定位并点击
	public void xpathClick(String xpath){
		chromeDriver.findElement(By.xpath(xpath)).click();
	}
	
	//selector定位
	public void selector(String selector){
		chromeDriver.findElement(By.cssSelector(selector)).click();;
	}
	
	
	//浏览器最大化
	public void maxSize(){
		chromeDriver.manage().window().maximize();
	}
	
	//进入iframe框架
	public void enterIframe(String xpath){
		WebElement element=chromeDriver.findElement(By.xpath(xpath));
		chromeDriver.switchTo().frame(element);
		
	}
	
	//退出iframe框架
	public void quitIframe(){
		chromeDriver.switchTo().defaultContent();
	}	
	
	//窗口切换
	public void windowChange(){
		chromeDriver.getWindowHandle();
		for(String winHandle : chromeDriver.getWindowHandles()){		    
			chromeDriver.switchTo().window(winHandle);
		       }			
		chromeDriver.switchTo().window(chromeDriver.getWindowHandle());
	}	
	
	 //滚动条滚动到最上方
	 public void scorllTop(){
		 ((JavascriptExecutor)chromeDriver).executeScript("window.scrollTo(0,0);");		 
		 
	 }
	 
	 //滚动条滚动到页面底部
	 public void scorllBotton(){
		 ((JavascriptExecutor)chromeDriver).executeScript("window.scrollTo(0,10000);");
	 }
	
	//浏览器刷新
	public void refresh(){
		chromeDriver.navigate().refresh();
	} 
	
/*	//截屏
	public static void snapshot(TakesScreenshot drivername, String filename){      	     
	      File scrFile =drivername.getScreenshotAs(OutputType.FILE);
	         try {
	            System.out.println("截图保存路径:F:/"+filename);
	             FileUtils.copyFile(scrFile, new File("F:\\"+filename));
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("无法保存截图屏幕");
	            e.printStackTrace();
	         } 
	         finally
	         {
	              System.out.println("屏幕截图已完成");
	         }
	  }	*/
    
    //发生异常时自动截图保存
	public void ScreenShot() throws IOException{
		//图片名称加时间戳
 		String dateString = getDateFormat();
 		
 		// getScreenshotAs()对当前窗口进行截图
 		File srcFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
 		// 需要指定图片的保存路径及文件名
 		FileUtils.copyFile(srcFile, new File("d:\\selenium\\" + dateString + ".png"));
 		
	}
    
    
	private String getDateFormat() {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String dateString = sdf.format(date);
		return dateString;		
	}

	//退出,释放资源
	@AfterSuite
	public void quit(){
		chromeDriver.quit();		
	}
	
}
