
package clientdeneme;
import java.io.*;
import java.util.ArrayList;
public class Dataset1 
{
	
	public static  ArrayList<String> veri = new ArrayList<>();
	public static ArrayList<String> lat_long = new ArrayList<>();

	public static void VeriCekme()
	{
	
	String str;
	
	try {
		
		FileInputStream fstream = new FileInputStream("C:\\Users\\alick\\eclipse-workspace\\YazLab_2_1\\latlong.txt");
		DataInputStream dstream = new DataInputStream(fstream);
		BufferedReader breader = new BufferedReader(new InputStreamReader(dstream));
		
		
		while((str = breader.readLine()) !=null)
		{
			
				veri.add(str);
			
		}
		
		
		
		
		for (int i = 0; i < veri.size(); i++) 
		{
			
			//lat_long.add(veri.get(i).split(","));
			String sp[] = veri.get(i).split(",");
			for(int j=0;j<1;j++)
		{
			lat_long.add(sp[0]+","+sp[1]);
		}
			//System.out.println(lat_long.get(i));
			
		}
		
		
		
		
		
		dstream.close();
		
	}catch (Exception e)
	{
		System.err.println("Hata: "+e.getMessage());
	}
	
	
	}

}