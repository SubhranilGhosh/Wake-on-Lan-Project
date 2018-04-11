import java.io.*;
import java.net.*;
public class WakeUp{
  public static final int PORT = 9;
  public static void main(String[] args) {
    try{
    String ip = args[0];
    InetAddress bcast = InetAddress.getByName(ip);
    String macs[] = {"40:b8:9a:39:cf:a1","30-F9-ED-D0-5F-BD"};
    int l = macs.length;
    int i,j;
    for(i=0;i<l;i++)
    {
      byte[] tmb = ctb(macs[i]);
      byte[] bdata = new byte[6 + 16 * tmb.length];
      for (j = 0; j < 6; j++) {
          bdata[j] = (byte) 0xff;
      }
      for(j=6;j<bdata.length;j+=tmb.length)
      {
        System.arraycopy(tmb,0,bdata,j,tmb.length);
      }
      DatagramPacket pkt = new DatagramPacket(bdata,bdata.length,bcast,PORT);
      DatagramSocket skt = new DatagramSocket();
      skt.send(pkt);
      System.out.println("Wake-on-LAN packet sent for -->  "+ macs[i]);
      skt.close();
    }}
    catch (Exception e) {
        System.out.println("Failed to send Wake-on-LAN packet:  " + e);
        System.exit(1);
    }
  }

  private static byte[] ctb(String macadd) throws IllegalArgumentException{
    byte[] bt = new byte[6];
    String[] hexadd = macadd.split("(\\:|\\-)");
    if (hexadd.length != 6) {
        throw new IllegalArgumentException("Invalid MAC address.");
    }
    for (int i = 0; i < 6; i++) {
        bt[i] = (byte) Integer.parseInt(hexadd[i], 16);
    }
    return bt;
  }
}
