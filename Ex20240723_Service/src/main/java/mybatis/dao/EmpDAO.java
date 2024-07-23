package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public EmpVO[] total() {
		EmpVO[] e_ar = null;
		
		List<EmpVO> e_list = ss.selectList("emp.total");
		if(e_list!=null && e_list.size()>0) {
			e_ar = new EmpVO[e_list.size()];
			
			e_list.toArray(e_ar);
		}
		
		return e_ar;
	}
	
	public EmpVO[] search(Map<String, String> e_map) {
		EmpVO[] e_ar = null;
		
		List<EmpVO> e_list = ss.selectList("emp.search",e_map);
		
		if(e_list!=null && e_list.size()>0) {
			e_ar = new EmpVO[e_list.size()];
			
			e_list.toArray(e_ar);
		}
		
		return e_ar;
	}
	
}
