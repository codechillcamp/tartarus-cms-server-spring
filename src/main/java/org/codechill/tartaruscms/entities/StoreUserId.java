package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class StoreUserId implements Serializable {
    private Long userId;

    private Long storeId;
}
