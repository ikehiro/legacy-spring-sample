package jp.co.kenshu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.kenshu.dto.employee.EmployeeDto;
import jp.co.kenshu.form.employee.EmployeeListForm;

@Controller
public class ValidationSampleController {
	@Autowired
	private MessageSource messageSource;

	private List<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();

	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		String title = messageSource.getMessage("employee.list.title", null, locale);
		model.addAttribute("title", title);
		model.addAttribute("message", "登録社員一覧情報を表示します");
		EmployeeListForm form = new EmployeeListForm();
		model.addAttribute("employeeListForm", form);
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	@RequestMapping(value = "/employee/list", method = RequestMethod.POST)
	public String list(@Valid @ModelAttribute EmployeeListForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "エラー");
			model.addAttribute("message", "以下のエラーを解消してください");
		} else {
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(form, dto);
			employeeList.add(dto);
			model.addAttribute("title", "社員一覧");
			model.addAttribute("message", form.getName() + "を登録しました。");
			model.addAttribute("employeeListForm", new EmployeeListForm());
		}
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}
}
