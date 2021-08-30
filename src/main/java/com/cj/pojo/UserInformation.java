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

/**
 * <p>
 * 
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @decription:用户信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInformation对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户电话号码")
    private String phone;

    @ApiModelProperty(value = "疫苗接种情况")
    private String vaccinationStatus;

    @ApiModelProperty(value = "核酸检测情况")
    private String nucleicAcidDetection;

    @ApiModelProperty(value = "用户核酸检测和疫苗接种的站点")
    private String userStation;

    @ApiModelProperty(value = "用户预约疫苗情况")
    private Integer vaccinationAppointed;

    @ApiModelProperty(value = "用户预约核酸情况")
    private Integer nucleicAcidAppointed;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "删除时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
