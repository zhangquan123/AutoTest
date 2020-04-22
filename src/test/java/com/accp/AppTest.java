package com.accp;



import java.util.List;


import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import selenium.Implement;


public class AppTest 
{
    /**
     * jenkins会默认执行这个文件，所以我将jenkins触发testNG.xml文件放这儿
     * 自动化启动入口，执行testNG.xml文件
     * @throws InterruptedException 
     */
    @Test
    public void shouldAnswerWithTrue()
    {    	
    	System.out.println("111111111111111111111111111111111111111111111111111111111111");
    	//登陆    
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        //suites.add("C:\\Users\\55441\\Workspaces\\MyEclipse Professional 2014\\Maven_Selenium_Jenkins_TestNG\\src\\test\\java\\TestNG.xml");//path to xml..
        suites.add("C:\\Users\\Administrator\\Desktop\\111\\Maven_Selenium_Jenkins_TestNG\\src\\test\\java\\TestNG.xml");
        testng.setTestSuites(suites);
        testng.run();        
        
    	
        //assertTrue( true );
    }
    
   
}
