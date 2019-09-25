package cc.sitec.generator;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 *@Author 凉水
 *@Date 2019/9/21 10:57
 **/
@Data
public class Config {

	public static String jdbcUrl;
	public static String jdbcUserName;
	public static String jdbcPassword;
	public static String jdbcDriverName;
	public static String outPath;
	public static String[] tableNames;
	public static String packageName;
	static {
		try {
			initProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void initProperties() throws IOException {
		Properties properties = new Properties();
		InputStream in = GeneratorServiceEntity.class.getClassLoader().getResourceAsStream("application.properties");
		properties.load(in);
		String tableStr = properties.getProperty("gen.tableNames","");
		packageName = properties.getProperty("gen.packageName","");
		jdbcUrl = properties.getProperty("jdbc.url");
		jdbcUserName = properties.getProperty("jdbc.username");
		jdbcPassword = properties.getProperty("jdbc.password");
		jdbcDriverName = properties.getProperty("jdbc.driverName");
		tableNames = tableStr.split(",");
		outPath = properties.getProperty("gen.outPath");

	}

}
