package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "khachhang")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "makh", unique = true)
    String makh;

    @Column(name = "tenkh")
    String tenkh;

    @Column(name = "sdt", unique = true)
    String sdt;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "mat_khau")
    String matkhau;

    @Column(name = "quyen")
    String quyen;

    public Set<String> getQuyen() {
        return Arrays.stream(quyen.split(","))
                .collect(Collectors.toSet());
    }

    public void setQuyen(Set<String> Quyen) {
        this.quyen = String.join(",", Quyen);
    }
}
