package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;


@Component
public class EmpDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public EmpDAO() {System.out.println("EmpDAO 생성");}

	public List<EmpVO> getAll() {
		
		return sqlSession.selectList("emp.getAll");
	}
	
	public List<EmpVO> searchEmp(String empno) {
		
		return sqlSession.selectList("emp.searchEmp",empno);
	}
	
	
}
