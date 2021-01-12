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
public class CreateStudent {
	public static void main(String[] args) {
		ScrewDriver screwDriver = ScrewDriver.instance(new ScrewDriverOptions(Constant.databaseOptions()));
		SdBean bean = new SdBean();
		bean.setName("student").setRemark("学生表");
		
		SdColumn columnId = new SdColumn()
				.setName("id").setType(SdType.LONG)
				.setPrimary(true).setRemark("学生的id");
		
		SdColumn columnCid = new SdColumn()
				.setName("cid").setType(SdType.INTEGER)
				.setNullable(false).setRemark("外键-班级的id");
		
		columnCid.setForeignReferencesTable("classes")
						 .setForeignReferencesColumn("id")
						 .setForeignConstraint("FK_classes_student_id");
		
		SdColumn columnName = new SdColumn()
				.setName("name").setType(SdType.STRING)
				.setLength(10).setNullable(false).setRemark("学生的名称");
		
		SdColumn columnAge = new SdColumn()
				.setName("age").setType(SdType.INTEGER)
				.setLength(3).setNullable(false)
				.setRemark("学生的年龄");
		
		bean.addColumn(columnId, columnCid,columnName,columnAge);
		
		screwDriver.createCode(bean, Constant.templates(SdUtil.toPascalCase(bean.getName())));
		screwDriver.createTable(bean);
	}
}
