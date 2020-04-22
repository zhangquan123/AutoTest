package selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
//宽带产品列表功能
public class WindProduct {
  @Test(groups="WindProduct")
  public void WindProductTabulation() throws IOException {
	  Implement i= Implement.getInstance();
	  try {
		//进入宽带中心、宽带产品列表
		i.selector("#menuFoxIn > section:nth-child(3) > section.clearfix.menu.pd10.mg-t10 > p > span.left.pointer");
		i.Thread(1000);
		i.selector("#menuFoxIn > section:nth-child(3) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(1) > section > p > span");
		i.enterIframe("/html/body/section/section[4]/section/iframe");			
		i.Thread(1000);
		//发布商品、使用范围、选浙江全省、基本详情
		i.xpathClick("/html/body/section/section[2]/button[1]");		
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[1]/section[2]/section[2]/section[1]/section/input");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[1]/section[2]/section[2]/section[1]/section/section/section/section/section/section/section[2]/section/section[1]/span/section");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[1]/section[2]/section[1]/span[1]");
		//宽带名称、销售品id、现价、速率
		i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[2]/input", "20190613");
		i.Thread(1000);
		i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[3]/input", "20190613");;
		i.Thread(1000);
		i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[4]/input[2]", "99");
		i.Thread(1000);
		i.scorllBotton();
		i.Thread(1000);
		i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[7]/input", "50");
		i.Thread(1000);
		//下一步、上传图片
		i.xpathClick("/html/body/section/section[1]/section[2]/section[2]/section[13]/button");
		i.Thread(1000);
		i.scorllTop();			
		i.Thread(1500);
		WebElement adFileUpload = i.chromeDriver.findElement(By.id("upImg"));				
		String filePath = "D://tupian.png";
		adFileUpload.sendKeys(filePath);		
		//图文详情、资费说明、保存并发布		
		/*i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[3]/section/div[2]", "套餐内容很丰富哦！");*/
		i.Thread(1000);
		i.scorllBotton();
		/*i.Thread(1000);
		i.xpathTextInput("/html/body/section/section[1]/section[2]/section[2]/section[4]/section/div[2]", "一年小1000块");*/		
		i.Thread(2000);
		i.xpathClick("/html/body/section/section[1]/section[2]/section[2]/section[5]/button[2]");		
		i.Thread(1200);
		//下架、确定下架
		i.xpathClick("/html/body/section/section[3]/table/tbody/tr[1]/td[9]/button");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[6]/section/section/section[2]/button[2]");
		i.Thread(1500);		
		//断言
		String text=i.xpathGetText("/html/body/section/section[2]/button[1]");
		if(text.equals("发布商品")){
			System.out.println(text+"宽带产品功能断言成功！");
		}else{
			System.out.println("断言失败！");
		}
		i.quitIframe();
		i.Thread(1500);
	  } catch (Exception e) {
		// TODO: handle exception
		 System.out.println("======exception reason======="+e);
		 i.ScreenShot();
		 e.printStackTrace();
		 
	}
  }
}
