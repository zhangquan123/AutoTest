package channelmanagement;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class SalesForceList {
	//销售人员列表
	@Test(groups="SalesForceList")
	public void QiYeList() throws IOException{
		Share s = Share.getInstance();
		try {
			//销售人员列表
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[4]/a/span[1]");
			s.thread(1000);
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[4]/ul[1]/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//导入销售、下载企业通讯录模板
			s.xpathClick("//*[@id='queryForm']/a");
			s.thread(1200);			
			s.thread(1200);
			s.xpathClick("//*[@id='documentLink']");			
			s.thread(2000);
			//上传通讯录模板、上传、滚动条向下
			s.xpathClick("//*[@id='my-awesome-dropzone']");			
			s.thread(1500);				
			Runtime ru = Runtime.getRuntime();
			try {
				ru.exec("D:\\WorkSpace\\ZheJiangYunXiao\\SalesForceList.exe");			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail to upload!");
				e.printStackTrace();
			}
			s.thread(3000);
			s.xpathClick("//*[@id='uploadImg']");
			s.thread(1200);
			s.scolleButton();
			s.thread(1500);
			s.xpathClick("//*[@id='cancelImport']");//取消导入			
			s.thread(1500);
			//关键字搜索、时间选择
			s.xpathSendKeys("//*[@id='queryForm']/div[1]/input", "1852004");			
			s.thread(1200);
			s.xpathClick("//*[@id='date']/input[1]");
			s.thread(1000);
			for(int i=0;i<9;i++){
				s.xpathClick("/html/body/div[3]/div[1]/table/thead/tr[1]/th[1]");
				s.thread(500);
			}
			s.xpathClick("/html/body/div[3]/div[1]/table/tbody/tr[1]/td[6]");
			s.thread(1200);
			//全部、搜索、重置、导出报表
			s.pullDown("//*[@id='statusList']", "全部");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			s.thread(1200);
			s.xpathClick("//*[@id='export']");
			//滚动条向下  、滚动条向右	
			s.thread(1200);
			s.scolleButton();
			s.thread(1000);
			s.scolleRight();			
			//查看、兼职销售、返回
			s.thread(1200);
			s.xpathClick("//*[@id='tbSales']/tbody/tr[1]/td[20]/button[1]");
			s.thread(1200);			
			s.xpathClick("//*[@id='page-wrapper']/div[1]/div[1]/div[2]/div/div/div/ul/li[2]/a");
			s.thread(1000);
			s.xpathClick("//*[@id='backOrder']");
			s.thread(1200);
			//资料变更、关闭
			s.thread(1200);
			s.xpathClick("//*[@id='tbSales']/tbody/tr[1]/td[20]/button[2]");
			s.thread(1200);
			s.xpathClick("//*[@id='cancelChange']");
			//解禁、取消解禁
			s.thread(1200);
			s.xpathClick("//*[@id='tbSales']/tbody/tr[2]/td[20]/button[3]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[1]");					
			s.thread(1200);
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "销售人员列表");
			System.out.println("销售人员列表测试通过!");
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
