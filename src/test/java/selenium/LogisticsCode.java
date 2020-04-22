package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * 物流编码
 * */
public class LogisticsCode {
  @Test(groups="LogisticsCode")
  public void Code() throws IOException {
	  Implement imp=Implement.getInstance();
	  try {		  
		  //打开物流编码，进入框架
		  imp.selector("#menuFoxIn > section:nth-child(2) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(3) > section > p > span");
		  imp.enterIframe("/html/body/section/section[4]/section/iframe");		 
		  Thread.sleep(1200);
		  //文本输入、选择省份、区县
		  imp.xpathTextInput("/html/body/section/section[1]/section[1]/input", "002001001");
		  Thread.sleep(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[2]/section/section/select");
		  Thread.sleep(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[2]/section/section[1]/select/option[2]");
		  Thread.sleep(1200);
		  imp.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[4]");
		  Thread.sleep(1000);
		 //搜索、重置
		  imp.xpathClick("/html/body/section/section[1]/button[1]");		  
		  Thread.sleep(1200);
		  imp.xpathClick("/html/body/section/section[1]/button[2]");  
		  
		  //断言、退出框架
		  String text=imp.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[5]");			  								
		  Assert.assertEquals("物流编码名称", text);
		  System.out.println("物流编码功能断言成功！");
		
		  imp.quitIframe();
		  Thread.sleep(1200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println("======exception reason======="+e);
		imp.ScreenShot();
		e.printStackTrace();
	}
  }
}
