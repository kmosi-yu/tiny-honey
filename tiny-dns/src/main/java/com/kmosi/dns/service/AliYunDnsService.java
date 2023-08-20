package com.kmosi.dns.service;

import com.aliyun.alidns20150109.models.AddDomainRecordResponseBody;
import com.aliyun.alidns20150109.models.DeleteSubDomainRecordsResponseBody;
import com.aliyun.alidns20150109.models.DescribeDomainRecordsResponseBody;
import com.aliyun.alidns20150109.models.UpdateDomainRecordResponseBody;

/**
 * @author 阡陌兮
 * @version 1.0.0
 * @date 2023-08-13 11:00
 * @description aliyunDDNS 操作
 */
public interface AliYunDnsService {
    /**
     * 获取DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @return 记录
     */
    DescribeDomainRecordsResponseBody getDomainRecords(String domainName, String prefix, String type);

    /**
     * 更新DomainRecords
     *
     * @param recordId 记录ID
     * @param prefix   前缀
     * @param type     类型
     * @param ip       Ip
     * @return 记录
     */
    UpdateDomainRecordResponseBody updateDomainRecords(String recordId, String prefix, String type, String ip);

    /**
     * 添加DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @param ip         Ip
     * @return 记录
     */
    AddDomainRecordResponseBody addDomainRecords(String domainName, String prefix, String type, String ip);

    /**
     * 删除DomainRecords
     *
     * @param domainName 域名
     * @param prefix     前缀
     * @param type       类型
     * @return 记录
     */
    DeleteSubDomainRecordsResponseBody deleteDomainRecords(String domainName, String prefix, String type);
}
