package web.flatremainder.app.F003;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.flatremainder.annotation.ModalResettable;
import web.flatremainder.common.model.MST_USER;
import web.flatremainder.config.CommonServics;
import web.flatremainder.domain.F003.F003_Service;
import web.flatremainder.domain.F003.model.F003_FindList;
import web.flatremainder.domain.F003.model.F003_Insert;
import web.flatremainder.util.DateUtil;
import web.flatremainder.util.MessageUtil;
import web.flatremainder.util.ObjectUtil;

@Controller
@RequestMapping("/disp")
@SessionAttributes("F003Form")
public class F003_Controller
{
	@ModelAttribute("F003Form")
	public F003_Form setupForm()
	{
		return new F003_Form();
	}
	
	@Autowired
	private F003_Service service;
		
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CommonServics cmnsvc;
	

	
	public String disp()
	{
		return "disp-F003";
	}

	@RequestMapping(method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String indexF003(@ModelAttribute("F003Form") F003_Form form, 
			RedirectAttributes redirect,
			Model model,
			@PathParam("user_id") String user_id)
	{		
		

		form.setUser_id(user_id);
		model.addAttribute("user_id", user_id);

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
				
		return searchRecorde(form, redirect, model);
	}
	
		
	/**
	 * 検索処理
	 */
	@RequestMapping(params="search", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String searchRecorde(@ModelAttribute("F003Form") F003_Form form, 
			RedirectAttributes redirect,
			Model model)
	{
		
		
		//期限切れフラグ更新
		cmnsvc.updExpiredFlg(form.getArticle_cls());
		
		List<F003_FindList> findList = service.findAll(form.getUser_id()).stream()
				.filter(s -> form.getArticle_cls().equals(s.getArticle_cls()))
				.filter(s -> DateUtil.dispPeriodcheck(s, form.getDisp_period()))
				.peek(s -> ObjectUtil.setArtHeaderColor(s))
				.collect(Collectors.toList());
				
				
		form.setFindList(findList);
		
		return disp();
	}
	
	/**
	 * 登録処理
	 * @param form
	 * @param result
	 * @param redirect
	 * @param model
	 * @return
	 */
	@RequestMapping(params="insert", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String insert(@ModelAttribute("F003Form") F003_Form form, 
			RedirectAttributes redirect,
			Model model)
	{
				
		F003_Insert entity = new F003_Insert();
		
		BeanUtils.copyProperties(form, entity);
		
		
		if(StringUtils.isNotEmpty(form.getIns_target_date()) && StringUtils.isNotEmpty(form.getIns_target_time()))
		{
			entity.setIns_target_datetime(DateUtil.unionDatetime(form.getIns_target_date(), form.getIns_target_time()));

		}
		
		service.insert(entity);
		
		ObjectUtil.reset(form, ModalResettable.class);
		
		return disp();
	}
	
	
	/**
	 * 
	 */
	@RequestMapping(params="rem_search", method=RequestMethod.POST, produces ="text/plain;charset=UTF-8")
	public String redirectRemSearch(@ModelAttribute("F003Form") F003_Form form, 
			RedirectAttributes redirect,
			Model model)
	{

		redirect.addAttribute("user_id", form.getUser_id());
		
		return MessageUtil.getMessage("redirect") + "rem_search";
	}


	
	


}