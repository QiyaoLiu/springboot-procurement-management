package com.abctechnologies.procurementmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//1 for success; 0 for fail
    private String msg;  //response message
    private Object data; //

    //create, update, delete success
    public static Result success(){
        return new Result(1,"success",null);
    }
    //read success
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //failure
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}