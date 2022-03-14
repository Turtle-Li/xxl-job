package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
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

    @XxlJob("morningHandler")
    public void morningHandler(){
        XxlJobHelper.log("催报开始执行");
        XxlJobHelper.handleFail("测试失败");
        log.info("催报执行");
        XxlJobHelper.log("催报执行结束");
    }

}
