package cn.wb.ssm.service;

import cn.wb.ssm.entity.Page;

public interface BaseService<T> {

	public int insert(T t);

	public int delete(T t);
	
	public int update(T t);
	
	public int select(T t);
	
	public Page<T> selectPageList(Page<T> page);
	public Page<T> selectPageListDyc(Page<T> page);
	
}
