package org.codechill.tartaruscms.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.codechill.tartaruscms.entities.Store;

@AllArgsConstructor
@Getter
public class CreateProductRequest {

    private String name;

    private float price;

    private String image;

    private Long storeId;
}
