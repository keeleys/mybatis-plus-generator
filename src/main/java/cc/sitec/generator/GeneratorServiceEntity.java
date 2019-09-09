package cc.sitec.generator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author keeley
 * https://mybatis.plus/config/generator-config.html#fileoverride
 */
public class GeneratorServiceEntity {
    public static void main(String[] args) {
        String packageName = "com.sibu.mall.accountant.persistence";
        generateByTables(packageName,"order_0","order_avaliable_money_log_0","order_back_0","order_mark_0",
                "order_operator_log_0","order_payment_0","order_product_0","order_settle_0","order_settle_error_log_0");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig().setActiveRecord(false)
                .setAuthor("keeley")
                .setOutputDir("/Users/keeley/Documents/wljs/code/sibu-mall-accountant/sibu-mall-accountant-persistence/src/main/java/")
                .setBaseResultMap(true)
                .setOpen(false)
                .setIdType(IdType.AUTO)
                // .setServiceName("%sService")
                .setFileOverride(true);


        DataSourceConfig dataSourceConfig = new DataSourceConfig().setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://rm-bp10o39k37lfxh090.mysql.rds.aliyuncs.com:3306/financial_settle_split0")
                .setUsername("root")
                .setPassword("dev-mysql-R3ND7N4zvjYt0Wvw")
                .setDriverName("com.mysql.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig()
                .setCapitalMode(true)
                .setEntityLombokModel(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setNaming(NamingStrategy.underline_to_camel);
        if(tableNames.length>=0) {
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
        TemplateConfig templateConfig = new TemplateConfig()
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

    private static void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}