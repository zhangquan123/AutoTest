package selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProvincesCityArea {
  //省市区列表
	
  @Test(groups="ProvincesCityArea")
  public void ProvincesCityAreaTabulation() throws InterruptedException, IOException {
	  
	 Implement imp = Implement.getInstance();//静态方法调用
	 
	 try {
		 imp.selector("#menuFoxIn > section:nth-child(2) > section.clearfix.menu.pd10.mg-t10 > p > span.left.pointer");
		
		 imp.Thread(1200);
		 imp.selector("#menuFoxIn > section:nth-child(2) > section.sub-menu.pd-l15.pd-r10 > section > section:nth-child(1) > section > p > span");		
		 
		 imp.Thread(1200);
		 //进去iframe后文本框输入，然后查询
		 imp.enterIframe(" /html/body/section/section[4]/section/iframe");		
		 imp.xpathTextInput("/html/body/section/section[1]/section[1]/input", "北京市");		 
		 imp.Thread(1200);
		 imp.xpathClick("/html/body/section/section[1]/button[1]");
		 //重置,添加城市
		 imp.Thread(1000);
		 imp.xpathClick("/html/body/section/section[1]/button[2]");
		 imp.Thread(1000);
		 imp.xpathClick("/html/body/section/section[1]/button[3]");
		 imp.Thread(1000);
		 
		 //断言
		 Assert.assertEquals("城市", imp.xpathGetText("/html/body/section/section[2]/table/thead/tr/th[3]"));
		 System.out.println("城市字段"+"\t"+"断言成功");
		 
		 //添加城市弹窗，选择上级机构,地区编码,地区名称，保存
		 imp.xpathClick("/html/body/section/section[4]/section/section[1]/select");		 
		 imp.Thread(1000);
		 imp.xpathClick("/html/body/section/section[4]/section/section[1]/select/option[9]");
		 imp.Thread(1000);
		 imp.xpathTextInput("/html/body/section/section[4]/section/section[2]/input","20190607");
		 imp.Thread(1000);
		 imp.xpathTextInput("/html/body/section/section[4]/section/section[3]/input", "广东测试市2");
		 imp.Thread(1000);
		 imp.xpathClick("/html/body/section/section[4]/section/section[4]/button[2]");
		 				 
		 
		 //编辑，取消编辑，删除刚添加的数据
		 imp.Thread(1800);
		 imp.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[5]/button[1]");
		 imp.Thread(1200);
		 imp.xpathClick("/html/body/section/section[4]/section/section[4]/button[1]");		 
		 imp.Thread(1200);
		 imp.xpathClick("/html/body/section/section[2]/table/tbody/tr[1]/td[5]/button[2]");
		 imp.Thread(1200);
		 imp.xpathClick("/html/body/section/section[6]/section/section/section[2]/button[2]");
		 
		 imp.quitIframe();
		 
		 imp.Thread(2000);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("======exception reason=======" + e);
		imp.ScreenShot();
		e.printStackTrace();
	}
	 
  }
}
