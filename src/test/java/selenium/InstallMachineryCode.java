package selenium;

import java.io.IOException;

import org.testng.annotations.Test;
//装机宽带编码
public class InstallMachineryCode {
  @Test(groups="InstallMachineryCode")
  public void MachineryCode() throws IOException {
	 Implement im= Implement.getInstance();
	 try {
		im.selector("#menuFoxIn > section:nth-child(2) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(4) > section > p > span");
		im.enterIframe("/html/body/section/section[4]/section/iframe");
		im.Thread(1200);
		 //文本输入 搜索  重置
		im.xpathTextInput("/html/body/section/section[1]/section[1]/input", "8310000");
		im.Thread(1200);
		im.xpathClick("/html/body/section/section[1]/button[1]");
		im.Thread(1200);
		im.xpathClick("/html/body/section/section[1]/button[2]"); 
		//断言
		String tt=im.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[5]");
		if(tt.equals("物流编码名称")){
			System.out.println("装机宽带编码断言成功！");
		}else{
			System.out.println("装机宽带编码断言失败！");
		}
		im.quitIframe();
		im.Thread(1200);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		im.ScreenShot();
	}
  }
}
