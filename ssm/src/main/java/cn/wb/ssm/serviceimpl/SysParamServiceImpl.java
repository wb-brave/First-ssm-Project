package cn.wb.ssm.serviceimpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.wb.ssm.entity.SysParam;
import cn.wb.ssm.service.SysParamService;

@Service("sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectList() {
		// TODO Auto-generated method stub
		List<SysParam> sysParams=sysParamMapper.selectList("");
		//ϵͳ����Map,������������ֶε���ز�����Ϣ
		Map<String, Object> sysParamMap =new HashMap<String, Object>();
		
		Map<String, Object> fieldMap=null;
		
		for (SysParam sysParam : sysParams) {
			if("1".equals(sysParam.getSysParamType())){
				//��ȡ��Ҫִ��SQL��������ѯ������
				String sql = sysParam.getSysParamValue();
				System.out.println("========="+sql);
				//ִ�в�ѯ�����ѽ������List�У�Ԫ��Ϊϵͳ�������͵�ʵ��
				List<SysParam> otherList= sysParamMapper.selectOthreTable(sql);
				fieldMap = new HashMap<String, Object>();
				//�������������ݴ浽�ֶ�MAP
				for (SysParam otherSysParam : otherList) {
					fieldMap.put(otherSysParam.getSysParamValue(), otherSysParam.getSysParamText());					
				}
				//���ֶ����Map�����ϵͳ����Map,��ԭϵͳ�������ѯ��sysParam�����sysParamField��Ϊkdy
				sysParamMap.put(sysParam.getSysParamField(), fieldMap);						
				
			}else{
				//�ж�ϵͳ������map���Ƿ�����ֶε�map,
				if(sysParamMap.get(sysParam.getSysParamField())==null){
					fieldMap = new HashMap<String, Object>();
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
					sysParamMap.put(sysParam.getSysParamField(), fieldMap);				
				}else{
					fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());					
				}
			}
			
		}
		//System.out.println(sys);
		return sysParamMap;
	}
	
	
}
