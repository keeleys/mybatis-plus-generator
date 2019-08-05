package cc.sitec.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author keeley
 */
public class GeneratorServiceEntity {
    public static void main(String[] args) {
        String packageName = "cc.sitec.result";
        generateByTables(packageName, "xxl_job_group", "xxl_job_info");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig().setActiveRecord(false)
                .setAuthor("keeley")
                .setOutputDir("D:\\wljs\\code\\keeley\\mybatisplusgenerator\\src\\main\\java\\cc\\sitec\\result")
                .setBaseResultMap(true)
                .setOpen(false)
                // .setServiceName("%sService")
                .setFileOverride(true);


        DataSourceConfig dataSourceConfig = new DataSourceConfig().setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/xxl_job")
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                // 不设置setInclude就是映射全库的表
                .setInclude(tableNames)
                .setNaming(NamingStrategy.underline_to_camel);

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 配置模板 null代表不生成
        TemplateConfig templateConfig = new TemplateConfig()
                .setController(null).setService(null).setServiceImpl(null);

        new AutoGenerator()
                .setGlobalConfig(config)
                .setTemplate(templateConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig().setParent(packageName).setMapper("dao").setXml("dao"))
                .setCfg(cfg)
                .execute();
    }

    private static void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}