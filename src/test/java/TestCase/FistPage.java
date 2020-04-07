package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FistPage {
	@Test(groups="FistPage")
	public void shouye() throws IOException{
		Share s = Share.getInstance();		
		try {
			s.enterIframe("//*[@id='iframeMain']");			
			s.xpathClick("//*[@id='m_c']/p");
			s.thread(1500);			
			s.xpathClick("//*[@id='m_c']/ul/li[1]");
			//订单和销售人员
			Assert.assertEquals(s.xpathGetText("//*[@id='graphic']/div[1]/div[1]/p"),"订单");
			Assert.assertEquals(s.xpathGetText("//*[@id='xiaoShou']/p"),"销售人员");
			System.out.println("首页校验成功！");
			s.quitIframe();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("======exception reason=======" + e);	
			s.ScreenShot();
			e.printStackTrace();			
		}
		
	}
}
