package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiShuJiaYiShuPinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.yishujiayishupinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiShuJiaYiShuPinxinxiView;


/**
 * 艺术家艺术品信息
 *
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
public interface YiShuJiaYiShuPinxinxiService extends IService<YiShuJiaYiShuPinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<yishujiayishupinxinxiVO> selectListVO(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
   	
   	yishujiayishupinxinxiVO selectVO(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
   	
   	List<YiShuJiaYiShuPinxinxiView> selectListView(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
   	
   	YiShuJiaYiShuPinxinxiView selectView(@Param("ew") Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper);
   	

}

