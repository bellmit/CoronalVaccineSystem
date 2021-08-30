//package com.cj.TO;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableId;
//import io.swagger.annotations.ApiModelProperty;
//
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Date;
//
///**
// * @author 93948
// * @date 2021-07-27 20:22
// * @Email:19927539545@163.com
// * @project: coronalVaccineSystem
// * @descript:志愿者传输对象
// */
//public class VolunteerTO implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @ApiModelProperty(value = "用户的唯一id")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//
//    @ApiModelProperty(value = "志愿者名字")
//    @NotNull(message = "用户名不能为空")
//    private String username;
//
//    @ApiModelProperty(value = "电话")
//    private String phone;
//
//    @ApiModelProperty(value = "密码")
//    private String password;
//
//    @ApiModelProperty(value = "志愿站点")
//    private Integer stationId;
//
//    @ApiModelProperty(value = "志愿时间")
//    private Date day;
//
//    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT)
//    private LocalDateTime createTime;
//
//    @ApiModelProperty(value = "删除时间")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime updateTime;
//}
