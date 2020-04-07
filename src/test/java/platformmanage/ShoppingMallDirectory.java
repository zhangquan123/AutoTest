package platformmanage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class ShoppingMallDirectory {
	//商城目录管理
	@Test(groups="ShoppingMallDirectory")
	public void ShangChenMuLu() throws IOException{
		Share s = Share.getInstance();
		try {
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[14]/a");
			s.thread(1500);
			s.enterIframe("//*[@id='iframeMain']");
			//创建目录、目录名称、用户侧目录名称、确认保存
			s.xpathClick("//*[@id='addClass']");			
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "selenium测试");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='aliasName']", "77777777777");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='code']", "GPGP");
			s.thread(1200);
			s.xpathClick("//*[@id='saveClass']");
			s.thread(2000);
			//修改、修改目录、侧目录、确定保存
			//s.classClick("btn btn-primary modifyItem");					
			s.xpathClick("//*[@id='tbClass']/tbody/tr[1]/td[7]/button[1]");
			s.thread(1000);
			s.xpathSendKeys("//*[@id='name']", "selenium测试7777");
			s.thread(1000);
			s.xpathSendKeys("//*[@id='aliasName']", "8888888888");
			s.thread(1000);
			s.xpathClick("//*[@id='saveClass']");
			s.thread(2000);
			//添加子目录、关闭添加子目录、删除、确定删除						   
			s.xpathClick("//*[@id='tbClass']/tbody/tr[1]/td[7]/button[2]");			
			s.thread(1000);
			s.xpathClick("//*[@id='cancelBox']");
			s.thread(1200);
			s.xpathClick("//*[@id='tbClass']/tbody/tr[1]/td[7]/button[3]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");		
			//关键字输入、搜索、重置
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input","个人产品");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			s.thread(1200);
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "商城目录管理");
			System.out.println("商城目录管理测试成功！");
			s.quitIframe();
			s.thread(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);
			e.printStackTrace();
			s.ScreenShot();
		}
	}
}
