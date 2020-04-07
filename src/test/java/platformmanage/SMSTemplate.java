package platformmanage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class SMSTemplate {
	//短信模板
	@Test(groups="SMSTemplate")
	public void DuanXinMuBan() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入短信模板审核
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[1]/a/span[1]");						
			s.thread(1500);	
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[6]/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1500);
			//审核成功、取消审核  模糊定位			
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary success')]")).click();
			//s.classClick("btn btn-primary success");			
			s.thread(1500);
			s.xpathClick("/html/body/div[4]/div[7]/button[1]");
			s.thread(1500);
			//审核失败、审核失败理由、取消
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger failed')]")).click();;
			//s.classClick("btn btn-danger failed");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='reason']", "测试审核失败！");
			s.thread(1200);
			s.xpathClick("//*[@id='cannel']");
			s.thread(1200);
			//输入、搜索、清空条件
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input", "小白受理");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "短信模板审核");
			System.out.println("短信模板审核测试通过！");
			s.quitIframe();
			s.thread(2500);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);
			s.ScreenShot();
			e.printStackTrace();
		}
	}
}
