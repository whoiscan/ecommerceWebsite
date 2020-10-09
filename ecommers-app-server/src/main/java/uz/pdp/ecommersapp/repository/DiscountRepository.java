package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.Discount;
import uz.pdp.ecommersapp.projection.DiscountProjection;

@RepositoryRestResource(path = "discount",collectionResourceRel = "discount" ,excerptProjection = DiscountProjection.class)
public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}
