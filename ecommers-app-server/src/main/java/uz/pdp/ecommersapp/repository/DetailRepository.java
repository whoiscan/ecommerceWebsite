package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.Detail;
import uz.pdp.ecommersapp.projection.DetailProjection;

@RepositoryRestResource(path = "detail",collectionResourceRel = "detail",excerptProjection= DetailProjection.class)
public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
