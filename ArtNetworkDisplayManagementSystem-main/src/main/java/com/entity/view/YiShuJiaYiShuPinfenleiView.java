package com.entity.view;

import com.entity.YiShuJiaYiShuPinfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 艺术家艺术品信息分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
@TableName("gongyipinfenlei")
public class YiShuJiaYiShuPinfenleiView extends YiShuJiaYiShuPinfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiShuJiaYiShuPinfenleiView(){
	}
 
 	public YiShuJiaYiShuPinfenleiView(YiShuJiaYiShuPinfenleiEntity yiShuJiaYiShuPinfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, yiShuJiaYiShuPinfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
