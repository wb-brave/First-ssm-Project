package cn.wb.ssm.dao;

import java.util.List;

import cn.wb.ssm.entity.SysParam;

public interface SysParamMapper extends BaseMapper<SysParam> {
	public List<SysParam> selectList(String type);
	public List<SysParam> selectOthreTable(String sql);
   
}