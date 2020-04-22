package selenium;

import org.testng.annotations.Test;

public class Setup {
  @Test(groups="Setup")
  public void Setup1() throws InterruptedException {
	  Implement i= Implement.getInstance();
	  //设置、个人设置、iframe
	  i.xpathClick("/html/body/section/section[2]/div/div[5]/div[1]/p/span[1]");
	  i.Thread(1200);
	  i.xpathClick("/html/body/section/section[2]/div/div[5]/div[2]/p/span");
	  i.enterIframe("/html/body/section/section[3]/section/iframe");
	  i.Thread(1200);
	  i.quit();
  }
}
