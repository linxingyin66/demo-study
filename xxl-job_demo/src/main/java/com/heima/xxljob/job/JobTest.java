package com.heima.xxljob.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JobTest
 * @Description
 * @Author LXY
 * @Date 2023/10/24 15:09
 **/
@Component
public class JobTest {

    @Value("${server.port}")
    private String port;

    @XxlJob("JobHandler1")
    public void jobTest(){
        System.out.println("任务执行了...."+port);
    }

    //分片广播
    @XxlJob("JobHandler2")
    public void jobTest2(){
        //分片参数
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();
        XxlJobHelper.log("分片参数：当前分片序号={}，总分片数={}",shardIndex,shardTotal);

        List<Integer> list = getList();

        for (Integer integer : list) {
            if (integer % shardTotal == shardIndex) {
                System.out.println("第" + shardIndex + "分片执行，执行数据为：" + integer);
            }
        }
    }

    private List<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        return list;
    }

}
