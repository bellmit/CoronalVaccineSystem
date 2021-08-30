//package com.cj.TO;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//
///**
// * @author 93948
// * @date 2021-07-27 20:22
// * @Email:19927539545@163.com
// * @project: coronalVaccineSystem
// * @descript:root用户传输对象
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class RootTO implements Serializable {
//
//    @ApiModelProperty(value = "用户的唯一id")
//    private Integer id;
//
//    @NotNull(message = "用户名为Null")
//    @ApiModelProperty(value = "用户名")
//    private String username;
//
//    @Pattern(regexp = "^[a-zA-Z]\\w{5,11}$",message = "用户密码只能是6-12位数字和字母的组合")
//    @ApiModelProperty(value = "用户密码")
//    private String password;
//}
