package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.DeptVO;

@Component
public class DeptDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public DeptVO[] total() {
		DeptVO[] e_ar = null;
		
		List<DeptVO> e_list = ss.selectList("dept.total");
		if(e_list!=null && e_list.size()>0) {
			e_ar = new DeptVO[e_list.size()];
			
			e_list.toArray(e_ar);
		}
		
		return e_ar;
	}
	
	public DeptVO[] search(Map<String, String> d_map) {
		DeptVO[] d_ar = null;
		
		List<DeptVO> d_list = ss.selectList("dept.search",d_map);
		
		if(d_list!=null && d_list.size()>0) {
			d_ar = new DeptVO[d_list.size()];
			
			d_list.toArray(d_ar);
		}
		
		return d_ar;
	}
	
}
