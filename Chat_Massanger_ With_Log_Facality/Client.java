import java.lang.*;
import java.net.*;
import java.io.*;

class Client
{
	public static void main(String yss[])throws Exception 
	{
		System.out.println("Client appication is running........");
		String s1,s2;
		Socket s =null;
		BufferedReader brK = null,br=null;
		PrintStream ps =null;
		
		try
		{
		s = new Socket("localhost",1100);
		
		
		brK = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		ps =new PrintStream(s.getOutputStream());
		while(!(s1 = brK.readLine()).equals("Thanks"))
		{
			ps.println(s1);
			s2 = br.readLine();
			System.out.println("Server say :"+s2);
			System.out.println("Enter message for server : ");
		}
	}
	catch(Exception obj)
	{}
	try
	{
		s.close();
		br.close();	
		brK.close();
		ps.close();
	}
	catch(Exception obj)
	{}
	}

}