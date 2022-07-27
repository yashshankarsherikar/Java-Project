import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;



class Server
{
	public static void main(String yss[])
	{
		try
		{
			System.out.println("Server appication is running........");
			String s1,s2;
			
			
			// Get a Calendar and set it to the current time.
			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.from(Instant.now()));

		
			String result = String.format("%1$tY-%1$tm-%1$td %1$tk-%1$tM%1$tp.txt", cal);
		
            File fobj=new File(result);
            boolean bobj = fobj.createNewFile();
			
			FileWriter fw=new FileWriter(fobj);


			ServerSocket ss = new ServerSocket(1100);
			Socket s = ss.accept();
		
			System.out.println("Connection succesful");
			BufferedReader brK = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream ps =new PrintStream(s.getOutputStream());
			while((s1 = br.readLine())!=null)
			{
				System.out.println("Client Says :"+s1);
				String backup = s1;
				
				System.out.println("Enter massage for");
				s2 =brK.readLine();
				 
				fw.write("                               "+backup+"(you)\n\n");
				fw.write(s2+"(Server)\n\n");
				
				
				ps.println(s2);
			}
			s.close();
			ss.close();
			br.close();
			brK.close();
			ps.close();
			fw.close();
		}
		catch(IOException obj)
		{
			System.out.println(obj);
		}
	
	
	}
}