package mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

@Service
public class DeptService implements MyMapper {

	@Autowired
	private DeptDAO d_dao;
	
	@Override
	public DeptVO[] getList() {
		// TODO Auto-generated method stub
		return d_dao.total();
	}

	@Override
	public DeptVO[] search(String type, String value) {
		Map<String, String> d_map = new HashMap<String, String>();
		
		d_map.put("searchType",type);
		d_map.put("searchValue",value);
		
		
		return d_dao.search(d_map);
	}

}
