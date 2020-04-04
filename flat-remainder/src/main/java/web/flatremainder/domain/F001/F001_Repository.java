package web.flatremainder.domain.F001;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import web.flatremainder.domain.F001.model.F002_Insert;

public interface F001_Repository
{

	public int insertUser(F002_Insert insertEntity) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
}
