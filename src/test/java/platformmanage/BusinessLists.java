package platformmanage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class BusinessLists {
	//平台管理-企业列表
	@Test(groups="BusinessLists")
	public void qiyeliebiao() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入企业列表
			s.selectorClick("#side-menu > li:nth-child(3) > a > span.nav-label");							
			s.thread(1000);
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[1]/a/span[1]");
			s.thread(1200);
			s.selectorClick("#side-menu > li.active > ul > li.active > ul:nth-child(2) > li > a");
			s.enterIframe("//*[@id='iframeMain']");
			//企业名称、搜索
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input", "广州宇中");;
			//s.selectInput("#queryForm > div > div:nth-child(1) > input", "广州宇中");
			s.thread(1000);
			s.selectorClick("#search");
			s.thread(2000);
			Assert.assertEquals(s.xpathGetText("//*[@id='queryForm']/div/div[1]/label"), "企业名称");
			System.out.println("企业列表断言成功！");
			s.quitIframe();			
		} catch (Exception e) {
			System.out.println("======exception reason=======" + e);	
			s.ScreenShot();
			e.printStackTrace();
		}
	}
}
