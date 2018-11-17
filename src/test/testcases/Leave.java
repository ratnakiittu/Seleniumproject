package test.testcases;

import org.openqa.selenium.By;

public class Leave extends UserLibrary{

public static void TC01_Leave_CancelLeave()
{
		//Step 1: Login as Team member
		Login(URL,UserName, Password);
		
		//Step 2: Navigate to My Leave Page
		NavigateMyLeave();
		
		//Step 3: Search for leave in Leave table with status pending then select cancel
		CancelLeave(LeaveDate);
		
		//Step 4: Click Save and verify leave is cancelled
		boolean retval = ClickElement("//input[@id='btnSave']");
		if (retval)
			LogEventWithScreeshot("info","Clicked on save button");
		else
			LogEventWithScreeshot("fail","Unable to Click on save button");
		
		int rownumber = VerifyLeavStatus(LeaveDate, "Cancelled");
		if (rownumber!=0)
			LogEventWithScreeshot("info","Leave is cancelled successfully");
		else
			LogEventWithScreeshot("fail","Leave is cancelled");
}
		
		public static void TC02_ApplyandVerifyinmyLeave()
		{
				//Step 1: Login as Team member
				Login(URL,UserName, Password);
				
				//Step 2:Navigate to Apply leave page
				NavigateApplyLeave();
				
				//Step 3: Enter Leave details and click Apply
				ApplyLeave("Personal Leave","2018-11-19","2018-11-20","Sick lkg");
				// Step 4: Verify Leave status
				int rownum = verifyDaterangestatus(FromDate,Todate, LeaveStatus);
				if (rownum!=0)
					LogEventWithScreeshot("info","Leave applied is verified Succcessfully");
				else
					LogEventWithScreeshot("info","Leave applied is not verified");
		}
		//===================================================================
				public static void TC03_selectCheckbox()
				{
					
					//Step 1: Login as Team member
					Login(URL,UserName, Password);
					
					//Step 2: Navigate to My Leave Page
					NavigateMyLeave();
					
					//Step 3 Disable Checkbox
					boolean bvalue = true;
					driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck")).click();
					if (bvalue)
						LogEventWithScreeshot("info", " All check box is Disable");
					else
						LogEventWithScreeshot("fail", " All check box is enabled");
				
					//Step 4: Select check box
					SelectCheckbox();
					
					//step 5: display all cancelled
					
					
					
}
}


	


