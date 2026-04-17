import java.io.*;
import java.net.*;

class ChatServerXX
{
    public static void main(String A[]) throws Exception
    {
        ServerSocket ssobj = new ServerSocket(5100);
        System.out.println("Marvellous server is waiting at port number 5100");

        Socket sobj = ssobj.accept();
        System.out.println("Marvellous Server successfully connected with the client");
    
        PrintStream pobj = new PrintStream(sobj.getOutputStream());
        
        BufferedReader bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader bobj2 = new BufferedReader(new InputStreamReader(System.in));

        FileWriter fwobj = new FileWriter("MarvellousServer.txt", true);
        BufferedWriter bwobj = new BufferedWriter(fwobj);
    
        System.out.println("-----------------------------------------------");
        System.out.println("Marvellous chat messanger is ready to use");
        System.out.println("-----------------------------------------------");
        
        String str1 = null, str2 = null;
    
        while((str1 = bobj1.readLine()) != null)
        {
            if(str1.equals("end"))
            {
                System.out.println("Client ended the chat");
                break;
            }

            System.out.println("Client says : " + str1);

            bwobj.write("Client: " + str1);
            bwobj.newLine();
            bwobj.flush();

            System.out.println("Enter the message for client : ");
            str2 = bobj2.readLine();

            pobj.println(str2);

            bwobj.write("Server: " + str2);
            bwobj.newLine();
            bwobj.flush();
        }

        bwobj.close();
        sobj.close();
        ssobj.close();

        System.out.println("Chat ended and saved successfully");
    }
}