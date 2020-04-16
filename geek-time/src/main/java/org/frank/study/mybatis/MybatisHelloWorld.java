package org.frank.study.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @ClassName: MybatisHelloWorld
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/3/7 12:36
 * @Version: 1.0
 */
public class MybatisHelloWorld {

    public static void main(String[] args) {
        Reader reader;
        InputStream inputStream = MybatisHelloWorld.class.getResourceAsStream("/mybatis/Configuration.xml");
        reader = new InputStreamReader(inputStream);
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        try {
            FeedBackInfo feedBackInfo = (FeedBackInfo) session.selectOne("org.study.mybatis.FeedBackInfoMapper.getById", 4);
            System.out.println(feedBackInfo.getRemarkForSatisfaction());
        } finally {
            session.close();
        }
    }
}
