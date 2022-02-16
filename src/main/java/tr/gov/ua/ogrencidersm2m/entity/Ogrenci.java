package tr.gov.ua.ogrencidersm2m.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ogrenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long ogrenciNo;
    private String ad;
    private String soyad;
    private double harc;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinTable(
                   name = "ogrenci_ders",
                   joinColumns = {
                        @JoinColumn(name = "ogrenci_id")
                   },
                   inverseJoinColumns = {
                        @JoinColumn(name = "ders_id")
                   }
               )
    private Set<Ders> dersler = new HashSet<>();

}
