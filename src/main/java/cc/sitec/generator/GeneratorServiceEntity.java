package cc.sitec.generator;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;

/**
 * @author keeley
 * https://mybatis.plus/config/generator-config.html#fileoverride
 */
public class GeneratorServiceEntity {
    public static void main(String[] args) throws IOException {
        String packageName = Config.packageName;
        generateByTables(packageName,Config.tableNames);
    }

    private static void generateByTables(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig().setActiveRecord(false)
                .setAuthor("generate-auto")
                .setOutputDir(Config.outPath)
                .setBaseResultMap(true)
				.setBaseColumnList(true)
                .setOpen(true)
				.setEnableCache(false)
                .setIdType(IdType.AUTO)
                .setFileOverride(true);


        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setUrl(Config.jdbcUrl)
                .setUsername(Config.jdbcUserName)
                .setPassword(Config.jdbcPassword)
                .setDriverName(Config.jdbcDriverName);

        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
				.setEntityColumnConstant(true)
                .setNaming(NamingStrategy.underline_to_camel);
        if(tableNames!=null && tableNames.length>=0) {
            // 不设置setInclude就是映射全库的表
            strategyConfig.setInclude(tableNames);
        }

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 配置模板 null代表不生成
        TemplateConfig templateConfig = new TemplateConfig().setEntity("entity.java.vm")
                .setController(null).setService(null).setServiceImpl(null);

        new AutoGenerator()
                .setGlobalConfig(config)
                .setTemplate(templateConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig().setParent(packageName).setMapper("dao").setEntity("entity").setXml("dao"))
                .setCfg(cfg)
                .execute();
    }
}