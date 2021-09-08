package com.crudOperation.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;
@Getter
@Setter
@Data
public class BaseResponse<T> {
    private String StatusCode;
    private String StatusMsg;
    private T Data;
    
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	public String getStatusMsg() {
		return StatusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		StatusMsg = statusMsg;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
    
    

    
}