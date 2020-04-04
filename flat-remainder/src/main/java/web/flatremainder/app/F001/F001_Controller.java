package web.flatremainder.app.F001;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.flatremainder.common.model.MST_USER;
import web.flatremainder.config.CommonServics;
import web.flatremainder.domain.F001.F001_Service;
import web.flatremainder.domain.F001.model.F002_Insert;
import web.flatremainder.util.CryptUtil;
import web.flatremainder.util.MessageUtil;
import web.flatremainder.util.ObjectUtil;

@Controller
@RequestMapping("/login")
@SessionAttributes("F001Form")
public class F001_Controller
{

	@Autowired
	private CommonServics logSvc;

	@Autowired
	private F001_Service service;
	
	@Autowired
	private HttpSession session;

	
	@ModelAttribute("F001Form")
	public F001_Form formSet()
	{
		return new F001_Form();
	}


	public String disp()
	{
		return "login-F001";
	}

	@RequestMapping(method = RequestMethod.GET )
	public String index(@ModelAttribute F001_Form form, RedirectAttributes redirect)
	{

		ObjectUtil.reset(form);
		return disp();
	}

	@RequestMapping(params = "login_btn", method = RequestMethod.POST)
	public String login(@ModelAttribute("F001Form") F001_Form form, Model model,
			RedirectAttributes redirect)
	{

		return loginProcces(form.getLogin_id(), form.getLogin_pass(), redirect);

	}

	@RequestMapping(params = "insert-btn", method = RequestMethod.POST)
	public String insert_modal(@ModelAttribute("F001") F001_Form form,  Model model,
			RedirectAttributes redirect)

	{

		// ID登録時にかぶってたらエラーを発生させる
		MST_USER entity = logSvc.getUserEntityOne(form.getInsert_id());

		if (entity != null)
		{
			// ログイン不正 すでにIDが登録されている
			return disp();

		} else
		{

			F002_Insert insertEntity = new F002_Insert();

			BeanUtils.copyProperties(form, insertEntity);

			try
			{
				service.insertUser(insertEntity);
				return loginProcces(insertEntity.getInsert_id(), insertEntity.getInsert_password(), redirect);

			} catch (RuntimeException e)
			{
				System.out.println("登録失敗");
				return disp();
			}

		}

	}

	public String loginProcces(String id, String pw, RedirectAttributes attribute)
	{

		try
		{
			MST_USER entity = logSvc.getUserEntityOne(id);

			if (CryptUtil.checkPassword(pw, entity.getLogin_pass()))
			{

				// 最終ログイン日時更新
				logSvc.updLastLogindate(id);
				session.setAttribute(entity.getUser_id(), entity);
				
				attribute.addAttribute("user_id", entity.getUser_id());
				
				return MessageUtil.getMessage("redirect") + "disp";

			} else
			{
				System.out.println("パスワード誤り ログイン失敗");
				return disp();
			}

		} catch (NullPointerException e)
		{
			e.printStackTrace();
			return disp();

		} catch (Exception ex)
		{
			ex.printStackTrace();
			return disp();

		}

	}

}
