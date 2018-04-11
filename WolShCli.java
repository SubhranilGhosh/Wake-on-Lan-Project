import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class WolShCli
{
  public static void main(String[] args) throws IOException{

    BufferedReader cmdrdr =
    new BufferedReader(new InputStreamReader(System.in));

    DatagramSocket cliskt = new DatagramSocket();
    String ip = args[0];
    InetAddress IPAddress = InetAddress.getByName(ip);
    byte[] sData = new byte[1024];
    String cmd = cmdrdr.readLine();
    sData = cmd.getBytes();
    DatagramPacket sPkt =
   new DatagramPacket(sData, sData.length, IPAddress, 3333);
   cliskt.send(sPkt);
   System.out.println("CMD SENT");
}
}
