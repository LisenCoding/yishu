package com.entity.view;

import com.entity.DiscussgongyipinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 艺术家艺术品信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
@TableName("discussgongyipinxinxi")
public class DiscussgongyipinxinxiView  extends DiscussgongyipinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgongyipinxinxiView(){
	}
 
 	public DiscussgongyipinxinxiView(DiscussgongyipinxinxiEntity discussgongyipinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussgongyipinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
