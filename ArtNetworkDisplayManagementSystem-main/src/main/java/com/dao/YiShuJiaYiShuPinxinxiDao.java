package com.dao;

import com.entity.YiShuJiaYiShuPinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.yishujiayishupinxinxiVO;
import com.entity.view.YiShuJiaYiShuPinxinxiView;


/**
 * 艺术家艺术品信息
 * 
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
public interface YiShuJiaYiShuPinxinxiDao extends BaseMapper<YiShuJiaYiShuPinxinxiEntity> {
	
	List<yishujiayishupinxinxiVO> selectListVO(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
	
	yishujiayishupinxinxiVO selectVO(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
	
	List<YiShuJiaYiShuPinxinxiView> selectListView(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);

	List<YiShuJiaYiShuPinxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
	
	YiShuJiaYiShuPinxinxiView selectView(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
	

}
