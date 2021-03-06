package com.to.aboomy.rx_lib;

import android.os.Looper;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * auth aboom
 * date 2018/5/29
 */
public class RxUtil {

    /**
     * 延时操作
     */
    public static Observable<Long> timer(Long delay) {
        return Observable.timer(delay, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
    }

    /**
     * rx执行倒计时
     *
     * @param time 秒数
     */
    public static Observable<Integer> countdown(int time) {
        if (time < 0) {
            time = 0;
        }
        final int countTime = time;
        return Observable.interval(0, 1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map(increaseTime -> countTime - increaseTime.intValue())
                .take(countTime + 1);
    }


    /**
     * 安全的线程操作
     */
    public static Disposable safelyTask(Action action0) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return Observable.empty().subscribe(o -> action0.run());
        } else {
            return AndroidSchedulers.mainThread().scheduleDirect(() -> {
                try {
                    action0.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
