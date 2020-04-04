package web.flatremainder.domain.F001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.flatremainder.domain.F001.model.F002_Insert;
import web.flatremainder.exception.UpdateException;

@Service
public class F001_ServiceImpl implements F001_Service
{
	@Autowired
	private F001_Repository repository;

	@Transactional
	public void insertUser(F002_Insert insertEntity)
	{

		try
		{
			repository.insertUser(insertEntity);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			throw new UpdateException();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
