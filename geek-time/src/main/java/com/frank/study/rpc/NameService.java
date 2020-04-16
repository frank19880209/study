package com.frank.study.rpc;

import java.io.IOException;
import java.net.URI;

/**
 * @ClassName: NameService
 * @Description: 注册中心
 * @Author: 孙中伟
 * @Date: 2020/4/14 19:25
 * @Version: 1.0
 */
public interface NameService {
    /**
     * 注册服务
     * @param serviceName 服务名称
     * @param uri 服务地址
     */
    void registerService(String serviceName, URI uri) throws IOException;

    /**
     * 查询服务地址
     * @param serviceName 服务名称
     * @return 服务地址
     */
    URI lookupService(String serviceName) throws IOException;
}