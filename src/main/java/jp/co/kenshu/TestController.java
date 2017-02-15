package jp.co.kenshu;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.kenshu.form.Sex;
import jp.co.kenshu.form.TestForm;
import jp.co.kenshu.form.TestFormDetail;

@Controller
public class TestController {
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showMessage(Model model) {
		TestForm form = new TestForm();
		form.setId(0);
		form.setName("ここに名前を書いてね");
		form.setEmployees(new String[] { "次郎" });
		form.setRadio("バナナ");
		// FIXME デフォルトが選択されない。バナナ。
		model.addAttribute("checkEmployees", getCheckEmployees());
		model.addAttribute("checkRadioEmployees", getCheckRadiokEmployees());

		model.addAttribute("sexoption", getSexOption());

		model.addAttribute("testForm", form);
		model.addAttribute("message", "FORMの練習");
		model.addAttribute("messageCheckBox", "checkのサンプル");
		return "showMessage";
	}




	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String getFormInfo(@ModelAttribute TestForm form, Model model) {
		model.addAttribute("message", "ID : " + form.getId() + " & name : " + form.getName());

		/* 明細部分の入力情報編集 */
		TestFormDetail[] details = form.getDetails();
		String messageDetail = "";
		for (TestFormDetail detail : details) {
			messageDetail += "SEQ : " + detail.getSeq() + " & productName : " + detail.getProductName();
		}
		model.addAttribute("messageDetail", messageDetail);
		
		/* チェックボックスの入力情報編集 */
		String[] checkedEmployee = form.getEmployees();
		StringBuilder builder = new StringBuilder();
		for (String employee : checkedEmployee) {
			builder.append(employee).append(System.lineSeparator());
		}
		model.addAttribute("messageCheckBox", builder);
		model.addAttribute("checkEmployees", getCheckEmployees());

		/* ラジオボタンの編集 */
		String radio = form.getRadio();
		model.addAttribute("messageRadio", radio);
		model.addAttribute("checkRadioEmployees", getCheckRadiokEmployees());

		String sex = form.getSex();
		model.addAttribute("messageSex", sex);
		model.addAttribute("sexoption", getSexOption());

		model.addAttribute("testForm", form);

		return "showMessage";
	}


	private List<String> getCheckRadiokEmployees() {
		List<String> list = new LinkedList<String>();
		list.add("りんご");
		list.add("みかん");
		list.add("バナナ");
		return list;
	}

	private List<String> getCheckEmployees() {
		List<String> list = new LinkedList<String>();
		list.add("一太郎");
		list.add("次郎");
		list.add("三郎");
		return list;
	}

	private List<Sex> getSexOption() {
		List<Sex> list = new LinkedList<Sex>();
		Sex male = new Sex("M", "Male", 80);
		Sex fmale = new Sex("F", "Fmale", 88);
		list.add(male);
		list.add(fmale);
		return list;
	}

	// private Map<String, String> getSexOption() {
	// Map<String, String> sexMap = new HashMap<String, String>();
	// sexMap.put("M", "Male");
	// sexMap.put("F", "FMale");
	// return sexMap;
	// }
}
