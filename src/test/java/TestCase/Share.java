package TestCase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class Share {
			

	//浏览器驱动	
	public WebDriver Driver = new ChromeDriver();
	//WebDriver Driver = new FirefoxDriver();
	//未避免每次都打开浏览器 ， 所以加权限控制  只能在本类中实例化
	private static Share share = new Share();    
	//返回对象，方便你调用； 静态方法的调用不需要实例化 直接类名.方法名  所以在不同的类中时，不会打开多个浏览器窗口
	public static Share getInstance(){
		return share;			
	}
	
	//支持谷歌和火狐两种浏览器打开地址
	public void inputUrl(String url){
		Driver.get(url);
		//firefoxDriver.get(url);   
	}
	//id定位
	public void idClick(String xpath){
		Driver.findElement(By.id(xpath)).click();
	}
	//selector定位点击
	public void selectorClick(String selector){
		Driver.findElement(By.cssSelector(selector)).click();
	}			
	//selector定位并输入
	public void selectInput(String xpath,String input){
		Driver.findElement(By.cssSelector(input)).sendKeys(input);
	}
	//xpath定位
	public  void xpath(String xpath){
		Driver.findElement(By.xpath(xpath));
	}
	//id定位并输入
	public void idSendkey(String id,String text){
		Driver.findElement(By.id(id)).sendKeys(text);
	}
	//class标签定位
	public void classClick(String xpath){
		Driver.findElement(By.className(xpath)).click();
	}
	//定位并输入
	public void xpathSendKeys(String xpathClick,String text){
		Driver.findElement(By.xpath(xpathClick)).sendKeys(text);
	}	
	//定位并输入
	public void SelectClick(String select,String text){
		Driver.findElement(By.cssSelector(select)).sendKeys(text);
	}	
	//定位并取值
	public  String xpathGetText(String xpath){
		String text = Driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
	//超链接定位
	public void xpathLinkTextClick(String text){
		Driver.findElement(By.linkText(text)).click();
	}
	//模糊定位	driver.findElement(By.xpath("//iframe[contains(@src,'listAssetRegister.jsp')]"))		
	//xpath定位并点击
	public  void xpathClick(String xpath){
		Driver.findElement(By.xpath(xpath)).click();
	}
			
	//定位并双击
	public void xpathDoubleClick(String lx){
		WebElement we = Driver.findElement(By.xpath(lx));
		Actions action = new Actions(Driver);
		action.doubleClick(we).perform();
	}
	//浏览器放大
	public void maxSize(){
		Driver.manage().window().maximize();
	}
	//强制等待
	public void thread(long time) throws InterruptedException{
		Thread.sleep(time);
	}
	//隐式等待		
	public void implicitlyWait(long time){
		Driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);	
	}
	//显示等待		
	public void WebDriverWait(String css_locator){
		//设置为15秒，如果15秒内没找到就会抛出异常，设置时间内查找也会等待
		new WebDriverWait(Driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("css_locator")));
	}		
	//鼠标悬浮
	public void actionsCss(String xpath){
		WebElement web = Driver.findElement(By.cssSelector(xpath));
		Actions action = new Actions(Driver);
		action.moveToElement(web).perform();
	}
	//进入iframe
	public void enterIframe(String xpth){
		WebElement wl = Driver.findElement(By.xpath(xpth));
		Driver.switchTo().frame(wl);
	}
	//退出iframe
	public void quitIframe(){
		Driver.switchTo().defaultContent();
	}
	//查看窗口  链接形式
	public void seeWindowhandle(){
		Driver.getCurrentUrl();
	}
	//窗口切换
	public void getwindowhandle(){
		Driver.getWindowHandle();//当前窗口
		for (String handle  : Driver.getWindowHandles()) {
			Driver.switchTo().window(handle);//遍历所有窗口
		}
		Driver.switchTo().window(Driver.getWindowHandle());//所有窗口中拿出当前窗口
	}		
	
	//滚动条滚动到最下方
	public void scolleButton(){
		 ((JavascriptExecutor)Driver).executeScript("window.scrollTo(0,10000);");
	}
	//滚动条滚动到最上方
	public void scolleTop(){
		 ((JavascriptExecutor)Driver).executeScript("window.scrollTo(0,0);");
	}
	//左右滚动条向右
	public void scolleRight(){
		 ((JavascriptExecutor)Driver).executeScript("window.scrollLeft=10000;");
	}
	//刷新
	public void refresh(){
		Driver.navigate().refresh();
	}
	
	//图片上传
	public void uploadFile(String xpath,String url){
		WebElement adFileUpload = Driver.findElement(By.xpath(xpath));				
		String filePath = url; //D:\\iphone11金色.png
		adFileUpload.sendKeys(filePath);			
	}
	
	//滚动条向右
	public void scrollRight(){
		Actions action = new Actions(Driver);
		//action.sendKeys(Keys.TAB). sendKeys(Keys.NULL);//模拟按下TAB 键
		action.sendKeys(Keys.RIGHT). sendKeys(Keys.NULL);		
	}
	
	//滚动条向下
	public void scrollDown(){
		Actions action = new Actions(Driver);
			//action.sendKeys(Keys.TAB). sendKeys(Keys.NULL);//模拟按下TAB 键
		action.sendKeys(Keys.DOWN). sendKeys(Keys.NULL);		
	}
	//普通 <select><option></option></select>下拉框定位方法
	public void pullDown(String xpath,String text){
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(Driver.findElement(By.xpath(xpath))) ;
		//select.selectByIndex(2);//根据索引定位   0为起始下标
		//select.selectByValue("");  //根据下拉框中value定位
		select.selectByVisibleText(text);  //根据文本内容
	}
	//发生异常时自动截图保存
	public void ScreenShot() throws IOException{
		//图片名称加时间戳
 		String dateString = getDateFormat();
 		
 		// getScreenshotAs()对当前窗口进行截图
 		File srcFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
 		// 需要指定图片的保存路径及文件名
 		FileUtils.copyFile(srcFile, new File("d:\\selenium\\" + dateString + ".png"));	 		
	}
	private String getDateFormat() {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String dateString = sdf.format(date);
		return dateString;		
	}
	
	//最后关闭浏览器
	@AfterSuite
	public void closeBroswer(){
		Driver.close();
	}
	
}
