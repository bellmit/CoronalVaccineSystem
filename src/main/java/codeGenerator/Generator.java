//package codeGenerator;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.ArrayList;
//
//
//public class Generator {
//    //代码自动生成器
//        public static void main(String[] args) {
//            // 需要构建一个 代码自动生成器 对象
//            AutoGenerator mpg = new AutoGenerator();
//
//            // 配置策略
//            // 1、全局配置
//            GlobalConfig gc = new GlobalConfig();
//            String projectPath = System.getProperty("user.dir");//获取用户目录
//            gc.setOutputDir(projectPath+"/src/main/java");//输出到这个目录下
//            gc.setAuthor("hcj"); gc.setOpen(false);
//            gc.setFileOverride(false); // 是否覆盖
//
//            gc.setServiceName("%sService");//// 去Service的I前缀
//
//
//            gc.setIdType(IdType.ID_WORKER_STR);//初始的算法
//            gc.setDateType(DateType.ONLY_DATE);//日期
//            gc.setSwagger2(true);
//            mpg.setGlobalConfig(gc);
//
//            //2、设置数据源
//            DataSourceConfig dsc = new DataSourceConfig();
//            dsc.setUrl("jdbc:mysql://127.0.0.1:3306/covid-19 vaccine system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
//            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//            dsc.setUsername("root");
//            dsc.setPassword("yx619cj916");
//            dsc.setDbType(DbType.MYSQL);
//            mpg.setDataSource(dsc);
//
//            //3、包的配置
//            PackageConfig pc = new PackageConfig();
//            //只需要改实体类名字 和包名 还有 数据库配置即可
////        pc.setModuleName("express");
//            pc.setParent("com.cj");
//            pc.setEntity("pojo");
//            pc.setMapper("mapper");
//            pc.setService("service");
//            pc.setController("controller");
//            mpg.setPackageInfo(pc);
//
//            //4、策略配置
//            StrategyConfig strategy = new StrategyConfig();
//            // 设置要映射的表名
//            strategy.setInclude("medical_staff_information","root_information","station_information","user","user_information","volunteers_information");
//
//            strategy.setNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
//            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//            strategy.setEntityLombokModel(true);//自动lombok
//
//
//            // 自动填充配置
//            TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
//            TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
//            ArrayList<TableFill> tableFills = new ArrayList<>();
//            tableFills.add(gmtCreate);
//            tableFills.add(gmtModified);
//            strategy.setTableFillList(tableFills);
//
//            // 乐观锁
//            strategy.setVersionFieldName("version");
//
//            // 逻辑删除
//            strategy.setLogicDeleteFieldName("deleted");
//
//            strategy.setRestControllerStyle(true);
//            strategy.setControllerMappingHyphenStyle(true);
//
//            // localhost:8082
//            mpg.setStrategy(strategy);
//            mpg.execute(); //执行
//        }
//    }
//
