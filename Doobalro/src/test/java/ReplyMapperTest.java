import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doobalro.my.biz.server.service.ReplyService;
import com.doobalro.my.biz.server.vo.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ReplyMapperTest {

	@Autowired
	ReplyService service;

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ReplyVO vo = new ReplyVO(0, 1, "asd", "asd", "asd");
		service.addReply(vo);
	}

}
