import java.net.*;
import java.io.*;

class ChatClientXX
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Client is ready to connect with server");

        Socket sobj = new Socket("localhost",5100);
        System.out.println("Marvellous client is successfully connected with server");
    
        PrintStream pobj = new PrintStream(sobj.getOutputStream());

        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        FileWriter fwobj = new FileWriter("MarvellousClient.txt", true);
        BufferedWriter bwobj = new BufferedWriter(fwobj);

        System.out.println("-----------------------------------------------");
        System.out.println("Marvellous chat messanger is ready to use");
        System.out.println("-----------------------------------------------");
    
        String str1 = null, str2 = null;

        while((str1 = bobj2.readLine()) != null && !str1.equals("end"))
        {
            pobj.println(str1);

            bwobj.write("Me: " + str1);
            bwobj.newLine();
            bwobj.flush();

            str2 = bobj1.readLine();

            System.out.println("Server says : " + str2);

            bwobj.write("Server: " + str2);
            bwobj.newLine();
            bwobj.flush();

            System.out.println("Enter message for server : ");
        }

        bwobj.close();
        sobj.close();

        System.out.println("Chat ended and saved successfully");
    }
}