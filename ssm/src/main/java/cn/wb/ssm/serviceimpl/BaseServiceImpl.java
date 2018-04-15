package cn.wb.ssm.serviceimpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wb.ssm.dao.AccountMapper;
import cn.wb.ssm.dao.AccountRecordsMapper;
import cn.wb.ssm.dao.BaseMapper;
import cn.wb.ssm.dao.BuyOrderDetailMapper;
import cn.wb.ssm.dao.BuyOrderMapper;
import cn.wb.ssm.dao.GoodsMapper;
import cn.wb.ssm.dao.SupplierMapper;
import cn.wb.ssm.dao.SysParamMapper;
import cn.wb.ssm.entity.Page;
import cn.wb.ssm.service.BaseService;


public class BaseServiceImpl<T> implements BaseService<T> {
	protected  BaseMapper<T> baseMapper;
	
	@Autowired
	protected  SupplierMapper supplierMapper;
	
	@Autowired
	protected  AccountMapper accountMapper;
	
	@Autowired
	protected  GoodsMapper goodsMapper;
	
	@Autowired
	protected  BuyOrderMapper buyOrderMapper;
	
	@Autowired
	protected  BuyOrderDetailMapper buyOrderDetailMapper;
	
	@Autowired
	protected  AccountRecordsMapper accountRecordsMapper; 
	
	@Autowired
	protected  SysParamMapper sysParamMapper;
	
	@PostConstruct//在构造方法后，初化前执行
	private void initBaseMapper() throws Exception{
		//完成以下逻辑，需要对研发本身进行命名与使用规范?
				//this关键字指对象本身，这里指的是调用此方法的实现类（子类?
				System.out.println("=======this :"+this);
				System.out.println("=======父类基本信息?"+this.getClass().getSuperclass());
				System.out.println("=======父类和泛型的信息?"+this.getClass().getGenericSuperclass());
				
				ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
				//获取第一个参数的class
				Class clazz = (Class)type.getActualTypeArguments()[0];
				System.out.println("=======class:"+clazz);
				//转化为属性名（相关的Mapper子类的引用名）Supplier  supplierMapper
				String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
				System.out.println("=======localField:"+localField);
				//getDeclaredField:可以使用于包括私有字段?默认、受保护、公共字段，但不包括继承的字段?
				Field field=this.getClass().getSuperclass().getDeclaredField(localField);
				System.out.println("=======field:"+field);
				System.out.println("=======field对应的对象?"+field.get(this));
				Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
				
				System.out.println("=======baseField:"+baseField);
				System.out.println("=======baseField对应的对象?"+baseField.get(this));	
				baseField.set(this, field.get(this));		
				System.out.println("========baseField对应的对象?"+baseMapper);

	}	
	

	@Override
	public int insert(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.insert(entity);
	}

	@Override
	public int update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.update(entity);
	}

	@Override
	public int delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.delete(entity);
	}

	@Override
	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return baseMapper.deleteList(pks);
	}

	@Override
	public T select(T entity) {
		// TODO Auto-generated method stub
		return baseMapper.select(entity);
	}

	@Override
	public Page<T> selectPageList(Page<T> page) {
		page.setList(baseMapper.selectPageList(page));
		page.setTotalRecord(baseMapper.selectPageCount(page));
		return page;
	}

	@Override
	public Page<T> selectPageListDyc(Page<T> page) {
		// TODO Auto-generated method stub
		page.setList(baseMapper.selectPageListDyc(page));
		page.setTotalRecord(baseMapper.selectPageListDycCount(page));
		return page;
	}

}
