package org.frank.study.mybatis;

import java.util.List;

/**
 * @author 孙中伟
 * @description: TODO
 * @date 2019/8/11 14:09
 */
public interface FeedBackInfoMapper {
    List<FeedBackInfo> listBy(FeedBackInfoQuery query);

    void insert(FeedBackInfo t);

    void deleteById(Long id);

    FeedBackInfo getById(Long id);
}
