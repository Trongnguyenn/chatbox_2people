import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException  {
        ServerSocket ss= new ServerSocket(3333);
        Socket s= ss.accept();
        System.out.println(" CONNECTED !");

        // truyen thong tin client va server

        DataInputStream in= new DataInputStream(s.getInputStream());
        DataOutputStream out= new DataOutputStream(s.getOutputStream());

        Scanner scanner = new Scanner(System.in);

        while (true){
            // doc tin nhan cua client
            String str = in.readUTF();
            System.out.println("client say: "+str);

            if (str.equals("quit")){
                break;
            }
            // server truyen tin nhan lai cho client
            String str2= scanner.nextLine();
            out.writeUTF(str2);
            out.flush();
            System.out.println("server say: "+str2);
        }
        in.close();
        out.close();
        s.close();
        ss.close();


    }
}
