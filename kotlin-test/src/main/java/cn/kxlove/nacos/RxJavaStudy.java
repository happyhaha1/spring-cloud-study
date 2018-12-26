package cn.kxlove.nacos;

import cn.kxlove.User;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscription;

/**
 * <p>RxJavaStudy</p>
 *
 * @author zhengkaixin
 * @since 2018-12-25 16:21
 */
public class RxJavaStudy {

    public static void main(String[] args) {
//        Flowable.just("Hello world").subscribe(System.out::println);
        Flowable<String> flowable = Flowable.create((FlowableOnSubscribe<String>) e -> {
            e.onNext("test1");
            e.onNext("test2");
            e.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.subscribe(new FlowableSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onComplete() {
                System.out.println("done");
            }
        });
        User happy = new User("happy");
        happy.getFirstName();
    }
}
