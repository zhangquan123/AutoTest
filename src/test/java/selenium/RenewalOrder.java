package selenium;

import java.io.IOException;

import org.testng.annotations.Test;
//续约订单功能
public class RenewalOrder {
  @Test(groups="RenewalOrder")
  public void RenewalOrderTabulation() throws IOException {
	  Implement i= Implement.getInstance();
	  try {
	  //进入续约订单、iframe
	  i.selector("#menuFoxIn > section:nth-child(4) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(2) > section > p > span");	  
	  i.enterIframe("/html/body/section/section[4]/section/iframe");
	  //查看详情、返回、搜索
	  i.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[11]/button[1]");
	  i.Thread(1000);
	  i.xpathClick("/html/body/section/section[1]/button");
	  i.Thread(1000);
	  i.xpathTextInput("/html/body/section/section[1]/section/section[1]/section/input", "云南");
	  i.Thread(1000);
	  i.xpathClick("/html/body/section/section[1]/section/section[5]/button[2]");	  
	  //订单编码断言
	  String ss=i.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[2]");
	  if(ss.equals("订单编号")){
		  System.out.println(ss+"续约订单功能中的断言成功");
	  }else{
		  System.out.println("断言失败!");
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
