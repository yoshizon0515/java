package web.flatremainder.app.F002;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.flatremainder.domain.F002.F002_Service;
import web.flatremainder.domain.F003.model.F003_Insert;
import web.flatremainder.util.ObjectUtil;

@Controller 
@RequestMapping("/insert")
@SessionAttributes("F002Form")
public class F002_Controller
{
	@Autowired
	private F002_Service service;
		
	@ModelAttribute("F002Form")
	public F002_Form setupForm()
	{
		return new F002_Form();
	}
		
	@ResponseStatus
	@RequestMapping(method=RequestMethod.GET)
	public String index(@ModelAttribute("F002Form") F002_Form form, 
			RedirectAttributes redirect,
			Model model,
			@PathVariable("user_id") String user_id,
			@PathVariable("article_cls") String article_cls)
			
	{
		ObjectUtil.reset(form);
		
		service.setSelectBpx(form);
		
		form.setUser_id(user_id);
		//form.setArticle_cls(article_cls);
		
		service.setFirstValue(form);
		
		model.addAttribute("F002dispModal", true);
		
				
		return "";
	}
	
	/**
	 * 登録処理
	 * @param form
	 * @param result
	 * @param redirect
	 * @param model
	 * @return
	 */
	@ResponseStatus
	@RequestMapping(params="insert", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String insert(@ModelAttribute("F002Form") F002_Form form, 
			RedirectAttributes redirect,
			Model model)
	{
		
		F003_Insert entity = new F003_Insert();
		
		BeanUtils.copyProperties(form, entity);
		
		
/*		if(StringUtils.isNotEmpty(form.getTarget_date()) && StringUtils.isNotEmpty(form.getTarget_time()))
		{
			entity.setTarget_datetime(DateUtil.unionDatetime(form.getTarget_date(), form.getTarget_time()));

		}
*/		
		//service.insert(entity);
		
		return null;
	}


}
