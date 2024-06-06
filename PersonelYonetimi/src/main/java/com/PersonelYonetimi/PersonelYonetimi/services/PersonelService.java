package com.PersonelYonetimi.PersonelYonetimi.services;

import com.PersonelYonetimi.PersonelYonetimi.entities.Personel;
import com.PersonelYonetimi.PersonelYonetimi.repositories.PersonelRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelService {
    PersonelRepository personelRepository;

    public PersonelService(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    public List<Personel> getAllPersonel() {
        return personelRepository.findAll();
    }

    public Personel saveOnePersonel(Personel newPersonel) {
        return personelRepository.save(newPersonel);
    }

    public Personel getOnePersonelById(Long personelId) {
        return personelRepository.findById(personelId).orElse(null);
    }

    public Personel updateOnePersonel(Long personelId, Personel newPersonel) {
        Optional<Personel> personel = personelRepository.findById(personelId);
        if (personel.isPresent()) {
            Personel foundPersonel = personel.get();
            foundPersonel.setAd_soyad(newPersonel.getAd_soyad());
            foundPersonel.setDogum_yeri(newPersonel.getDogum_yeri());
            foundPersonel.setDogum_tarihi(newPersonel.getDogum_tarihi());
            foundPersonel.setMaas(newPersonel.getMaas());
            foundPersonel.setCinsiyet(newPersonel.getCinsiyet());
            personelRepository.save(foundPersonel);
            return foundPersonel;
        } else {
            return null;
        }
    }

    public void deleteById(Long personelId) {
        try {
            personelRepository.deleteById(personelId);
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("Personel " + personelId + " bulunamadı.");
        }
    }

}
