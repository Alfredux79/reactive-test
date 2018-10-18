package io.alfredux.reactivetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

@Slf4j
public class FluxAPITests {

    @Test
    public void parallelTest() throws InterruptedException {

        Flux.range(1, 10)
                .parallel(2)
                .runOn(Schedulers.parallel())
                .subscribe(n -> log.info("{}", n));

        Thread.sleep(1000);
    }

    @Test
    public void connectableFlux() throws InterruptedException {

        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed to source"));

        ConnectableFlux<Integer> co = source.publish();

        co.subscribe(System.out::println);
        co.subscribe(System.out::println);

        System.out.println("done subscribing");
        Thread.sleep(500);
        System.out.println("will now connect");

        co.connect();
    }

    @Test
    public void intervalEmitter() throws InterruptedException {

        Flux<LocalDateTime> dateEmitter = Flux.interval(Duration.ofSeconds(1))
                .map(t -> LocalDateTime.now());
        dateEmitter
                .parallel(2)
                .runOn(Schedulers.parallel())
                .subscribe(t -> log.info(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))));
        Thread.sleep(5000);
    }

    @Test
    public void eventProducer() throws InterruptedException {
        EventProducer eventProducer = new EventProducer();
        Flux<String> dynamicFlux = Flux.create(sink -> eventProducer.register(sink));
        dynamicFlux.subscribe(System.out::println);
        IntStream.range(1, 5).forEach(eventProducer::generate);
        Thread.sleep(100);
    }

    class EventProducer {

        FluxSink<String> sink;

        void generate(Integer i) {
            sink.next(String.format("event %d:la %s", i, LocalDateTime.now().toString()));
        }

        public void register(FluxSink<String> sink) {
            this.sink = sink;
        }
    }

}





