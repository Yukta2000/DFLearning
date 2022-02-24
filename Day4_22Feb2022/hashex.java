import java.security.*;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;

public class hashex {
    private static String getHash(String password) throws NoSuchAlgorithmException,InvalidKeySpecException,NoSuchProviderException {  
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt,100,128);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return hash.toString();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException,InvalidKeySpecException,NoSuchProviderException
    {
        String password_hash = getHash("Yukta");
        System.out.println("Hash for the password is : "+ password_hash);
        
    }
}
