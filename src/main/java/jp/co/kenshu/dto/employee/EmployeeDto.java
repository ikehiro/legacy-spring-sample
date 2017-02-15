package jp.co.kenshu.dto.employee;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private Integer age;
    private String memo;
}