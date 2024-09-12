package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YiShuJiaYiShuPinxinxiEntity;
import com.entity.view.YiShuJiaYiShuPinxinxiView;

import com.service.YiShuJiaYiShuPinxinxiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.service.StoreupService;

/**
 * 艺术家艺术品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
@RestController
@RequestMapping("/gongyipinxinxi")
public class YiShuJiaYiShuPinxinxiController {
    @Autowired
    private YiShuJiaYiShuPinxinxiService yiShuJiaYiShuPinxinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YiShuJiaYiShuPinxinxiEntity gongyipinxinxi,
                  HttpServletRequest request){
        EntityWrapper<YiShuJiaYiShuPinxinxiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>();
		PageUtils page = yiShuJiaYiShuPinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyipinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YiShuJiaYiShuPinxinxiEntity gongyipinxinxi,
                  HttpServletRequest request){
        EntityWrapper<YiShuJiaYiShuPinxinxiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>();
		PageUtils page = yiShuJiaYiShuPinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyipinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiShuJiaYiShuPinxinxiEntity gongyipinxinxi){
       	EntityWrapper<YiShuJiaYiShuPinxinxiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongyipinxinxi, "gongyipinxinxi")); 
        return R.ok().put("data", yiShuJiaYiShuPinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiShuJiaYiShuPinxinxiEntity gongyipinxinxi){
        EntityWrapper<YiShuJiaYiShuPinxinxiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongyipinxinxi, "gongyipinxinxi")); 
		YiShuJiaYiShuPinxinxiView yiShuJiaYiShuPinxinxiView =  yiShuJiaYiShuPinxinxiService.selectView(ew);
		return R.ok("查询艺术家艺术品信息成功").put("data", yiShuJiaYiShuPinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiShuJiaYiShuPinxinxiEntity gongyipinxinxi = yiShuJiaYiShuPinxinxiService.selectById(id);
        return R.ok().put("data", gongyipinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiShuJiaYiShuPinxinxiEntity gongyipinxinxi = yiShuJiaYiShuPinxinxiService.selectById(id);
        return R.ok().put("data", gongyipinxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YiShuJiaYiShuPinxinxiEntity gongyipinxinxi = yiShuJiaYiShuPinxinxiService.selectById(id);
        if(type.equals("1")) {
        	gongyipinxinxi.setThumbsupnum(gongyipinxinxi.getThumbsupnum()+1);
        } else {
        	gongyipinxinxi.setCrazilynum(gongyipinxinxi.getCrazilynum()+1);
        }
        yiShuJiaYiShuPinxinxiService.updateById(gongyipinxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiShuJiaYiShuPinxinxiEntity gongyipinxinxi, HttpServletRequest request){
    	gongyipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyipinxinxi);
        yiShuJiaYiShuPinxinxiService.insert(gongyipinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiShuJiaYiShuPinxinxiEntity gongyipinxinxi, HttpServletRequest request){
    	gongyipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyipinxinxi);
        yiShuJiaYiShuPinxinxiService.insert(gongyipinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YiShuJiaYiShuPinxinxiEntity gongyipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyipinxinxi);
        yiShuJiaYiShuPinxinxiService.updateById(gongyipinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiShuJiaYiShuPinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YiShuJiaYiShuPinxinxiEntity> wrapper = new EntityWrapper<YiShuJiaYiShuPinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yiShuJiaYiShuPinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
