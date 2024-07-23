package mybatis.service;

public interface MyMapper {
	
	Object[] getList();
	
	Object[] search(String type, String value);


}
