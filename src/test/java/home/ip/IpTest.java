package home.ip;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IpTest {

    private Map<String, Long> addresses = new HashMap<>();

    @Before
    public void setup() {
        addresses.put("192.168.0.1", 3232235521L);
        addresses.put("192.168.1.1", 3232235777L);
    }


    @Test
    public void testToNumber() throws Exception {
        for (String address : addresses.keySet()) {
            Ip ip = new Ip(address);
            assertEquals(ip.getIpAddress(), addresses.get(address));
        }
    }

    @Test
    public void testToString() throws Exception {
        for (String address : addresses.keySet()) {
            Ip ip = new Ip(address);
            assertEquals(ip.toString(), address);
        }
    }

    @Test(expected = IpInvalidException.class)
    public void testTooManyOctetsFormatInvalid() throws Exception {
        new Ip("192.168.0.1.1"); // 4 octets required
    }

    @Test(expected = IpInvalidException.class)
    public void testOctetsBoundFormatInvalid() throws Exception {
        new Ip("256.168.0.1"); // octet 0-255 base 10 required
    }

    @Test(expected = IpInvalidException.class)
    public void testFormatInvalidThrows() throws Exception {
        new Ip("abc.168.0.1"); // numerical only
    }

    @Test
    public void testMinValue() throws Exception {
        assertEquals(new Ip("0.0.0.0").getIpAddress().longValue(), 0L);
    }

    @Test
    public void testMaxValue() throws Exception {
        assertEquals(new Ip("255.255.255.255").getIpAddress().longValue(), 4294967295L);
    }


}
