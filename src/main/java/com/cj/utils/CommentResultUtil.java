package com.cj.utils;

/**
 * @author 93948
 * @date 2021-07-30 9:14
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:
 */
public class CommentResultUtil {
    public static CommentResult success(Object object){
        CommentResult commentResult = new CommentResult();
        commentResult.setCode(0);
        commentResult.setMessage("success");
        commentResult.setData(object);
        return commentResult;
    }
}
