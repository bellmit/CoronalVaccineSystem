package com.cj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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

//import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 * @decription:root用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RootInformation对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class RootInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户的唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @ApiModelProperty(value = "用户名")
    @NotNull
    private String username;

    @ApiModelProperty(value = "用户密码")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,11}$",message = "用户密码只能是6-12位数字和字母的组合")
    private String password;


    public RootInformation(String username, String password) {
        this.username=username;
        this.password=password;
    }
}
