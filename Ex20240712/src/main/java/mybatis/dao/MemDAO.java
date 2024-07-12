package mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.MemVO;


@Component
public class MemDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemDAO() {System.out.println("MemDAO 생성");}
	
	public MemVO login(String id, String pw) {
		Map<String, String> l_map = new HashMap<String, String>();
		
		l_map.put("m_id", id);
		l_map.put("m_pw", pw);
		
		return sqlSession.selectOne("mem.login",l_map);
	}
	
	
}
