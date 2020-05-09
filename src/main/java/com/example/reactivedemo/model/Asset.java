package com.example.reactivedemo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Document(collection = "assets")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "assetType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(name="BOND", value=Bond.class),
        @JsonSubTypes.Type(name="EQUITY", value=Equity.class),
        @JsonSubTypes.Type(name="FUND", value=Fund.class)})
public abstract class Asset {
    @Id
    private String id;
    private String name;
    private String ticker;
    private String description;
    private String sector;
    private String assetType;
    private LocalDate createdTime;
}
