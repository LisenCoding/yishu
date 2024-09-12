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

import com.entity.YiShuJiaYiShuPinfenleiEntity;
import com.entity.view.YiShuJiaYiShuPinfenleiView;

import com.service.YiShuJiaYiShuPinfenleiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 艺术家艺术品信息分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 23:52:48
 */
@RestController
@RequestMapping("/gongyipinfenlei")
public class YiShuJiaYiShuPinfenleiController {
    @Autowired
    private YiShuJiaYiShuPinfenleiService yiShuJiaYiShuPinfenleiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YiShuJiaYiShuPinfenleiEntity gongyipinfenlei,
                  HttpServletRequest request){
        EntityWrapper<YiShuJiaYiShuPinfenleiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>();
		PageUtils page = yiShuJiaYiShuPinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyipinfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YiShuJiaYiShuPinfenleiEntity gongyipinfenlei,
                  HttpServletRequest request){
        EntityWrapper<YiShuJiaYiShuPinfenleiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>();
		PageUtils page = yiShuJiaYiShuPinfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyipinfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiShuJiaYiShuPinfenleiEntity gongyipinfenlei){
       	EntityWrapper<YiShuJiaYiShuPinfenleiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongyipinfenlei, "gongyipinfenlei")); 
        return R.ok().put("data", yiShuJiaYiShuPinfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiShuJiaYiShuPinfenleiEntity gongyipinfenlei){
        EntityWrapper<YiShuJiaYiShuPinfenleiEntity> ew = new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongyipinfenlei, "gongyipinfenlei")); 
		YiShuJiaYiShuPinfenleiView yiShuJiaYiShuPinfenleiView =  yiShuJiaYiShuPinfenleiService.selectView(ew);
		return R.ok("查询艺术家艺术品信息分类成功").put("data", yiShuJiaYiShuPinfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiShuJiaYiShuPinfenleiEntity gongyipinfenlei = yiShuJiaYiShuPinfenleiService.selectById(id);
        return R.ok().put("data", gongyipinfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiShuJiaYiShuPinfenleiEntity gongyipinfenlei = yiShuJiaYiShuPinfenleiService.selectById(id);
        return R.ok().put("data", gongyipinfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiShuJiaYiShuPinfenleiEntity gongyipinfenlei, HttpServletRequest request){
    	gongyipinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyipinfenlei);
        yiShuJiaYiShuPinfenleiService.insert(gongyipinfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiShuJiaYiShuPinfenleiEntity gongyipinfenlei, HttpServletRequest request){
    	gongyipinfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyipinfenlei);
        yiShuJiaYiShuPinfenleiService.insert(gongyipinfenlei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YiShuJiaYiShuPinfenleiEntity gongyipinfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyipinfenlei);
        yiShuJiaYiShuPinfenleiService.updateById(gongyipinfenlei);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiShuJiaYiShuPinfenleiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YiShuJiaYiShuPinfenleiEntity> wrapper = new EntityWrapper<YiShuJiaYiShuPinfenleiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yiShuJiaYiShuPinfenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
