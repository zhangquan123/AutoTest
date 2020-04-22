package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
//已下架产品列表
public class AlreadyOffShelves {
  @Test(groups="AlreadyOffShelves")
  public void AlreadyOffShelvesTabulation() throws IOException {
	  Implement i = Implement.getInstance();
	  try {
		i.selector("#menuFoxIn > section:nth-child(3) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(2) > section > p > span");	
		i.enterIframe("/html/body/section/section[4]/section/iframe");
		i.Thread(1500);
		//输入后、搜索、重置
		i.xpathTextInput("/html/body/section/section[1]/section[1]/input", "20190613");
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[2]/button[1]");
		i.Thread(2000);
		i.xpathClick("/html/body/section/section[2]/button[2]");
		//删除、确认删除、上架、取消上架
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[3]/table/tbody/tr[1]/td[8]/button[3]");	
		i.Thread(1000);
		i.xpathClick("/html/body/section/section[6]/section/section/section[2]/button[2]");
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[3]/table/tbody/tr[1]/td[8]/button[1]");
		
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[6]/section/section/section[2]/button[1]");
		//宽带名称断言
		Assert.assertEquals("宽带名称", i.xpathGetText("/html/body/section/section[3]/table/thead/tr/th[1]"));
		System.out.println("已下架产品列表功能中宽带名称断言成功！");
		i.Thread(1500);
		i.quitIframe();
	} catch (Exception e) {
		// TODO: handle exception
		 System.out.println("======exception reason======="+e);
		 i.ScreenShot();
		 e.printStackTrace();
	}
  }
}
