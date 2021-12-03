import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PKCEexample {
    public static void main(String [] args){
        try {
            PkceUtil pkce = new PkceUtil();

            String codeVerifier = pkce.generateCodeVerifier();
            System.out.println("Code Verifier : \n"+ codeVerifier);

            String codeChallenge = pkce.generateCodeChallenge(codeVerifier);
            System.out.println("Code Challenge : \n"+ codeChallenge);

        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException ex){
            Logger.getLogger(PKCEexample.class.getName()).log(Level.SEVERE, null ,ex);
        }
    }
}
