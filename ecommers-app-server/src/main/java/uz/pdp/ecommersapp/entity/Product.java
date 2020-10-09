package uz.pdp.ecommersapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ecommersapp.service.TimeStampedObjectSetDate;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends TimeStampedObjectSetDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Integer sold;
    private Integer views;
    @ManyToOne
    @JoinColumn
    private Categoria categoria;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_detail",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "detail_id")
    )
    private List<Detail> details;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_attachment",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id")
    )
    private List<Attachment> attachment;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_discount",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    private List<Discount> discount;



}
