package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yicall.sso.rpc.service.RpcUserUrgeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author lijiayu
 * @date 2022/3/14
 */
@Component
public class UserUrgeXxlJob {
    private static final Logger log = LoggerFactory.getLogger(UserUrgeXxlJob.class);

    @DubboReference(version = "1.0.0")
    private RpcUserUrgeService rpcUserUrgeService;

    @XxlJob("morningHandler")
    public void morningHandler(){
        try{
            rpcUserUrgeService.morningExecute();
        }catch (Exception e){
            XxlJobHelper.handleFail("上午催报定时异常");
        }
    }

    @XxlJob("nightHandler")
    public void nightHandler(){
        try{
            rpcUserUrgeService.nightExecute();
        }catch (Exception e){
            XxlJobHelper.handleFail("晚上催报定时异常");
        }
    }

    @XxlJob("everyMonthHandler")
    public void everyMonthHandler(){
        try{
            rpcUserUrgeService.everyMonthExecute();
        }catch (Exception e){
            XxlJobHelper.handleFail("每周一催报定时异常");
        }
    }

    @XxlJob("customizeHandler")
    public void customizeHandler(){
        try{
            rpcUserUrgeService.customizeExecute();
        }catch (Exception e){
            XxlJobHelper.handleFail("自定义催报定时异常");
        }
    }
}
