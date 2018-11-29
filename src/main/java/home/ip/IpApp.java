package home.ip;

public class IpApp {
    public static void main(String[] args) {
        Ip ip, ip2, ip3 = null;
        try {

            ip = new Ip("192.168.0.1");
            ip2 = new Ip("0.0.0.0");
            ip3 = new Ip("255.255.255.255");

            System.out.println(ip.toString() + " => " + ip.getIpAddress());
            System.out.println(ip2.toString() + " => " + ip2.getIpAddress());
            System.out.println(ip3.toString() + " => " + ip3.getIpAddress());

        } catch (IpInvalidException e) {
            e.printStackTrace();
        }
    }
}
