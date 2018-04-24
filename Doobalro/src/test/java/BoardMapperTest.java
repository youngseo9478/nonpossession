import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doobalro.my.biz.server.service.BoardService;
import com.doobalro.my.biz.server.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BoardMapperTest {
	
	@Autowired
	BoardService service;

	@After
	public void tearDown() throws Exception {
		service = null;
		System.out.println("tear");
	}

	@Test
	public void boardInsert() {
		System.out.println("test");
		BoardVO vo = new BoardVO();
		vo.setBoardContent("testtesttest1");
		vo.setUserNum(1);
		vo.setBoardTitle("test1");
		vo.setBoardWriter("youngseo");
		vo.setBoardDate("2018-04-23");
		service.addBoard(vo);
	}

}
