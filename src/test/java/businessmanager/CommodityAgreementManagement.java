package businessmanager;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class CommodityAgreementManagement {
	//商品协议管理
	@Test(groups="CommodityAgreementManagement")
	public void ProductAgreementManagenent() throws IOException{
		Share s = Share.getInstance();
		try {
			s.xpathClick("//*[@id='side-menu']/li[5]/ul/li[1]/ul[5]/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//新增协议、模板名、乙方名称、协议标题
			s.xpathClick("//*[@id='publishTemplate']");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "selenium测试模板名");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='secondParty']", "selenium测试名称");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='title']", "测试标题");
			s.thread(1200);
			//上传、协议一上方内容、入网姓名、身份证信息、确定
			s.uploadFile("//*[@id='choseImg']", "C:\\Users\\Administrator\\Desktop\\QMMgrBackup_MisDel\\导入模板\\pika.jpg");
			s.thread(1200);
			s.xpathClick("//*[@id='addTop']");
			s.thread(1200);
			s.xpathClick("//*[@id='userName']");
			s.thread(1200);
			s.xpathClick("//*[@id='settingConfigs']/div[3]/div/label");
			s.thread(1200);
			//取消、确定、确定保存
			s.classClick("//*[@id='cancelEdit']");
			/*s.xpathClick("//*[@id='save']");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			*/
			s.thread(1200);
			//查看、返回
			s.xpathClick("//button[contains,(@class,'btn btn-primary scan')]");
			s.thread(1200);
			s.scolleButton();
			s.thread(1000);
			s.xpathClick("//*[@id='reBack']"); 
			s.thread(1000);
			//启用、确定启用、停用、确定停用
			s.xpathClick("//button[contains,(@class,'btn btn-success startUsing')]");
			s.thread(1000);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");			
			s.thread(1200);
			s.xpathClick("//button[contains,(@class,'btn btn-warning nonuse')]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(1200);				
			//关键字输入、搜索、重置
			s.xpathSendKeys("//*[@id='queryForm']/div/div/input[1]", "测试");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "商品协议模板");
			System.out.println("商品协议模板测试通过！");			
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
