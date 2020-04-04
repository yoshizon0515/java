package web.flatremainder.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号化メソッドが登録してあるクラス
 * 
 * @author ryota
 *
 */
public class CryptUtil
{

	public static String encrypt(String source) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance(MessageUtil.getMessage("algorithm"));
		cipher.init(Cipher.ENCRYPT_MODE,
				new SecretKeySpec(MessageUtil.getMessage("cryptkey").getBytes(), MessageUtil.getMessage("algorithm")));
		return new String(Base64.getEncoder().encode(cipher.doFinal(source.getBytes())));
	}

	public static String decrypt(String encryptSource) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance(MessageUtil.getMessage("algorithm"));
		cipher.init(Cipher.DECRYPT_MODE,
				new SecretKeySpec(MessageUtil.getMessage("cryptkey").getBytes(), MessageUtil.getMessage("algorithm")));
		return new String(cipher.doFinal(Base64.getDecoder().decode(encryptSource.getBytes())));
	}

	public static boolean checkPassword(String rawPassword, String cryptPassWord) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{

		return decrypt(cryptPassWord).equals(rawPassword);
	}

}
