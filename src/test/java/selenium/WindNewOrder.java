package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
//宽带新装订单
public class WindNewOrder {
  @Test(groups="WindNewOrder")
  public void WindNewOrderTabulation() throws IOException {
	  Implement i= Implement.getInstance();	  
	  try {
		//进入订单中心、宽带新装订单、iframe		 
		i.selector("#menuFoxIn > section:nth-child(4) > section.clearfix.menu.pd10.mg-t10 > p > span.left.pointer");	
		i.Thread(1000);
		i.selector("#menuFoxIn > section:nth-child(4) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(1) > section > p > span");
		i.enterIframe("/html/body/section/section[4]/section/iframe");
		//查看详情、返回、省份选择、选择湖北
		i.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[11]/button[1]");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[1]/button");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[1]/section/section[2]/section/section/select");
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[1]/section/section[2]/section/section[1]/select/option[6]");
		//搜索、导出、重置
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[1]/section/section[5]/button[2]");
		i.Thread(2000);
		i.xpathClick("/html/body/section/section[1]/section/section[5]/button[1]");
		i.Thread(2000);
		i.xpathClick("/html/body/section/section[1]/section/section[5]/button[2]");
		//断言
		Assert.assertEquals("宽带名称", i.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[1]"));
		System.out.println("宽带新装订单功能中宽带名称断言成功");
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
