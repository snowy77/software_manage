import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lx.dao.chooseDao;
import com.lx.dao.courseDao;
import com.lx.dao.userDao;
import com.lx.model.choose;
import com.lx.model.course;
import com.lx.model.user;

public class chooseServiceTest extends BaseTest{
	@Autowired 
	private chooseDao dao;
	@Autowired 
	private userDao udao;
	@Autowired 
	private courseDao cdao;
	
	
//	@Test
//	public void addChoose(){
//		user u=udao.queryByUno(5);
//		System.out.println(u.getUno());
//		course c=cdao.queryByNo(1);
//		System.out.println(c.getCno());
//		dao.addChoose(c.getCno(),u.getUno(), 85);
//		
//	}
//	@Test
//	public void queryAll(){
//		List<choose> c=dao.queryAll();
//		System.out.println(c.get(0).getUser().getName());
//	}
//	@Test
//	public void deleteChoose(){
//		dao.deleteChoose(1,6);
//	}
//	@Test
//	public void updateChoose_teacher(){
//		dao.updateChoose_teacher(1, 5, 80);
//	}
//	@Test
//	public void queryByUno(){
//		dao.queryByUno(5);
//	}
	
	@Test
	public void queryAll(){
		List<choose> c=dao.queryByGrade(2);
		System.out.println(c.get(0).getUser().getName());
	}
	
}
