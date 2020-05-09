package com.example.reactivedemo.repository;

import com.example.reactivedemo.model.Asset;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AssetRepository extends ReactiveMongoRepository<Asset, String> {
}
