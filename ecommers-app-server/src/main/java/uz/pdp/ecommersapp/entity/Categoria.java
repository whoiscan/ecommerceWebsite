package uz.pdp.ecommersapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer id;
  private  String name;
  private  Integer parent_id;
    @OneToOne(cascade = CascadeType.ALL)
    private Icon icon;

}
