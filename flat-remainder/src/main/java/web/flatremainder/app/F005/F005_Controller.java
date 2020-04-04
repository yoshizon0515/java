package web.flatremainder.app.F005;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.flatremainder.common.model.MST_USER;
import web.flatremainder.domain.F005.F005_Service;
import web.flatremainder.util.MessageUtil;
import web.flatremainder.util.ObjectUtil;

@Controller
@SessionAttributes("F005Form")
@RequestMapping("/search")
public class F005_Controller
{
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private F005_Service service;
	
	
	@ModelAttribute("F005Form")
	public F005_Form setForm()
	{
		return new F005_Form();
	}
	
	public String disp()
	{
		return "search-F005";
	}
	
	
	@RequestMapping(params="/{user_id}", method= RequestMethod.GET)
	public String index(@ModelAttribute("F005Form") F005_Form form,
			 RedirectAttributes redirect,
			 Model model,
			 @PathVariable("user_id") String user_id
			 )
	{
		
		form.setUser_id(user_id);

		try
		{
			
			model.addAllAttributes(ObjectUtil.dispUserNm((MST_USER)session.getAttribute(form.getUser_id())));
		}
		catch(Exception e)
		{
			return MessageUtil.getMessage("redirect") + "login";
		}
		
		//セレクトボックスをセットする。
		service.setSelectBpx(form);
		//セレクトボックス初期値
		service.setFirstValue(form);

		
		return disp();
	}

}
