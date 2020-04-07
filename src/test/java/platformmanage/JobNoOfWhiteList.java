package platformmanage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class JobNoOfWhiteList {
	//工号白名单管理
	@Test(groups="JobNoOfWhiteList")
	public void GongHaoBaiMingDan() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入工号白名单
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[13]/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//添加白名单工号、工号、所属企业、保存
			s.xpathClick("//*[@id='addNew']");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='typeVal']", "777777777777777777");
			s.thread(1200);
			s.xpathClick("//*[@id='selectCom']");
			s.thread(500);
			s.xpathClick("//*[@id='treeMultiple_1_span']");
			s.thread(1000);
			s.xpathClick("//*[@id='addWrap']/div/div[3]/label");
			s.thread(1000);
			s.xpathClick("//*[@id='saveNew']");
			//删除、确定删除、关键字 、搜索、重置
			s.thread(2000);
			s.xpathClick("//*[@id='tbNews']/tbody/tr[1]/td[5]/button");
			s.thread(1000);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(1000);			
			s.xpathSendKeys("//*[@id='queryForm']/div/div/input[1]", "广州宇中网络科技有限公司");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1000);
			s.xpathClick("//*[@id='reset']");			
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "工号白名单管理");
			s.quitIframe();
			System.out.println("工号白名单管理测试成功!");
			s.thread(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);
			s.ScreenShot();
			e.printStackTrace();
		}
	}
}
