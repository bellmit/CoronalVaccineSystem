//package com.cj.TO;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.cj.annoations.Size;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Date;
//
///**
// * @author 93948
// * @date 2021-07-27 20:21
// * @Email:19927539545@163.com
// * @project: coronalVaccineSystem
// * @descript:站点传输对象
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class StationTO implements Serializable {
//
//    @ApiModelProperty(value = "自增id")
//    private Integer id;
//
//
//    @ApiModelProperty(value = "用户名")
//    @NotNull(message = "用户名不能为空")
//    private String username;
//
//    @ApiModelProperty(value = "用户电话号码")
//    @Size(minLength = 11,maxLength = 11)
//    private String phone;
//
//    @ApiModelProperty(value = "剩余可接种数")
//    private Integer vaccinationNums;
//
//    @ApiModelProperty(value = "站点可接种的医护人员数")
//    private Integer vaccinationPersons;
//
//    @ApiModelProperty(value = "剩余核酸检测剂数")
//    private Integer nucleicAcidNums;
//
//    @ApiModelProperty(value = "该站点可参核酸的医护人员数")
//    private Integer nucleicAcidPersons;
//
//    @ApiModelProperty(value = "该站点所需志愿者数")
//    private Integer volunteersNeeded;
//
//    @ApiModelProperty(value = "该站点已有志愿者数")
//    private Integer volunteersNums;
//
//    @ApiModelProperty(value = "疫苗已预约人数")
//    private Integer vaccinationAppointNums;
//
//    @ApiModelProperty(value = "核酸已预约人数")
//    private Integer nucleicAppointNums;
//
//    @ApiModelProperty(value = "合作的通勤人员")
//    private String commuters;
//
//    @ApiModelProperty(value = "医院的医护人员列表")
//    private String medicalList;
//
//    @ApiModelProperty(value = "在此医院进行核酸检测或者接种疫苗的用户列表")
//    private String userList;
//
//    @ApiModelProperty(value = "医院的志愿者列表")
//    private String volunteerList;
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT)
//    private LocalDateTime createTime;
//
//    @ApiModelProperty(value = "删除时间")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateTime;
//
//}
