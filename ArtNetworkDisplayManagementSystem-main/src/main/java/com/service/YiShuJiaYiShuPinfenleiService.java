package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiShuJiaYiShuPinfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.yishujiayishupinfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiShuJiaYiShuPinfenleiView;


/**
 * 艺术家艺术品信息分类
 *
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
public interface YiShuJiaYiShuPinfenleiService extends IService<YiShuJiaYiShuPinfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<yishujiayishupinfenleiVO> selectListVO(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
   	
   	yishujiayishupinfenleiVO selectVO(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
   	
   	List<YiShuJiaYiShuPinfenleiView> selectListView(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
   	
   	YiShuJiaYiShuPinfenleiView selectView(@Param("ew") Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper);
   	

}

