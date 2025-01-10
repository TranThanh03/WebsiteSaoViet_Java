package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tour")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tour {
    @Id
    @Column(name = "id", unique = true)
    String id;

    @Column(name = "name")
    String name;

    @Column(name = "image")
    String image;

    @Column(name = "introduce")
    String introduce;

    @Column(name = "description")
    String description;

    @Column(name = "category_id")
    int categoryId;

    @Column(name = "price")
    String price;
}
