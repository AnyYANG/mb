package cn.liuyangjob.PhoneData;

import cn.liuyangjob.util.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by  liuyang
 * 2019/8/23    11:52
 * cn.liuyangjob.PhoneData
 * All Right Reserved by liuyang.
 **/

public class PhoneData {
    private static BlockingQueue<String> mobiles = new ArrayBlockingQueue<String>(200);
    static Map<String, String> map = new HashMap<>();
    volatile static int i = 0;

    static {
        String url3 = "https://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=38&cityCode=380&searchCategory=3&goodsNet=4&qryType=02&groupKey=7600283944&judgeType=0&_=1566539365285";
        String url2 = "https://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=87&cityCode=870&searchCategory=3&goodsNet=4&qryType=02&groupKey=3700280312&judgeType=1&_=1566539233681";
        String url = "https://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=51&cityCode=510&searchCategory=3&goodsNet=4&qryType=02&groupKey=7300295357&judgeType=1&_=1566531971361";
        String url4 = "https://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=76&cityCode=760&searchCategory=3&goodsNet=4&qryType=01&groupKey=&judgeType=0&_=1566539500748&_=1566539500748";
        String url5 = "https://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=51&cityCode=510&searchCategory=3&goodsNet=4&qryType=02&groupKey=7300295357&judgeType=1&_=1566539539650&_=1566539539650";
        map.put("0", url);
        map.put("2", url2);
        map.put("3", url3);
        map.put("4", url4);
        map.put("1", url5);
    }

    public static void main(String args[]) {
        for (int i = 0; i < 2000; i++) {
            System.out.println(getMobile());
        }
    }

    public static String getMobile() {
        String mobile = null;
        int i = mobiles.size();
        if (i == 0) {
            System.out.println("需要弹药。。");
            requestNewMobile();
            System.out.println("补充完毕,弹药共：" + mobiles.size());
        }
        return mobiles.poll();
    }

    public synchronized static void requestNewMobile() {
        //只有当队列生于空间大于100的时候 才进行请求
        if (mobiles.remainingCapacity() > 100) {
            System.out.println("请求数据中。。。");

            Map<String, String> param = new HashMap<String, String>();
            try {
                int j = i % 5;
                ++i;
                System.out.println(map.get(j + ""));
                String url = map.get(j + "");
                String res = HttpUtil.get(url, param);
                res = res.replace("jsonp_queryMoreNums(", "");
                res = res.replace("})", "}");
                JSONObject json = JSONObject.parseObject(res);
                //获取item，得到json数组
                JSONArray array = json.getJSONArray("numArray");
                array.forEach(num -> {
                    String temp = num.toString();
                    if (temp.length() > 7) {
                        mobiles.add(temp);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
