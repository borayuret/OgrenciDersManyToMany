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
public class Ders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dersAdi;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "dersler")
    private Set<Ogrenci> ogrenciler = new HashSet<>();

}
