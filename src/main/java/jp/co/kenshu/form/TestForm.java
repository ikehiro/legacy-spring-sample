package jp.co.kenshu.form;

public class TestForm {
	private int id;
	private String name;
	private TestFormDetail[] details;
	private String[] employees;
	private String radio;
	private String sex;


	public String[] getEmployees() {
		return employees;
	}

	public void setEmployees(String[] employees) {
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestFormDetail[] getDetails() {
		return details;
	}

	public void setDetails(TestFormDetail[] details) {
		this.details = details;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
