package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

//角色列表
public class Roler {
	Implement imp = Implement.getInstance();
	@Test(groups="Roler")
	public void RoleTabulation() throws InterruptedException, IOException{
		try {
			//进入添加角色功能，进入ifame
			imp.xpathClick("/html/body/section/section[2]/div/div[2]/div[2]/p[4]/span");
			imp.Thread(1200);
			imp.enterIframe("/html/body/section/section[3]/section/iframe");
			//添加角色、角色名、编号、权限勾选
			imp.xpathClick("/html/body/section/section[1]/button[3]");
			imp.Thread(1000);
			imp.xpathTextInput("/html/body/section/section[2]/section[1]/input", "1234");
			imp.Thread(1200);
			imp.xpathTextInput("/html/body/section/section[2]/section[2]/input", "1234");
			imp.Thread(1000);
			imp.xpathClick("/html/body/section/section[2]/section[3]/section/section/section/section/section/section[2]/section/section[1]/span/section");
							
			imp.Thread(1200);
			//保存添加的角色，删除添加的角色,确认删除
			imp.xpathClick("/html/body/section/section[2]/section[4]/button[2]");
			imp.Thread(1500);
			imp.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[4]/button[1]");
			imp.Thread(1000);
			imp.xpathClick("/html/body/section/section[5]/section/section/section[2]/button[2]");
			imp.Thread(1000);
			//输入  并搜索
			imp.xpathTextInput("/html/body/section/section[1]/section/input", "ss");
			imp.xpathClick("/html/body/section/section[1]/button[1]");
			//加入断言
			String text=imp.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[1]");
			Assert.assertEquals("角色名", text);
			System.out.println(text+"断言成功");
			
			imp.quitIframe();
			imp.Thread(1200);			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason======="+e);
			imp.ScreenShot();
			e.printStackTrace();
		}
	
	}
}
