package platformmanage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class HealthCode {
	//健康码管理
	@Test(groups="HealthCode")
	public void JanKangMa() throws IOException{
		Share s = Share.getInstance();
		try {
			s.xpathClick("//*[@id='side-menu']/li[3]/ul/li[15]/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//创建分值、名称、编码
			s.thread(1200);
			s.xpathClick("//*[@id='addHelth']");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "测试测试码");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='code']", "DDDDDD");
			//最大限值、最小限值、图片上传
			s.thread(1200);
			s.xpathSendKeys("//*[@id='maxValue']", "100000");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='minValue']", "1000");
			s.thread(1200);	
			s.uploadFile("//*[@id='choseImg']", "C://Users//Administrator//Desktop//QMMgrBackup_MisDel//导入模板//alsj.jpg");
			s.thread(1500);	
			//提示等级、提示语、面向客户提示语、保存、保存成功确定
			s.xpathSendKeys("//*[@id='warnLevel']", "测试提示等级");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='warnTip']", "测试提示语");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='warnTip2c']", "面向客户提示语");
			s.thread(1200);
			s.xpathClick("//*[@id='sureSave']");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			//修改、名称、最大值、最小值、取消修改
			s.thread(1200);
			s.xpathClick("//*[@id='tbHealth']/tbody/tr[2]/td[6]/button[1]");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "KKKKK码");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='maxValue']", "100000");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='minValue']", "1000");
			s.thread(1500);
			s.xpathClick("//*[@id='cancelEdit']");
			//删除、确定删除、
			s.thread(1200);
			s.xpathClick("//*[@id='tbHealth']/tbody/tr[2]/td[6]/button[2]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(1500);
			//输入 、搜索、重置
			s.xpathSendKeys("//*[@id='queryForm']/div/div[1]/input","绿码");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			s.thread(1200);		
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "健康码管理");
			System.out.println(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2")+"健康码管理测试成功！");
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
