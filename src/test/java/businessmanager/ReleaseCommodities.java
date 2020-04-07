package businessmanager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestCase.Share;

public class ReleaseCommodities {
	//发布商品
	@Test(groups="ReleaseCommodities")
	public void FaBuCommpdities() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入商品发布
			s.xpathClick("//*[@id='side-menu']/li[5]/a/span[1]");
			s.thread(1000);
			s.xpathClick("//*[@id='side-menu']/li[5]/ul/li[1]/a/span[1]");
			s.thread(1000);
			s.xpathClick("//*[@id='side-menu']/li[5]/ul/li[1]/ul[1]/li/a");
			s.enterIframe("//*[@id='iframeMain']");
			//选择普通商品、现在发布、产品名称
			s.xpathClick("//*[@id='1371864340168720']");
			s.thread(1200);
			s.scolleButton();
			s.thread(1000);
			s.xpathClick("//*[@id='okLei']");			
			s.thread(1200);
			s.xpathSendKeys("//*[@id='name']", "20200402测试商品");
			s.thread(1200);
			//原价  折扣率  、积分按钮、下拉、积分设置
			s.xpathSendKeys("//*[@id='price']", "100");
			s.thread(1200);
			s.xpathSendKeys("//*[@id='discount']", "0.01");
			s.thread(1200);
			s.xpathClick("//*[@id='commissionOrIntegral']/div[2]/label");
			s.thread(1200);
			s.scolleButton();
			s.thread(1200);
			s.xpathSendKeys("//*[@id='integral']", "1");
			s.thread(1200);
			//库存数量、下一步
			s.xpathSendKeys("//*[@id='stock']", "100");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[3]/div[1]/div[12]/div/button");
			s.thread(1200);
			//上传商品图片
			s.xpathClick("//*[@id='my-awesome-dropzone']");
			s.thread(1200);
			Runtime r = Runtime.getRuntime();
			try {
				r.exec("D:\\WorkSpace\\ZheJiangYunXiao\\ProductPicture.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail to upload!");
				e.printStackTrace();
			}
			s.thread(3500);
			s.xpathClick("//*[@id='uploadImg']");
			s.thread(1200);
			//上传推广图
			s.xpathClick("//*[@id='my_adv']");
			s.thread(1200);
			Runtime r2 = Runtime.getRuntime();
			try {
				r2.exec("D:\\WorkSpace\\ZheJiangYunXiao\\ProductPicture.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail to upload!");
				e.printStackTrace();
			}
			s.thread(3500);
			s.xpathClick("//*[@id='uploadAdv']");
			//产品描述、下拉、下一步					
			//s.Driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary editProduct')]")).click();
			s.thread(1500);					  
			/*((JavascriptExecutor)s.Driver).executeScript("window.scrollTo(0,800);");
			s.thread(1200);
			s.xpathClick("//*[@id='form']/div[3]/div[2]/div[6]/label");
			s.thread(1500);	
			s.xpathClick("//*[@id='form']/div[3]/div[2]/div[4]/div/div[1]/div/div[1]/div[1]/div[37]/div[1]");*/
			//s.xpathClick("//*[@id='form']/div[3]/div[2]/div[4]/div/div[1]/div/div[1]/div[1]/div[1]"); //产品描述
			//s.Driver.findElement(By.xpath("//button[contains(@class,'edui-editor-body')]")).sendKeys("随便描述了!");
			//s.xpathSendKeys("//*[@id='descr']/p", "随便描述了");			
			s.scolleButton();
			s.xpathClick("//*[@id='form']/div[3]/div[2]/div[8]/div/button[2]");
			s.thread(1200);
			//上滑，邮费，在线付款、小程序支付
			s.scolleTop();
			s.thread(1200);
			s.xpathSendKeys("//*[@id='shippingFee']", "0");
			s.thread(1200);
			s.xpathClick("//*[@id='payment']/div/div[1]/label");
			s.thread(1200);
			s.xpathClick("//*[@id='payment']/div/div[3]/label");
			//下拉、保存并发布、保存成功确定
			s.thread(1200);
			s.scolleButton();
			s.thread(1200);
			s.xpathClick("//*[@id='saveCan']");
			s.thread(1500);
			/*s.xpathClick("/html/body/div[5]/div[7]/button[2]");
			s.thread(1200);*/
			//图文信息下一步、放弃修改
			s.scolleButton();
			s.thread(1000);
			s.xpathClick("//*[@id='form']/div[3]/div[2]/div[8]/div/button[2]");						
			s.thread(1200);
			s.xpathClick("//*[@id='cancelEdit']");
			s.thread(1500);			
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "发布商品");
			System.out.println("商品发布成功！");
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
