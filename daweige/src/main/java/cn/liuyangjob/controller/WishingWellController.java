package cn.liuyangjob.controller;

import cn.liuyangjob.JoinService.JoinerService;
import cn.liuyangjob.bean.PlatformActivitiesJoin;
import cn.liuyangjob.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by  liuyang
 * 2019/8/23    18:52
 * cn.liuyangjob.controller
 * All Right Reserved by liuyang.
 **/
@RestController
public class WishingWellController {
    private static volatile  int count=0;
    private static volatile  long index=255L;
    private static volatile Date date=new Date();
    @Autowired
    JoinService joinService;
    @Autowired
    JoinerService joinerService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    
    @RequestMapping("/ww")
    public synchronized  Object wishMengbao() {
        Map<String,Object> map = new HashMap<>();
        ++count;
        map.put("message","这是第"+count+"次点击,上次点击时间是："+date);
        String indexstr = stringRedisTemplate.opsForValue().get("index");
        if(indexstr == null){
            stringRedisTemplate.opsForValue().set("index",String.valueOf(index));
        }else{
            index = Long.valueOf(indexstr);
            ++index;
            stringRedisTemplate.opsForValue().set("index",String.valueOf(index));
        }
        PlatformActivitiesJoin join = joinService.getPlatformActivitiesJoinByIndexAndPlatformActivitiesId(index,2L);
        joinerService.fillAndSendObject(join);
        map.put("user",join);
        return map;
    }
}
