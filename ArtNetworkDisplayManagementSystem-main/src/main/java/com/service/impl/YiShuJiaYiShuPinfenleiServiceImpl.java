package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YiShuJiaYiShuPinfenleiDao;
import com.entity.YiShuJiaYiShuPinfenleiEntity;
import com.service.YiShuJiaYiShuPinfenleiService;
import com.entity.vo.yishujiayishupinfenleiVO;
import com.entity.view.YiShuJiaYiShuPinfenleiView;

@Service("gongyipinfenleiService")
public class YiShuJiaYiShuPinfenleiServiceImpl extends ServiceImpl<YiShuJiaYiShuPinfenleiDao, YiShuJiaYiShuPinfenleiEntity> implements YiShuJiaYiShuPinfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiShuJiaYiShuPinfenleiEntity> page = this.selectPage(
                new Query<YiShuJiaYiShuPinfenleiEntity>(params).getPage(),
                new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper) {
		  Page<YiShuJiaYiShuPinfenleiView> page =new Query<YiShuJiaYiShuPinfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<yishujiayishupinfenleiVO> selectListVO(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public yishujiayishupinfenleiVO selectVO(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiShuJiaYiShuPinfenleiView> selectListView(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiShuJiaYiShuPinfenleiView selectView(Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
