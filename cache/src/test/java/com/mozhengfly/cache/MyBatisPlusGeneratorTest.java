/**
 * @projectName cache
 * @package com.mozhengfly.cache
 * @className com.mozhengfly.cache.MyBatisPlusGeneratorTest
 */

package com.mozhengfly.cache;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.*;

/**
 * MyBatisPlusGeneratorTest
 *
 * @Description 自动生成配置类
 * @Author wangchonglin
 * @Date 2018/12/27 15:45
 * @Version 1.0.2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisPlusGeneratorTest {

    private String path = new File("").getAbsolutePath();
    private String javaPath = path + "/src/main/java";
    /** 作者 **/
    private String authorName = "mozhengfly";

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriver;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Test
    public void generator() {
        AutoGenerator mpg = new AutoGenerator();
        setGlobalConfig(mpg);
        setDataSourceConfig(mpg);
        setStrategy(mpg);
        setPackageInfo(mpg);
        setCfg(mpg);
        setTemplate(mpg);
        mpg.execute();
    }

    /**
     * 配置全局变量
     * @param mpg
     */
    private void setGlobalConfig(AutoGenerator mpg) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 输出目录
        gc.setOutputDir(javaPath);
        // 是否覆盖文件
        gc.setFileOverride(false);
        // 开启 activeRecord 模式
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor(authorName);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
    }

    /**
     * 设置数据源
     * @param mpg
     */
    private void setDataSourceConfig(AutoGenerator mpg) {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });

        dsc.setDriverName(dataSourceDriver);
        dsc.setUrl(dataSourceUrl);
        dsc.setUsername(dataSourceUsername);
        dsc.setPassword(dataSourcePassword);
        mpg.setDataSource(dsc);
    }

    /**
     * 设置策略
     * @param mpg
     */
    private void setStrategy(AutoGenerator mpg) {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(new String[]{"user"});
        strategy.setTableFillList(tableFillList);
        strategy.setTablePrefix("t");
        mpg.setStrategy(strategy);
    }

    /**
     * 设置包路径
     * @param mpg
     */
    private void setPackageInfo(AutoGenerator mpg) {
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mozhengfly.cache");
        pc.setModuleName("business");
        pc.setMapper("dao");
        pc.setController("controller");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);
    }

    /**
     * 设置配置信息
     * @param mpg
     */
    private void setCfg(AutoGenerator mpg) {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("mozheng", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        cfg.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(ConstVal.TEMPLATE_XML) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
        mpg.setCfg(cfg);
    }

    /**
     * 设置模板
     * @param mpg
     */
    private void setTemplate(AutoGenerator mpg) {
        TemplateConfig template = new TemplateConfig();
        // 不生成xml
        template.setXml(null);
        mpg.setTemplate(template);
    }
}
