package selenium;

import java.io.IOException;

import org.testng.annotations.Test;
/*
 * 续约维护时间设置
 * */
public class RenewalMaintenanceTimeSetting {
  @Test(groups="RenewalMaintenanceTimeSetting")
  public void timeSetting() throws IOException {
	  Implement i=Implement.getInstance();
	  try {
		//进入框架
		i.selector("#menuFoxIn > section:nth-child(2) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(5) > section > p > span");
		i.enterIframe("/html/body/section/section[4]/section/iframe");
		i.Thread(1500);
		//文本输入   搜索  重置
		i.xpathTextInput("/html/body/section/section[1]/section[1]/input", "湖北省");
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[1]/button[1]");
		i.Thread(1200);
		i.xpathClick("/html/body/section/section[1]/button[2]");
		i.Thread(1200);
		//添加   返回
		i.xpathClick("/html/body/section/section[1]/button[3]");
		i.Thread(1500);
		i.xpathClick("/html/body/section/section[1]/button");
		//断言
		String ss=i.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[3]");
		if(ss.equals("每月维护时间")){
			System.out.println("续约维护时间设置断言成功！");
		}else{
			System.out.println("续约维护时间设置断言失败！");
		}
		i.quitIframe();
		i.Thread(1200);
	} catch (Exception e) {
		// TODO: handle exception
		i.ScreenShot();
		e.printStackTrace();
	}
  }
}
