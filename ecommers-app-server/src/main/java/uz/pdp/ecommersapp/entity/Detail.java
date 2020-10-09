package uz.pdp.ecommersapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Integer id;
 private  String name;
 private  String value;
    @OneToMany(
            mappedBy = "detail",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private  List<DetailType>detailTypes;


    private  boolean is_main;
}
