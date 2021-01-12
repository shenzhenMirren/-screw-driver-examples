package generate;

import java.util.HashMap;
import java.util.Map;

import org.mirrentools.sd.constant.MySQL;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.SdDatabaseOptions;

/**
 * 常量配置
 * 
 * @author <a href="http://mirrentools.org/">Mirren</a>
 *
 */
public class Constant {
	/**
	 * 获取数据库配置信息
	 * 
	 * @return
	 */
	public static SdDatabaseOptions databaseOptions() {
		SdDatabaseOptions result = new SdDatabaseOptions(MySQL.MYSQL_8_DERVER,
				"jdbc:mysql://localhost:3306/root?useUnicode=true&useSSL=false&serverTimezone=UTC");
		result.setUser("root").setPassword("root");
		return result;
	}

	/**
	 * 获取生成代码需要用到的模板
	 * 
	 * @param entityName
	 *          类的名称
	 * @return
	 */
	public static Map<String, SdTemplate> templates(String entityName) {
		String packageName = "org.mirrentools.sd.example.";
		String templatePath = "mybatis";
		// 设置实体生成模板
		Map<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		// 实体类
		templates.put("entity", new SdTemplate()
				.setPath(templatePath)
				.setFile("Entity.ftl")
				.setPackageName(packageName + "entity")
				.setClassName(entityName));
		// 数据库操作dao
		templates.put("dao", new SdTemplate()
				.setPath(templatePath)
				.setFile("Dao.ftl")
				.setPackageName(packageName + "mapper")
				.setClassName(entityName + "Mapper"));
		// 查询帮助类
		templates.put("assist", new SdTemplate()
				.setPath(templatePath)
				.setFile("SqlAssist.ftl")
				.setPackageName(packageName + "common")
				.setClassName("SqlAssist"));
		// MyBatis的mapper
		templates.put("mapper", new SdTemplate()
				.setPath(templatePath)
				.setFile("MySqlMapper.ftl")
				.setPackageName("mappers")
				.setSourceFolder("src/main/resources")
				.setClassName(entityName + "Mapper").setSuffix(".xml"));
		// Service
		templates.put("service", new SdTemplate()
				.setPath(templatePath)
				.setFile("Service.ftl")
				.setPackageName(packageName + "service")
				.setClassName(entityName + "Service"));
		// Service impl
		templates.put("serviceImpl", new SdTemplate()
				.setPath(templatePath)
				.setFile("ServiceImpl.ftl")
				.setPackageName(packageName + "service.impl")
				.setClassName(entityName + "ServiceImpl"));
		// Controller
		templates.put("controller", new SdTemplate()
				.setPath(templatePath)
				.setFile("Controller.ftl")
				.setPackageName(packageName + "controller")
				.setClassName(entityName + "Controller"));
		// test
		templates.put("test", new SdTemplate()
				.setPath(templatePath)
				.setFile("Test.ftl")
				.setSourceFolder(org.mirrentools.sd.constant.SdConstant.MAVEN_TEST)
				.setPackageName(packageName + "test")
				.setClassName(entityName + "ControllerTest")
				);
		return templates;
	}
}
