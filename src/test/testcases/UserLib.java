package test.testcases;

import test.resources.generic.WebLibrary;

public class UserLib extends WebLibrary{

	public static void main(String[] args) 
	{

		/*
		 * Method Name: Login
		 * Description: To login to HRM Application
		 * Input Parameters: URL,UserID,Password
		 * Output:True/False
		 * Author: Ratna
		 * Date Created: 4-Oct-2018
		 */
	}
		public static boolean Login(String URL)
		{
			Boolean loginStatus = true;
			boolean status;
			
			status = OpenUrl(URL);
			if (status)
				LogEventWithScreeshot("info","Application is up and running");
			else
				LogEventWithScreeshot("fail","Unable to launch application");
			
			return false;
			
		}
			//===============================================================================
			public static void NavigateRegister()
			{
			boolean status = true;
			SelectMenuOption("//td[@width='67']","//a[@href='mercurysignon.php']");
			if (status)
				LogEventWithScreeshot("info","Clicked on Sign on");
			else
				LogEventWithScreeshot("fail","Unable to Click on Register");
			
			status= Exist("//img[@src='/images/masts/mast_signon.gif']");
			if (status)
				LogEventWithScreeshot("pass","Page displayed successfully");
			else
			{
				LogEventWithScreeshot("fail","page is not displayed sucessful");
			}
			
			
			
			
			
	}

//===========================================================


}

