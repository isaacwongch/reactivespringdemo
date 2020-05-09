package com.example.reactivedemo.service;

import com.example.reactivedemo.model.Asset;
import com.example.reactivedemo.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Flux<Asset> getAllAssets(){
        return this.assetRepository.findAll();
    }

}
