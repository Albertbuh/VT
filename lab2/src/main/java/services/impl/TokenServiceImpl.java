package services.impl;

import beans.User;
import org.apache.commons.codec.binary.Hex;
import services.ServiceException;
import services.TokenService;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenServiceImpl implements TokenService {
    private final String header = encodeBase64("aboba");
    private final String secret = "1234";

    @Override
    public String create(User user) throws ServiceException {
        String payload = "name: " + user.getLogin() + "pass: " + user.getPassword();
        payload = encodeBase64(payload);
        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append('.');
        sb.append(payload);
        sb.append('.');
        sb.append(encodeBase64(secret));
        return sb.toString();
    }

    @Override
    public String getSecret(String token) throws ServiceException{
        String base64Secret = token.split("\\.")[2];
        return decodeBase64(base64Secret);
    }

    private String encodeBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decodeBase64(String data) {
        return new String(Base64.getDecoder().decode(data), StandardCharsets.UTF_8);
    }
    private String createSignature(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

}
