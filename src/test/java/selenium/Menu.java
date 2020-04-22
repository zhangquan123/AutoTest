package selenium;

import org.testng.annotations.Test;
//菜单列表
public class Menu {
  @Test(groups="Menu")
  public void MenuTabulation() throws InterruptedException {
	  Implement im =Implement.getInstance();
	  im.xpathClick("/html/body/section/section[2]/div/div[2]/div[2]/p[5]/span");
	  im.enterIframe("/html/body/section/section[3]/section/iframe");
	  //添加菜单、取消、输入首页、搜索
	  im.Thread(1000);
	  im.xpathClick("/html/body/section/section[1]/section[1]/button[3]");
	  im.Thread(1000);
	  im.xpathClick("/html/body/section/section[2]/section[6]/button[1]");	  
	  im.Thread(1000);
	  im.xpathTextInput("/html/body/section/section[1]/section[1]/section/input", "首页");
	  im.Thread(1000);
	  im.xpathClick("/html/body/section/section[1]/section[1]/button[1]");
	  
	  im.quitIframe();
	  im.Thread(1200);
	  //打开数据字典列表
	  im.xpathClick("/html/body/section/section[2]/div/div[2]/div[2]/p[6]/span");
	  im.Thread(1200);
  }
}
