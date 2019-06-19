import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lx.dao.courseDao;
import com.lx.dao.userDao;
import com.lx.model.course;
import com.lx.model.user;

public class courseServiceTest extends BaseTest {
	@Autowired
	private courseDao dao;
	@Autowired
	private userDao udao;
//	@Test
//	public void queryCourse(){
//		List<course> c=dao.queryAll();
//		
//	}
//	@Test
//	public void queryByNo(){
//		course c=dao.queryByNo(1);
//		System.out.println(c.getUser().getUno());
//	}
	@Test
	public void addCourse(){
		user u=udao.queryByUno(3);
		if(u.getFlag()=="1")
			dao.insertCourse(u);
	}
//	@Test
//	public void deleteCourse(){
//		dao.deleteCourse(3);
//		
//	}
}
