package cn.wb.ssm.service;

public interface BaseService<T> {

	public int insert(T t);

	public int delete(T t);
	
	public int update(T t);
	
	public int select(T t);
}
