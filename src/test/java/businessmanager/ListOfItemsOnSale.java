package businessmanager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class ListOfItemsOnSale {
//在售商品列表
	@Test(groups="ListOfItemsOnSale")
	public void OnsaleList() throws IOException{
		Share s = Share.getInstance();
		try {
			s.xpathClick("//*[@id='side-menu']/li[5]/ul/li[1]/ul[2]/li/a");
			s.thread(1200);
			s.enterIframe("//*[@id='iframeMain']");
			//关键字查询、商品类型、是否推荐
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input", "20200402测试商品");
			s.thread(1200);
			s.pullDown("//*[@id='queryForm']/div/div[3]/select", "普通产品");
			s.thread(1200);
			s.pullDown("//*[@id='queryForm']/div/div[6]/select", "未推荐");
			s.thread(1200);
			//现价区间，搜索，重置
			s.xpathSendKeys("//*[@id='queryForm']/div/div[7]/input[1]", "0");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='queryForm']/div/div[7]/input[2]", "1");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1000);
			s.xpathClick("//*[@id='reset']");
			//勾选、下架、取消下架、设置推荐、取消推荐
			s.thread(1200);
			s.xpathClick("//*[@id='tbProduct']/tbody/tr[1]/td[1]/div");
			s.thread(1000);			
			s.xpathClick("//*[@id='offShelf']");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[1]");						  
			//s.xpathClick("//*[@id='recommend']");
			s.thread(1000);
			s.xpathClick("//*[@id='recommend']");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[1]");
			s.thread(1200);
			//向右滑动
			s.scolleButton();
			s.thread(1200);
			s.xpathClick("//*[@id='tbProduct']/thead/tr/th[3]");
			s.thread(1200);
			s.scolleRight();
			s.thread(1200);			
			//分发、关闭分发、编辑产品、、
			s.xpathClick("//*[@id='tbProduct']/tbody/tr[1]/td[15]/button[1]");
			s.thread(1200);
			s.xpathClick("//*[@id='distriCancel']");
			s.thread(2000);
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary editProduct dianxinMix')]")).click();
			//s.xpathClick("//*[@id="4ef272ab18e5429caf0a793909f21160"]");
			s.thread(1200);
			//修改产品名称、下一步、下一步、保存并发布、保存成功确定
			s.xpathSendKeys("//*[@id='name']", "777");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[3]/div[1]/div[12]/div/button");							
			s.thread(1000);
			s.xpathClick("//*[@id='form']/div[3]/div[2]/div[12]/div/button[2]");
			s.thread(1200);
			s.xpathClick("//*[@id='saveCan']");
			s.thread(1200);
			s.xpathClick("/html/body/div[6]/div[7]/button[2]");
			//手机预览、关掉
			s.thread(1200);
			s.xpathClick("//button[contains(@class,'btn btn-primary previewProduct dianxinMix')]");
			//s.xpathClick("//*[@id='4ef272ab18e5429caf0a793909f21160']");
			s.thread(1200);			
			s.xpathClick("//*[@id='previewCancel']");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "在售商品列表");
			System.out.println("在售商品列表测试通过！");
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
