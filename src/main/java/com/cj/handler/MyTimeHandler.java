package com.cj.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 93948
 * @date 2021-07-17 23:57
 * @Email:19927539545@163.com
 * @project: coronalVaccineSystem
 * @descript:设置插入数据和更新数据时时间的自动更新
 */
@Component
public class MyTimeHandler implements MetaObjectHandler {
//    private static Logger logger=Logger.getLogger(MyTimeHandler.class);
    @Override
    public void insertFill(MetaObject metaObject) {
//        logger.info("******  insert time  ******");
        this.setFieldValByName("updateTime", LocalDateTime.now(),metaObject);
        this.setFieldValByName("createTime",LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        logger.info("******  update time  ******");
        this.setFieldValByName("updateTime",LocalDateTime.now(),metaObject);
    }
}
