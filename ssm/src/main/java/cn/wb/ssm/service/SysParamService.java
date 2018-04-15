package cn.wb.ssm.service;

import java.util.Map;

import cn.wb.ssm.entity.SysParam;

public interface SysParamService extends BaseService<SysParam> {
    public Map<String,Object>selectList();
	 
}
