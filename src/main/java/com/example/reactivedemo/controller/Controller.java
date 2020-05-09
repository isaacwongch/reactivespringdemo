package com.example.reactivedemo.controller;

import com.example.reactivedemo.model.Asset;
import com.example.reactivedemo.model.Fund;
import com.example.reactivedemo.repository.AssetRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@RestController
public class Controller {

    @Autowired
    private AssetRepository repository;

    @PostMapping("/asset")
    Mono<Void> create(@RequestBody Publisher<Asset> assetStream) {
        return repository.insert(assetStream).then();
    }

    @GetMapping("/assets")
    Flux<Asset> list() {
        return repository.findAll();
    }

    @GetMapping(value = "/assets/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Asset> events() {
        Flux<Asset> assetsFlux = Flux.fromStream(Stream.generate(() -> new Fund(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, "Fund @" + Instant.now().toString())));
        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(assetsFlux, durationFlux).map(Tuple2::getT1);
    }

}
