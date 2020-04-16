package org.frank.study.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName: LongEventFactory
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/3/22 15:33
 * @Version: 1.0
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
