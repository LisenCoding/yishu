package com.dao;

import com.entity.DiscussgongyipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgongyipinxinxiVO;
import com.entity.view.DiscussgongyipinxinxiView;


/**
 * 艺术家艺术品信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
public interface DiscussgongyipinxinxiDao extends BaseMapper<DiscussgongyipinxinxiEntity> {
	
	List<DiscussgongyipinxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgongyipinxinxiEntity> wrapper);
	
	DiscussgongyipinxinxiVO selectVO(@Param("ew") Wrapper<DiscussgongyipinxinxiEntity> wrapper);
	
	List<DiscussgongyipinxinxiView> selectListView(@Param("ew") Wrapper<DiscussgongyipinxinxiEntity> wrapper);

	List<DiscussgongyipinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgongyipinxinxiEntity> wrapper);
	
	DiscussgongyipinxinxiView selectView(@Param("ew") Wrapper<DiscussgongyipinxinxiEntity> wrapper);
	

}
