package generate;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.SdType;
import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.options.ScrewDriverOptions;

/**
 * 执行常见Student
 * 
 * @author <a href="http://mirrentools.org/">Mirren</a>
 *
 */
public class CreateClasses {
	public static void main(String[] args) {
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(Constant.databaseOptions()));
		SdBean bean = new SdBean();
		bean.setName("classes").setRemark("班级表");
		bean.addColumn(new SdColumn().setName("id").setType(SdType.INTEGER).setPrimary(true).setRemark("班级的id"));
		bean.addColumn(new SdColumn().setName("name").setType(SdType.STRING).setLength(10).setNullable(false).setRemark("班级的名称"));
		screwDriver.createCode(bean, Constant.templates(SdUtil.toPascalCase(bean.getName())));
		screwDriver.createTable(bean);
	}
}
