package tr.gov.ua.ogrencidersm2m;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.gov.ua.ogrencidersm2m.entity.Ders;
import tr.gov.ua.ogrencidersm2m.entity.Ogrenci;
import tr.gov.ua.ogrencidersm2m.repository.OgrenciRepository;

import java.util.HashSet;

@SpringBootApplication
public class OgrenciDersManyToManyApplication implements CommandLineRunner {

    @Autowired
    private OgrenciRepository ogrenciRepository;

    public static void main(String[] args){
        SpringApplication.run(OgrenciDersManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Ogrenci ogr1 = new Ogrenci();
        ogr1.setOgrenciNo(1234);
        ogr1.setAd("Bora");
        ogr1.setSoyad("Yüret");
        ogr1.setHarc(1000);

        Ogrenci ogr2 = new Ogrenci();
        ogr2.setOgrenciNo(1235);
        ogr2.setAd("Gökay");
        ogr2.setSoyad("Yüret");
        ogr2.setHarc(5000);


        Ders ders1 = new Ders();
        ders1.setDersAdi("Matematik");

        Ders ders2 = new Ders();
        ders2.setDersAdi("Edebiyat");

        Ders ders3 = new Ders();
        ders3.setDersAdi("Tarih");

        ogr1.getDersler().add(ders1);
        ogr1.getDersler().add(ders3);

        ogr2.getDersler().add(ders2);
        ogr2.getDersler().add(ders3);

        ders1.getOgrenciler().add(ogr1);
        ders2.getOgrenciler().add(ogr2);
        ders3.getOgrenciler().add(ogr1);
        ders3.getOgrenciler().add(ogr2);

        ogrenciRepository.save(ogr1);
        ogrenciRepository.save(ogr2);




    }
}
