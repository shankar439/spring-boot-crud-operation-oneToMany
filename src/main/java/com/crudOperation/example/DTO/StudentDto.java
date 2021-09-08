package com.crudOperation.example.DTO;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class StudentDto {

	private int id;
	private String name;
    private String city;
    private List<SubjectDto> subjectDto;
    
	public List<SubjectDto> getSubjectDto() {
		return subjectDto;
	}
	public void setSubjectDto(List<SubjectDto> subjectDto) {
		this.subjectDto = subjectDto;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}   
}