package channelmanagement;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;



import TestCase.Share;

public class NewSubordinateEnterprises {
	//新增下属企业
	@Test(groups="NewSubordinateEnterprises")
	public void AddXiaShuQiYe() throws IOException{
		Share s = Share.getInstance();
		try {
			//进入新增下属企业
			s.xpathClick("//*[@id='side-menu']/li[4]/a");			
			s.thread(1500);
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[2]/a/span[1]");
			s.thread(1200);
			s.xpathClick("//*[@id='side-menu']/li[4]/ul/li[2]/ul[1]/li/a");
			s.thread(1200);
			s.enterIframe("//*[@id='iframeMain']");
			s.thread(1200);
			//下载企业模板、上传企业模板、确认导入
			s.xpathClick("//*[@id='page-wrapper']/div[2]/div[1]/div[2]/p[2]/a");
			s.thread(1200);	
			s.xpathClick("//*[@id='my-awesome-dropzone']");
			s.thread(2000);			    
			//非 <input type="file" name=''filename">这种上传
			Runtime upload = Runtime.getRuntime();
			try {
			String au3exe = "D:\\WorkSpace\\ZheJiangYunXiao\\qiyemuban.exe";			
			    upload.exec(au3exe);
			}catch (IOException e){
			    System.out.println("Fail to upload!");
			    e.printStackTrace();
			}			
		    s.thread(3000);				
			s.xpathClick("//*[@id='uploadImg']"); 
			s.thread(2000);
			//滚动条向下
			s.xpathClick("//*[@id='page-wrapper']/div[2]/div[1]/div[1]/h4/span[2]");
			s.scolleButton();		
			//s.xpathClick("//*[@id='confirm']");  确认导入
			//s.thread(2000);						
			Assert.assertEquals(s.xpathGetText("//*[@id='page-wrapper']/div[1]/div[1]/h2"), "新增下属企业");
			System.out.println("新增下属企业成功！");
			s.thread(2000);
			s.quitIframe();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("======exception reason=======" + e);	
			s.ScreenShot();
			e.printStackTrace();
		}
		
		
	}
}
