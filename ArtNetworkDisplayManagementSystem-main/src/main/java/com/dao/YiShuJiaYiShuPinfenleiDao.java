package com.dao;

import com.entity.YiShuJiaYiShuPinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.yishujiayishupinfenleiVO;
import com.entity.view.YiShuJiaYiShuPinfenleiView;


/**
 * 艺术家艺术品信息分类
 * 
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
public interface YiShuJiaYiShuPinfenleiDao extends BaseMapper<YiShuJiaYiShuPinfenleiEntity> {
	
	List<yishujiayishupinfenleiVO> selectListVO(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
	
	yishujiayishupinfenleiVO selectVO(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
	
	List<YiShuJiaYiShuPinfenleiView> selectListView(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);

	List<YiShuJiaYiShuPinfenleiView> selectListView(Pagination page, @Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
	
	YiShuJiaYiShuPinfenleiView selectView(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
	

}
