package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import test.resources.generic.WebLibrary;

public class UserLibrary extends WebLibrary{

	/*
	 * Method Name: Login
	 * Description: To login to HRM Application
	 * Input Parameters: URL,UserID,Password
	 * Output:True/False
	 * Author: Ratna
	 * Date Created: 4-Oct-2018
	 */
	
	public static boolean Login(String URL, String UID, String Password)
	{
	
		Boolean loginStatus = true;
		boolean status;
		
		status = OpenUrl(URL);
		if (status)
			LogEventWithScreeshot("info","Application is up and running");
		else
			LogEventWithScreeshot("fail","Unable to launch application");
		
		status=SetText("//input[@id='txtUsername']", UID);
		if (status)
			LogEventWithScreeshot("info","Entered UserName");
		else
			LogEventWithScreeshot("fail","Unable to enter Username");
		
		status=SetText("//input[@id='txtPassword']", Password);
		if (status)
			LogEventWithScreeshot("info","Entered password");
		else
			LogEventWithScreeshot("fail","Unable to enter password");
		
		status=ClickElement("//input[@name='Submit']");
		if (status)
			LogEventWithScreeshot("info","Clicked on Login");
		else
			LogEventWithScreeshot("fail","Unable to Click on login");
		
		wait(2);
		status= Exist("//a[contains(text(),'Welcome')]");
		if (status)
			LogEventWithScreeshot("pass","login sucessful");
		else
		{
			LogEventWithScreeshot("fail","login is not sucessful");
			loginStatus=false;
	}
			return loginStatus;
		
}	
//===============================================================================
	public static void NavigateMyLeave()
	{
	boolean stepstatus = SelectMenuOption("//a[@id='menu_leave_viewLeaveModule']","//a[@id='menu_leave_viewMyLeaveList']");
	if (stepstatus)
		LogEventWithScreeshot("pass","My Leave page displyed");
	else
	{
		LogEventWithScreeshot("fail","My Leave page not displyed");
	}
	
	}

	//===================================================================================
	public static void CancelLeave(String inp_LeaveDate)
	{
		boolean rval;
		int rownumber = VerifyLeavStatus(inp_LeaveDate, "Pending Leave");
		if (rownumber!=0)
		{
			rval = SelectOPtionByText("//table[@id='resultTable']/tbody/tr["+rownumber+"]/td[8]/select","Cancel");
		if(rval)
			LogEventWithScreeshot("info","Cancel selected in dropdown");
		else
			LogEventWithScreeshot("fail","Cancel not selected in dropdown");
			
			
		}
		else
		{
			LogEventWithScreeshot("fail","Leave date with status Pending Approval not found");
	}
	}
//================================================================================================
		public static int VerifyLeavStatus(String Leavedate, String Leavestatus)
		{

			int rownum = 0;
			try{
			int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
			for(int iRow=1; iRow<=rowCount;iRow++)
			{
				String appDate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[1]")).getText();
				String appSatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[6]")).getText();
			if ((appDate.equals(LeaveDate))&&(appSatus.contains(Leavestatus)))
			{
			
				rownum = iRow;
				break;
			}
			}
			}
			
			catch(Exception e)
			{
				rownum = 0;
			}
				return rownum;
				
		}
	//====================================================================================
	/*public static void CancelLeave(String inp_LeaveDate)
	{
		boolean bTag = false;
		try{
		int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		for(int iRow=1; iRow<=rowCount;iRow++)
		{
			String appDate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[1]")).getText();
			String appSatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[6]")).getText();
		if ((appDate.equals(inp_LeaveDate))&&(appSatus.contains("Pending Approval")))
		{
			WebElement dropdown = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[8]/select"));
			Select obj = new Select(dropdown);
			obj.selectByVisibleText("Cancel");
			bTag = true;
			break;
		}
		}
		}
		
		catch(Exception e)
		{
			bTag = false;
			
		}
	if(bTag)
		LogEventWithScreeshot("info","Cancel selected in dropdown");
	else
		LogEventWithScreeshot("fail","Cancel not selected in dropdown");
	
		}*/

	//==================================================================================
	
