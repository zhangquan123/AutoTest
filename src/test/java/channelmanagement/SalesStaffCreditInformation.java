package channelmanagement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class SalesStaffCreditInformation {
	//销售员积分信息
	@Test(groups="SalesStaffCreditInformation")
	public void XiaoShouJiFen() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入销售人员列表
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[4]/ul[4]/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			//关键字、搜索 、重置
			s.thread(1200);
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input", "15968846988");
			s.thread(1000);
			s.xpathClick("//*[@id='search']");
			s.thread(1000);
			s.xpathClick("//*[@id='reset']");
			//修改、清空并输入价值分、打钩
			s.thread(1000);
			s.xpathClick("//*[@id='tbSaler']/tbody/tr[1]/td[6]/p/span[1]");
			s.thread(1000);
			s.Driver.findElement(By.xpath("//*[@id='tbSaler']/tbody/tr[1]/td[6]/div/input")).clear();
			s.thread(1000);
			s.Driver.findElement(By.xpath("//*[@id='tbSaler']/tbody/tr[1]/td[6]/div/input")).sendKeys("12");
			s.thread(1000);
			s.xpathClick("//*[@id='tbSaler']/tbody/tr[1]/td[6]/div/p/span[1]");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "销售员积分信息");
			System.out.println("销售人员积分信息测试通过");
			s.quitIframe();
			s.thread(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);	
			s.ScreenShot();
			e.printStackTrace();
		}
	}
}
