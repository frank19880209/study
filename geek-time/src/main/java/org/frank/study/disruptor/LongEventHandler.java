package org.frank.study.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @ClassName: LongEventHandler
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/3/22 15:36
 * @Version: 1.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}
