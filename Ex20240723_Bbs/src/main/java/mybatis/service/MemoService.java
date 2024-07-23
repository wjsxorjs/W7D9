package mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.dao.MemoDAO;

@Service
public class MemoService implements MyMapper {

	@Autowired
	private MemoDAO m_dao;

	@Override
	public Object[] total() {
		
		return m_dao.total();
	}


}
