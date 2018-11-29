package home.ip;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static home.StringUtil.toBinaryString;

/*
 Represent an internet v4 address, internally a 32 bit integer but externally
 represented as a string by four dot-separted decimal "octets" (0-255).

 https://www.quora.com/What-do-the-numbers-in-an-IP-adress-represent
*/
public class Ip {
    static final short RADIX = 2; // internally represented as binary
    enum IpClass {  A, B, C  };

    private final String[] octets; // decimal string octets


    /* API */

    Ip(String address) throws IpInvalidException {
        this.octets = validate(address);
    }

    public Long getIpAddress() {
        return toIpAddress();
    }

    @Override
    public String toString() {
        return Arrays.stream(this.octets).collect(Collectors.joining("."));
    }

    // String getNetwork() {return "";} // mask based on class A, B or C

    // String getHost() {return "";}



    /* Logic, validation */

    private String[] validate(String address) throws IpInvalidException {

        final String message = "String does not represent a valid ipv4";

        // correct number of octets (or malformed generally)
        String[] octets = address.split("\\.");
        if (octets.length != 4)
            throw new IpInvalidException(message);

        // and all numbers
        try {
            for (String octet : octets) {
                Integer.parseInt(octet);
            }
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            throw new IpInvalidException(message + ": octet malformed");
        }

        // and all in range 0-255 decimal
        if (! Arrays.stream(octets).map(Integer::parseInt).allMatch(i -> i >= 0 && i <= 255) )
            throw new IpInvalidException(message + ": octet out of bound");

        return octets;
    }

    private Long toIpAddress() { // TODO this relies on Java for binary conversion

        // map over the octets, converting to and concatenating as binary string, then to number
        String binaryString = Arrays.stream(this.octets)
                .map(Integer::parseInt)
                .map(o -> toBinaryString(o))
                .collect(Collectors.joining());

        return Long.parseLong(binaryString, RADIX);
    }

}

