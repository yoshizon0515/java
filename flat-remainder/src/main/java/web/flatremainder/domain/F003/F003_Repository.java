package web.flatremainder.domain.F003;

import java.util.List;

import web.flatremainder.domain.F003.model.F003_FindList;
import web.flatremainder.domain.F003.model.F003_Insert;

public interface F003_Repository
{
		
	public List<F003_FindList> findAll(String user_id);
	
	public int insert(F003_Insert entity);



}
