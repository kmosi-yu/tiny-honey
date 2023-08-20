package com.kmosi.dns.api.biz;

import com.aliyun.alidns20150109.models.AddDomainRecordResponseBody;
import com.aliyun.alidns20150109.models.DeleteSubDomainRecordsResponseBody;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponseBody;
import com.aliyun.alidns20150109.models.UpdateDomainRecordResponseBody;
import com.kmosi.dns.service.AliYunDnsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-12 21:32
 * @description DNS API
 */
@RestController
@RequestMapping("/v1/biz/aliyun")
public class AliYunDnsController {
    @Resource
    private AliYunDnsService aliYunDnsService;

    /**
     * 获取DNS
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @return 结果
     */

    @GetMapping("/dns")
    public DescribeDomainRecordsResponseBody getDomainRecords(String domainName, String prefix, String type) {
        return aliYunDnsService.getDomainRecords(domainName, prefix, type);
    }

    /**
     * 修改DNS
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型A、@
     * @param ip         IP地址
     * @return 结果
     */
    @PutMapping("/dns")
    public UpdateDomainRecordResponseBody updateDomainRecords(String domainName, String prefix, String type, String ip) {
        // 获取记录
        var record = aliYunDnsService.getDomainRecords(domainName, prefix, type);
        if (record.getTotalCount() > 0) {
            var recordId = record.getDomainRecords().getRecord().get(0).recordId;
            return aliYunDnsService.updateDomainRecords(recordId, prefix, type, ip);
        } else {
            return null;
        }
    }

    /**
     * 添加DNS
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型A、@
     * @param ip         IP地址
     * @return 结果
     */
    @PostMapping("/dns")
    public AddDomainRecordResponseBody addDomainRecords(String domainName, String prefix, String type, String ip) {
        return aliYunDnsService.addDomainRecords(domainName, prefix, type, ip);
    }

    /**
     * 删除DNS
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型A、@
     * @return 结果
     */
    @DeleteMapping("/dns")
    public DeleteSubDomainRecordsResponseBody deleteDomainRecords(String domainName, String prefix, String type) {
        return aliYunDnsService.deleteDomainRecords(domainName, prefix, type);
    }
}
