package timesheet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class timesheet extends Getdata{
	 
	public timesheet() throws IOException {
		super();
		
	}
	

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		Getdata g = new Getdata();
		ArrayList<String> arr = g.getdata();
		System.out.println(arr.size()); 
		String username = arr.get(0);
		String pass = arr.get(1);
		long min = 1;
		long mili = min*80*1000;
		driver.get("https://onecognizant.cognizant.com/");
		Thread.sleep(5000);
		driver.findElement(By.id("i0116")).sendKeys(username);
		driver.findElement (By.id("idSIButton9")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("i0118")).sendKeys(pass);
		driver.findElement(By.id("idSIButton9")).click();
		driver.manage().window().maximize();
		Thread.sleep(mili);
		driver.findElement(By.cssSelector("div[aria-label='Submit Timesheet Opens in a new tab']")).click();
		Thread.sleep(7000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
            	//System.out.println("Inside loop");
                driver.switchTo().window(windowHandle);
                break;
            }
            //System.out.println("not yet clicked ");
            
        }
        //System.out.println(driver.getWindowHandle());
        Thread.sleep(5000); 
        driver.findElement(By.xpath("//*[(@id='win0divPTNUI_LAND_REC_GROUPLET$0')]")).click();
        Thread.sleep(5000); 
        driver.findElement(By.id("CTS_TS_LAND_PER_DESCR30$1")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("ptifrmtgtframe");
        for(int i  =0;i<5;i++) {
        int number = 738+i;
        String s = Integer.toString(number+i);
        String css = "input[tabindex='" + (738 + i) + "']";

        String a = driver.findElement(By.cssSelector(css)).getText();
       String  timeoffid = "CTS_TS_LEAVE"+String.valueOf(i+3)+"$0";//"CTS_TS_LEAVE5$0";  
        String timeoff = driver.findElement(By.id(timeoffid)).getText();
       char timeoffchar = timeoff.charAt(0);
       
       //driver.findElement(By.id("CTS_TS_LEAVE5$0"));
        int no = 8;
       if(a.length()>0) {
    	 no = 8-Integer.parseInt(a);  
       }
       else if(timeoffchar>='1' && timeoffchar<'9'){
    	  int to =timeoffchar-'0';
    	   no = 8-to;
       }
       int num2 = 539+i;
       String css2 = "input[tabindex='" + (539 + i) + "']";
       driver.findElement(By.cssSelector(css2)).sendKeys(Integer.toString(no));
        }
        driver.findElement(By.id("PB_UPDATE_2")).click();

	}

}
