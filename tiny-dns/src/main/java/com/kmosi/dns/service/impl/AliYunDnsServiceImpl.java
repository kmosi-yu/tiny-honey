package com.kmosi.dns.service.impl;

import com.aliyun.alidns20150109.Client;
import com.aliyun.alidns20150109.models.*;
import com.kmosi.dns.service.AliYunDnsService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 11:11
 * @description aliyunDDNS 操作
 */
@Service
public class AliYunDnsServiceImpl implements AliYunDnsService {
    @Resource
    private Client client;

    /**
     * 获取DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @return 记录
     */
    @Override
    @SneakyThrows
    public DescribeDomainRecordsResponseBody getDomainRecords(String domainName, String prefix, String type) {
        DescribeDomainRecordsRequest req = new DescribeDomainRecordsRequest();
        // 主域名
        req.domainName = domainName;
        // 主机记录
        req.RRKeyWord = prefix;
        // 解析记录类型
        req.type = type;
        return client.describeDomainRecords(req).getBody();
    }

    /**
     * 更新DomainRecords
     *
     * @param recordId 记录ID
     * @param prefix   前缀
     * @param type     类型
     * @param ip       Ip
     * @return 记录
     */
    @Override
    @SneakyThrows
    public UpdateDomainRecordResponseBody updateDomainRecords(String recordId, String prefix, String type, String ip) {
        var req = new UpdateDomainRecordRequest();
        // 主机记录
        req.RR = prefix;
        // 记录ID
        req.recordId = recordId;
        // 将主机记录值改为当前主机IP
        req.value = ip;
        // 解析记录类型
        req.type = type;
        return client.updateDomainRecord(req).getBody();
    }

    /**
     * 添加DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @param ip         Ip
     * @return 记录
     */
    @Override
    @SneakyThrows
    public AddDomainRecordResponseBody addDomainRecords(String domainName, String prefix, String type, String ip) {
        var req = new AddDomainRecordRequest();
        // 主域名
        req.domainName = domainName;
        // 主机记录
        req.RR = prefix;
        // 解析记录类型
        req.type = type;
        req.value = ip;
        return client.addDomainRecord(req).getBody();
    }

    /**
     * 删除DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @return 记录
     */
    @Override
    @SneakyThrows
    public DeleteSubDomainRecordsResponseBody deleteDomainRecords(String domainName, String prefix, String type) {
        var req = new DeleteSubDomainRecordsRequest();
        // 主域名
        req.domainName = domainName;
        // 主机记录
        req.RR = prefix;
        // 解析记录类型
        req.type = type;
        return client.deleteSubDomainRecords(req).getBody();
    }
}
