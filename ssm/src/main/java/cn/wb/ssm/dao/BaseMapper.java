package cn.wb.ssm.dao;

public interface BaseMapper<T> {

	public int insert(T t);

	public int delete(T t);
	
	public int update(T t);
	
	public int select(T t);
}
