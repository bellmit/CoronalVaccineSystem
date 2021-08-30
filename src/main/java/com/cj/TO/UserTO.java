//package com.cj.TO;
//
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
////import javax.validation.constraints.NotNull;
////import javax.validation.constraints.Pattern;
////import javax.validation.constraints.Size;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//
///**
// * @author 93948
// * @date 2021-07-27 20:21
// * @Email:19927539545@163.com
// * @project: coronalVaccineSystem
// * @descript:用户传输对象
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserTO implements Serializable {
//    @ApiModelProperty(value = "用户角色（root、用户、站点、医护人员、志愿者、通勤人员）")
//    private String role;
//
//    @NotNull
//    @ApiModelProperty(value = "用户名")
//    private String username;
//
//    @NotNull
//    @Pattern(regexp = "^[a-zA-Z]\\w{5,11}$",message = "用户密码只能是6-12位数字和字母的组合")
//    @ApiModelProperty(value = "用户密码")
//    private String password;
//
//    @Size(max = 11,min = 11)
//    @ApiModelProperty(value = "用户电话号码")
//    private String phone;
//
//    @Size(min = 6,max = 6)
//    @ApiModelProperty(value = "验证码")
//    private String code;
//}
