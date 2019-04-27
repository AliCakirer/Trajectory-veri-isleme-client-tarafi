
package clientdeneme;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Client {
       public static void main(String[] args) throws IOException {
 
            int gidenveri_Size,sizeof_gelenveri;	
            Socket socket = null;
            PrintWriter out = null;
            BufferedReader in = null;
            ArrayList<String> gelen_indirgenmis_Veri=new ArrayList<>();
            
                
                Dataset1.VeriCekme();
 
		try {
			socket = new Socket("localhost", 5555); // "localhost" ya da sunucu IP adresi
                        // input stream ve output stream yaratılıyor...
                        out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        
		} catch (UnknownHostException e) {
			System.err.println("Sunucu bulunamadı");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("I/O exception:" + e.getMessage());
			System.exit(1);
		}
		System.out.println("Sunucuya baglanildi.");
		// klavyeden girdi: stdIn
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput,inputLine;
		System.out.println("Servera yapmasi icin bir komut gonder");
                while (!(userInput = stdIn.readLine()).equals("3")) {
			if(userInput.equals("1"))
                        {
                            Dataset1 veri=new Dataset1();
                            out.println(userInput);
                            System.out.println(in.readLine());
                            gidenveri_Size=veri.lat_long.size();
                            
                            out.println(Integer.toString(gidenveri_Size));
                            //System.out.println(veri.lat_long.size());
                            for (int i = 0; i <veri.lat_long.size() ; i++) {
                                out.println(veri.lat_long.get(i));
                                in.readLine();
                            }// Bütün verileri yolladık.
                            
                                inputLine=in.readLine();
				sizeof_gelenveri=Integer.parseInt(inputLine);
				System.out.println(sizeof_gelenveri);
                            for(int l=0;l<sizeof_gelenveri;l++)
				{
					inputLine=in.readLine();
					out.println("aldım");
					gelen_indirgenmis_Veri.add(inputLine);
					
				}
                            System.out.println(gelen_indirgenmis_Veri.get(1));
                            
                            
                            
                            
                            System.out.println(in.readLine());
                            
                            
                            /*System.out.println(in.readLine());
                            out.println(Dataset1.veri);
                            System.out.println(in.readLine());
                            */
                            /*out.println(userInput);
                            out.println("indirgeme Yapar mısın?");
                            System.out.println(in.readLine());
                            System.out.println(in.readLine());
                          */
                            
                        }
                        
                        
                        if (userInput.equals("2")) {
                        out.println(userInput);
                        
                        System.out.println(in.readLine());
                            System.out.println(in.readLine());
                    }
                   
		}
		System.out.println("Baglanti kesiliyor...");
 
		out.close();
		in.close();
		stdIn.close();
		socket.close();
	}
}