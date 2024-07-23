package mybatis.service;

import mybatis.vo.EmpVO;

public interface MyMapper {
	
	EmpVO[] getList();
	
	EmpVO[] search(String type, String value);


}
