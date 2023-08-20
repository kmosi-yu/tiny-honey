package com.kmosi.dns.scheduler.job;

import com.alibaba.fastjson2.JSON;
import com.kmosi.dns.common.helper.IpHelper;
import com.kmosi.dns.common.utils.ThreadLocalUtils;
import com.kmosi.dns.service.AliYunDnsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;


/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 13:52
 * @description
 */
@Slf4j
public class DnsJob implements Job {
    @Resource
    private AliYunDnsService dnsService;
    @Resource
    private IpHelper ipHelper;

    /**
     * 执行方法
     *
     * @param context 上下文
     */
    @Override
    public void execute(JobExecutionContext context) {
        // 获取jobDetail
        JobDetail jobDetail = context.getJobDetail();
        // 获取数据信息
        JobDataMap dataMap = jobDetail.getJobDataMap();
        // 参数进行保存
        ThreadLocalUtils.put("context", JSON.toJSONString(dataMap));
        String domainName = dataMap.getString("domainName"),
                prefix = dataMap.getString("prefix"),
                type = dataMap.getString("type");
        // 获取解析记录
        var records = dnsService.getDomainRecords(domainName, prefix, type);
        var record = records.getDomainRecords().getRecord().get(0);
        ThreadLocalUtils.put("records", JSON.toJSONString(records));
        // 获取公网IP
        var ip = ipHelper.getIpv4();
        if (!ip.equalsIgnoreCase(record.getValue())) {
            // 更新解析记录
            var updateRecords = dnsService.updateDomainRecords(record.getRecordId(), prefix, type, ip);
            log.info("更新后数据:{}", JSON.toJSONString(updateRecords));
        } else {
            log.info("数据一致，DNS中IP为：{}；服务器IP为：{}", record.getValue(), ip);
        }

    }
}
