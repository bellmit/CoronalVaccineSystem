package com.cj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 93948
 * @date 2021-07-17 23:47
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:作为返回给前端的数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * 无返回结果
     * @param code
     * @param message
     */
    public CommentResult(Integer code,String message){
        this(code,message,null);
    }


}
