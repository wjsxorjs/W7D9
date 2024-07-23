package mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.dao.BbsDAO;

@Service
public class BbsService implements MyMapper {
	
	@Autowired
	private BbsDAO b_dao;

	@Override
	public Object[] total() {
		Object[] o_ar = null;
		
		o_ar = b_dao.total();
		
		return o_ar;
	}

}
