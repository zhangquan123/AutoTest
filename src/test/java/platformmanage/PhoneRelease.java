package platformmanage;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestCase.Share;

public class PhoneRelease {
	//号码释放管理
	@Test(groups="PhoneRelease")
	public void QiYeGuanXiGuanLi() throws IOException{
		Share s = Share.getInstance();
		try {
			//号码释放管理					
			//s.xpathClick("///*[@id='side-menu']/li[3]/ul/li[8]/a/span[1]");
			/*for(int i=0;i<10;i++){
				s.Driver.findElement(By.className("slimScrollBar")).sendKeys(Keys.DOWN);
				//s.Driver.findElement(By.xpath("//*[@id='wrapper']/nav/div/div[2]")).sendKeys(Keys.DOWN);				
			}*/						
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[12]/a");
			s.thread(1200);
			s.enterIframe("//*[@id='iframeMain']");						
			//输入、搜索
			s.xpathSendKeys("//*[@id='queryForm']/div/div/input", "135100");
			s.thread(1000);
			s.xpathClick("//*[@id='search']");
			s.thread(1000);
			//释放、释放理由、取消、
			s.xpathClick("//*[@id='tbphone']/tbody/tr[2]/td[8]/button");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='reason']", "测试释放");
			s.thread(1000);
			s.idClick("cancelChange");
			//s.xpathClick("//*[@id='tbphone']/tbody/tr[2]/td[8]/button");			
			s.thread(1200);
			//全选、批量释放、释放操作、释放理由、取消			
			s.xpathClick("//*[@id='selectAll']");			
			s.thread(1000);
			s.xpathClick("//*[@id='batch']");
			s.thread(1000);
			s.pullDown("//*[@id='action']", "释放删除");
			s.thread(1000);
			s.xpathSendKeys("//*[@id='reason']", "批量释放");
			s.thread(1000);
			s.xpathClick("//*[@id='cancelChange']");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "号码释放管理");
			System.out.println("号码释放成功！");
			s.quitIframe();
			s.thread(1200);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);			
			s.ScreenShot();
			e.printStackTrace();
		}
	}
}
