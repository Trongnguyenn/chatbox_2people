import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws UnknownHostException, IOException  {
        Socket s= new Socket("localhost", 3333);

        // truyen thong tin client va server

        DataInputStream in= new DataInputStream(s.getInputStream());
        DataOutputStream out= new DataOutputStream(s.getOutputStream());

        Scanner scanner = new Scanner(System.in); // lenh nhap tu ban phim

        while (true){
            //doc tin nhan tu ban phim va truyen du lieu len server
            String str = scanner.nextLine();
            out.writeUTF(str);
            out.flush();
            System.out.println("client say: "+ str);

            //neu nhap quit thi dung
            if (str.equals("quit")){
                break;
            }

            // client nhan tu nhan tu server
            String str2= in.readUTF();
            System.out.println("server say: "+str2);
        }

        in.close();
        out.close();
        s.close();

    }
}
