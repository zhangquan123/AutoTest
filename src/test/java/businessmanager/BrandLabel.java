package businessmanager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import TestCase.Share;

public class BrandLabel {
	//商品标签管理
	@Test(groups="BrandLabel")
	public void ShoppingManager() throws IOException{
		Share s = Share.getInstance();
		try {
			s.xpathClick("//*[@id='side-menu']/li[5]/ul/li[1]/ul[4]/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//创建标签、标签名、确认、保存成功
			s.xpathClick("//*[@id='addTagBtn']");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "测试标签名");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[3]/div/button[1]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(1200);
			//编辑、放弃、删除、确定删除
			/*s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary edit')]"));
			s.thread(1500);
			System.out.println("11111111111111111111111");
			s.Driver.findElement(By.xpath("//button[contains(@class,'cancelEdit')]"));
			//s.xpathClick("//*[@id='cancelEdit']");
			s.thread(1500);*/
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger remove')]"));
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");		
			System.out.println("222222222222222222");
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
