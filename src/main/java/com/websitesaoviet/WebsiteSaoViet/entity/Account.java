package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "taikhoan")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "matk", unique = true)
    String MaTK;

    @Column(name = "sdt", unique = true)
    String sdt;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "mat_khau")
    String MatKhau;

    @Column(name = "quyen")
    String Quyen = null;
}
