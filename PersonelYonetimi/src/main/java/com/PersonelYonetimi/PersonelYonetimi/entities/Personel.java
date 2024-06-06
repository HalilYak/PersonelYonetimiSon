package com.PersonelYonetimi.PersonelYonetimi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name="tbl_personel")
@Data
public class Personel {
    @Id
    Long id;
    String ad_soyad;
    String dogum_yeri;
    Date dogum_tarihi;
    Double maas;
    String cinsiyet;
}