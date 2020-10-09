package uz.pdp.ecommersapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne//(fetch = FetchType.LAZY)
    private Region region;
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_district",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "district_id"))
    private District district;
    private String street;
    private String homeNumber;
    private Integer floor;
    private  Integer podyezd;
    private  String house;
}
