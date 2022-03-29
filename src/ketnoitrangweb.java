import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ketnoitrangweb {
    public static void main(String[] args) throws UnknownHostException {
        while (true){
            Scanner scanIn= new Scanner(System.in);
            String ServerAddr = "";

            System.out.println("\n please enter the page's address");
            ServerAddr = scanIn.nextLine();

            boolean stop= ServerAddr.equalsIgnoreCase("exit");
            if(stop){ break; }

            try{

                InetAddress host = InetAddress.getByName(ServerAddr);
                String ip = host.getHostAddress();

                System.out.println("\nThe IP Address is:");
                System.out.println(ip);

            }
            catch(UnknownHostException e){
                System.out.println("Address Non-exist");
            }

            catch(Exception e){
                System.out.println("System Error");
            }


        }
        System.exit(0);
    }
}

