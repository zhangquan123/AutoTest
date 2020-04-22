package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RenewalCommodities {
	//续约商品列表
  @Test(groups="RenewalCommodities")
  public void RenewalCommoditiesTabulation() throws IOException {
	  Implement imp = Implement.getInstance();
	  
	  try {
		 //打开续约商品列表，定位到这个frame 
		//imp.xpathClick("/html/body/section/section[2]/div/div[2]/div[2]/p[2]/span");	
		imp.selector("#menuFoxIn > section:nth-child(2) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(2) > section > p > span");
		imp.Thread(1500);
		imp.enterIframe("/html/body/section/section[4]/section/iframe");
		
		//断言判断一下
		//Assert.assertEquals("宽带名称",imp.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[1]") );
		String ss=imp.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[1]");
		if(ss.equals("宽带名称")){
			System.out.println(ss+"断言成功");
		}else{
			System.out.println("断言失败！");
		}		
		
		//查询、搜索、重置
		imp.xpathTextInput("/html/body/section/section[1]/section[1]/input", "云南");
		
		imp.Thread(1200);
		imp.xpathClick("/html/body/section/section[1]/section[2]/button[2]");
		
		imp.Thread(1200);
		imp.xpathClick("/html/body/section/section[1]/section[2]/button[3]");
		imp.Thread(1200);
		
		//导入、返回、滚动条到底部、下一页,查看
		imp.xpathClick("/html/body/section/section[1]/section[2]/button[1]");		
		imp.Thread(1200);
		imp.xpathClick("/html/body/section/section[1]/button");
		imp.Thread(1200);
		imp.scorllBotton();
		imp.Thread(1200);
		imp.xpathClick("/html/body/section/section[3]/section/ul/li[8]");
		imp.Thread(1200);
		imp.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[7]/button[2]");
		imp.Thread(1200);
		imp.quitIframe();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("======exception reason======="+e);
		imp.ScreenShot();
		e.printStackTrace();
	}
  }
}
