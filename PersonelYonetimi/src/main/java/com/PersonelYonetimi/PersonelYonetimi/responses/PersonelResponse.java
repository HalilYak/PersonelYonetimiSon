package com.PersonelYonetimi.PersonelYonetimi.responses;

import com.PersonelYonetimi.PersonelYonetimi.entities.Personel;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
public class PersonelResponse {
    Long id;
    String ad_soyad;
    String dogum_yeri;
    Date dogum_tarihi;
    Double maas;
    String cinsiyet;

    public PersonelResponse(Personel entity) {
        this.id = entity.getId();
        this.ad_soyad = entity.getAd_soyad();
        this.dogum_yeri = entity.getDogum_yeri();
        this.dogum_tarihi = entity.getDogum_tarihi();
        this.maas = entity.getMaas();
        this.cinsiyet = entity.getCinsiyet();
    }
}
