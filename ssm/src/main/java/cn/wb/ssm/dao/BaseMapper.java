package cn.wb.ssm.dao;

import java.util.List;

import cn.wb.ssm.entity.Page;

public interface BaseMapper<T> {

	public int insert(T t);

	public int delete(T t);
	
	public int update(T t);
	
	public int select(T t);
	
	public List<T> selectPageList(Page<T> page);
	public Integer selectPageCount(Page<T> page);

	public List<T> selectPageListDyc(Page<T> page);
	public Integer selectPageListDycCount(Page<T> page);
}
