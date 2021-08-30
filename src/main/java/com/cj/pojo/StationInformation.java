package com.cj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * 
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @decription:站点信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StationInformation对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class StationInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @NotNull
    private String username;

    @ApiModelProperty(value = "用户电话号码")
    @Size(min = 11,max = 11)
    private String phone;

    @ApiModelProperty(value = "剩余可接种数")
    private Integer vaccinationNums;

    @ApiModelProperty(value = "站点可接种的医护人员数")
    private Integer vaccinationPersons;

    @ApiModelProperty(value = "剩余核酸检测剂数")
    private Integer nucleicAcidNums;

    @ApiModelProperty(value = "该站点可参核酸的医护人员数")
    private Integer nucleicAcidPersons;

    @ApiModelProperty(value = "该站点所需志愿者数")
    private Integer volunteersNeeded;

    @ApiModelProperty(value = "该站点已有志愿者数")
    private Integer volunteersNums;

    @ApiModelProperty(value = "疫苗已预约人数")
    private Integer vaccinationAppointNums;

    @ApiModelProperty(value = "核酸已预约人数")
    private Integer nucleicAppointNums;

    @ApiModelProperty(value = "合作的通勤人员")
    private String commuters;

    @ApiModelProperty(value = "医院的医护人员列表")
    private String medicalList;

    @ApiModelProperty(value = "在此医院接种疫苗用户列表")
    private String userList;

    @ApiModelProperty(value = "在此医院核酸检测用户列表")
    private String user_nucleic_list;

    @ApiModelProperty(value = "医院的志愿者列表")
    private String volunteerList;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "删除时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
