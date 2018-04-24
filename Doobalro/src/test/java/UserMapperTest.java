import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doobalro.my.biz.server.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserMapperTest {
	@Resource(name="userService")
//	@Autowired
	UserService service;
	
	@After
	public void tearDown() throws Exception {
		service = null;
		System.out.println("tear");
	}
	
//	@Test
//	public void UserInsert() {
//		System.out.println("test");
//		System.out.println(service.getUser(1));
//	}
//	

}
