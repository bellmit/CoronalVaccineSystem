//package com.cj.TO;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Date;
//
///**
// * @author 93948
// * @date 2021-07-27 20:22
// * @Email:19927539545@163.com
// * @project: coronalVaccineSystem
// * @descript:医护人员传输对象
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class MedicalStaffTO implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @ApiModelProperty(value = "用户的唯一id")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    @ApiModelProperty(value = "医护人员id")
//    private Integer userId;
//
//    @ApiModelProperty(value = "医护人员名字")
//    private String username;
//
//    @ApiModelProperty(value = "密码")
//    private String password;
//
//    @ApiModelProperty(value = "电话")
//    private String phone;
//
//    @ApiModelProperty(value = "所属站点")
//    private Integer stationId;
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT)
//    private LocalDateTime createTime;
//
//    @ApiModelProperty(value = "删除时间")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateTime;
//
//
//}
