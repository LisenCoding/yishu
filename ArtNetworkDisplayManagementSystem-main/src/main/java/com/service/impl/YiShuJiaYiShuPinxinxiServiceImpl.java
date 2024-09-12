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


import com.dao.YiShuJiaYiShuPinxinxiDao;
import com.entity.YiShuJiaYiShuPinxinxiEntity;
import com.service.YiShuJiaYiShuPinxinxiService;
import com.entity.vo.yishujiayishupinxinxiVO;
import com.entity.view.YiShuJiaYiShuPinxinxiView;

@Service("gongyipinxinxiService")
public class YiShuJiaYiShuPinxinxiServiceImpl extends ServiceImpl<YiShuJiaYiShuPinxinxiDao, YiShuJiaYiShuPinxinxiEntity> implements YiShuJiaYiShuPinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiShuJiaYiShuPinxinxiEntity> page = this.selectPage(
                new Query<YiShuJiaYiShuPinxinxiEntity>(params).getPage(),
                new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper) {
		  Page<YiShuJiaYiShuPinxinxiView> page =new Query<YiShuJiaYiShuPinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<yishujiayishupinxinxiVO> selectListVO(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public yishujiayishupinxinxiVO selectVO(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiShuJiaYiShuPinxinxiView> selectListView(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiShuJiaYiShuPinxinxiView selectView(Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
