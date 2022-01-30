package hmac_sha256;

import org.junit.Test;
import javax.crypto.Mac;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.spi.DirStateFactory.Result;

import java.security.NoSuchAlgorithmException;
import java.security.DrbgParameters.Reseed;

import static org.junit.Assert.assertEquals;

import java.security.InvalidKeyException;

public class HamcSha256Test {
    
    @Test
    public void GenerateHamcSha256Test() throws NoSuchAlgorithmException, InvalidKeyException{

        String algo = "HmacSHA256";
        String text = "Hello";
        String secretKey = "key";

        SecretKeySpec sk = new SecretKeySpec(secretKey.getBytes(), algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(sk);

        byte[] mac_bytes = mac.doFinal(text.getBytes());

        StringBuilder sb = new StringBuilder(2 * mac_bytes.length);
        for(byte b: mac_bytes) {
                sb.append(String.format("%02x", b&0xff) );
        }
        assertEquals("c70b9f4d665bd62974afc83582de810e72a41a58db82c538a9d734c9266d321e", sb.toString());

    }
}
