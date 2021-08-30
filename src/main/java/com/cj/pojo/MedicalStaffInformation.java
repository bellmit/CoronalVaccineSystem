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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * <p>
 * 
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @decription:医护人员信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MedicalStaffInformation对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class MedicalStaffInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户的唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "医护人员名字")
    @NotNull
    private String username;

    @ApiModelProperty(value = "密码")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,11}$",message = "用户密码只能是6-12位数字和字母的组合")
    private String password;

    @Size(max = 11,min = 11)
    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "所属站点")
    private Integer stationId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "删除时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
