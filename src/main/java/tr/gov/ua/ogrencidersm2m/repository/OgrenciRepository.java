package tr.gov.ua.ogrencidersm2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.gov.ua.ogrencidersm2m.entity.Ogrenci;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {


    Ogrenci findByAd(String ad);
    Ogrenci findBySoyad(String soyad);

}
