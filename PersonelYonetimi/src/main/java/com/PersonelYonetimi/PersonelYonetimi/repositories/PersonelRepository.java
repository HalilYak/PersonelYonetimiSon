package com.PersonelYonetimi.PersonelYonetimi.repositories;

import com.PersonelYonetimi.PersonelYonetimi.entities.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel, Long> {
}

