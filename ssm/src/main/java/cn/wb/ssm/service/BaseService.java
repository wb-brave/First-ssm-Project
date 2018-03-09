package cn.wb.ssm.service;

import cn.wb.ssm.entity.Page;

public interface BaseService<T> {

	public int insert(T t) throws Exception;

	public int delete(T t) throws Exception;
	
	public int update(T t) throws Exception;
	
	public T select(T t) throws Exception;
	
	//通过主键（数组）批量删除数据
	public int deleteList(String [] pks) throws Exception;
	
	public Page<T> selectPageList(Page<T> page) throws Exception;
	public Page<T> selectPageListDyc(Page<T> page) throws Exception;
	
}
