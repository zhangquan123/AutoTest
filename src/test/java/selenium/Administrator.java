package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Administrator {
	//管理员列表
  Implement imp = Implement.getInstance();	
  @Test(groups="Administrator")
  public void AdministratorTabulation() throws InterruptedException, IOException {
	  try {
		  imp.xpathClick("/html/body/section/section[2]/div/div[2]/div[2]/p[3]/span");
		  imp.Thread(2000);
		  imp.enterIframe("/html/body/section/section[3]/section/iframe");
		  
		  //页面断言
		  //Assert.assertEquals("账号", imp.xpathGetText("/html/body/section/section[1]/section[2]/table/thead/tr/th[2]"));
		  String ss=imp.xpathGetText("/html/body/section/section[1]/section[2]/table/thead/tr/th[2]");
		  if(ss.equals("账号")){
			  System.out.println(ss+"断言成功");
		  }else{
			  System.out.println("断言失败！");
		  }
		  //输入、搜索、重置
		  imp.xpathTextInput("/html/body/section/section[1]/section[1]/section[1]/input", "jugg");
		  imp.Thread(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[1]/button[1]");
		  imp.Thread(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[1]/button[2]");
		  
		  //下拉，已禁用、搜索、重置
		  imp.Thread(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[1]/section[2]/select");
		  imp.Thread(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[1]/section[2]/select/option[3]");
		  imp.Thread(1200);	  
		  imp.xpathClick("/html/body/section/section[1]/section[1]/button[1]");
		  imp.Thread(1200);
		  imp.xpathClick("/html/body/section/section[1]/section[1]/button[2]");
		  
		  //退出iframe
		  imp.quitIframe();
		  imp.Thread(1200);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("======exception reason=======" + e);
		imp.ScreenShot();
		e.printStackTrace();
	}
  }
}
