package channelmanagement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class CustomerServicePersonnelList {
	//客服人员列表
	@Test(groups="CustomerServicePersonnelList")
	public void KeFuPersionList() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入客服人员列表
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[7]/a/span[1]");
			s.thread(1200);
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[7]/ul/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//导入客服、姓名、联系电话
			s.xpathClick("//*[@id='add']");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='form']/div[1]/div/input", "客服9号");;
			s.thread(1200);
			s.xpathSendKeys("//*[@id='serTel']", "020-7655933");
			s.thread(1200);
			//本地上传图片、
			s.xpathClick("//*[@id='my_adv']/div/span");
			s.thread(1200);
			Runtime ru = Runtime.getRuntime();			
			try {			
				ru.exec("D:\\WorkSpace\\ZheJiangYunXiao\\touxiang.exe");			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail to upload!");
				e.printStackTrace();
			}
			s.thread(3500);
			s.xpathClick("//*[@id='uploadAdv']");
			s.thread(1500);
			s.xpathSendKeys("//*[@id='form']/div[4]/div/input", "Q2024101");
			s.thread(1200);
			s.scolleButton();
			//选择时间
			s.xpathClick("//*[@id='workendTime']");
			s.thread(1000);
			s.Driver.findElement(By.xpath("//*[@id='form']/div[8]/div/div[2]/div[2]/table/tbody/tr[2]/td[1]/input")).clear();
			s.thread(1000);
			s.xpathSendKeys("//*[@id='form']/div[8]/div/div[2]/div[2]/table/tbody/tr[2]/td[1]/input", "22");
			s.xpathClick("//*[@id='form']/div[8]/label");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[10]/div/button[1]");//保存并发布					  
		
			s.thread(2000);
			//修改、修改客服名称、联系电话		
			//s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary success')]")).click();
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary editProduct')]")).click();
			//s.xpathClick("//*[@id='58ca16db2f114dda92cac52446d6cfdc']");			
			s.thread(1000);
			s.xpathSendKeys("//*[@id='form']/div[1]/div/input", "修改客服名称");
			s.thread(1000);
			s.Driver.findElement(By.xpath("//*[@id='serTel']")).clear();
			s.thread(500);
			s.xpathSendKeys("//*[@id='serTel']", "15899878606");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[10]/div/button[1]");//修改保存
			s.thread(1200);
			//停用、确定停用、删除、确定删除
			s.xpathClick("//*[@id='tbProduct']/tbody/tr[1]/td[9]/button[3]");
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(2000);		
			s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger deletOne')]")).click();	
			s.thread(1200);
			s.xpathClick("/html/body/div[4]/div[7]/button[2]");
			s.thread(1500);
			//输入关键字、搜索、重置
			s.xpathSendKeys("//*[@id='queryForm']/div/div/input[1]", "kefu9");
			s.thread(1200);
			s.xpathClick("//*[@id='search']");
			s.thread(1200);
			s.xpathClick("//*[@id='reset']");
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "客服列表");
			System.out.println("客服列表测试通过！");
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
