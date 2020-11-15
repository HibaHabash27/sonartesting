package home_search;

import static org.mockito.Mockito.*;

public class MockEmailHolder {
    private  WebEmailservice emailservice=mock(WebEmailservice.class);
	public MockEmailHolder(Search  home)
	{
		home.setemail(emailservice);
	}
	
	
	public WebEmailservice getEmail()
	{
		return emailservice;
		
	}

  
}