	/*public static boolean Save (String ObjectXpath,String Text)
	{
		boolean Savestatus = true;
		boolean status;
		{
		status=ClickElement("//input[@id='btnSave']");
		if (status)
			LogEventWithScreeshot("info","Clicked on save button");
		else
			LogEventWithScreeshot("fail","Unable to Click on save button");
		
		wait(2);
		status= Exist("//a[contains(text(),'Cancelled')]");
		if (status)
			LogEventWithScreeshot("pass","saved sucessful");
		else
		{
			LogEventWithScreeshot("fail","unable to save sucessful");
			Savestatus = false;
	}
			return Savestatus;
		
	}
	}*/
//=================================================================================================	
		public static void NavigateApplyLeave()
		{
		boolean stepstatus = SelectMenuOption("//a[@id='menu_leave_viewLeaveModule']","//a[@id='menu_leave_applyLeave']");
		if (stepstatus)
			LogEventWithScreeshot("pass","Apply Leave page displyed");
		else
			LogEventWithScreeshot("fail","Apply Leave page not displyed");
		}
		
		//===========================================================
		
		//verify the font size of the  text "Apply Leave" heading
		//string fontsize=driver.findElement(By.xpath("//h1[text().'Applyleave'"])).getvalue("fontsize");
		
		public static void ApplyLeave (String Leavetype,String startdate,String enddate , String comment)
		{
		
			Boolean ApplyLeave = true;
			boolean bvalue;
			
			
			bvalue = SelectOPtionByText("//select[@id='applyleave_txtLeaveType']",Leavetype);
			if (bvalue)
				LogEventWithScreeshot("info","Leave type selected");
			else
				LogEventWithScreeshot("fail","Leave type not selected");
		 
		//select start date
				bvalue = SetTextAndEscape("//input[@id='applyleave_txtFromDate']", startdate);
				if(bvalue)
					LogEventWithScreeshot("info","start date entered");
				else
					LogEventWithScreeshot("fail","start date not enetered");
				
		//select end date
				bvalue = SetTextAndEscape("//input[@id='applyleave_txtToDate']", enddate);
				if(bvalue)
					LogEventWithScreeshot("info","end date entered");
				else
					LogEventWithScreeshot("fail","end date not enetered");
				//select string comment
				
				bvalue = SetText("//textarea[@id='applyleave_txtComment']", comment);
				if(bvalue)
					LogEventWithScreeshot("info","comments entered");
				else
					LogEventWithScreeshot("fail","comments not enetered");
				
				//click Apply
				bvalue = ClickElement("//input[@id='applyBtn']");
				if(bvalue)
					LogEventWithScreeshot("info","Apply button clicked");
				else
					LogEventWithScreeshot("fail","Apply button not clicked");
				
				//====================================================
				
				if(Exist("//div[class='message success fadable']"))
					LogEventWithScreeshot("info","Leave applied Successfully");
				else
					LogEventWithScreeshot("fail","unable to apply Leave");
		 }
		
		
		 //===========================================================
		public static int verifyDaterangestatus(String FromDate,String Todate,String LeaveStatus)
		{

			int rownum = 0;
			try{
			int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
			for(int iRow=1; iRow<=rowCount;iRow++)
			{
				String ActDateRange;
				ActDateRange= FromDate+"to"+Todate;
				String appDate = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[1]")).getText();
				String appSatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[6]")).getText();
			if ((appDate.equals(ActDateRange))&&(appSatus.contains(LeaveStatus)))
			{
			
				rownum = iRow;
				break;
			}
			}
			}
			
			catch(Exception e)
			{
				rownum = 0;
			}
				return rownum;
		
		}


		//================================================================================
			public static void SelectCheckbox()
			{
			boolean bvalue = true;
			
			SelectMenuOption("//label[@for='leaveList_chkSearchFilter_0']", "//input[@id='leaveList_chkSearchFilter_0']");
			if (bvalue)
			{
				LogEventWithScreeshot("info", " Cancelled check box is selected");
			}
			else
			{
				LogEventWithScreeshot("fail", " Cancelled check box is not selected");
			}
			
			//============================================================================
			//click Search
			bvalue = ClickElement("//input[@id='btnSearch']");
			
			
			if(bvalue)
			{
				LogEventWithScreeshot("info","Search button clicked");
			}
			else
			{
				LogEventWithScreeshot("fail","Search button not clicked");
			}
			
			}




//===================================================================================
					
					private static void DisplayMyLeavestatus() 
					{
					
					int rownum = 0;
					
					int rowCount = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
					for(int iRow=1; iRow<=rowCount;iRow++)
					{
						
				String appSatus = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+iRow+"]/td[6]")).getText();
				if (!(appSatus.equals(LeaveStatus)))
					{
					
						rownum = iRow++;
						LogEventWithScreeshot("count is:","+Cancelled");
						break;
					}
					}
					}
					
				
					
				
	
	
}	

				
				
				
			

		
	