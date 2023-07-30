package org.codechill.tartaruscms.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "store_user")
public class StoreUser implements Serializable {

    @EmbeddedId
    private StoreUserId storeUserId;

    @MapsId("storeId")
    @ManyToOne
    private Store store;

    @MapsId("userId")
    @ManyToOne
    private User user;


    private String role;
}
