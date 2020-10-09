package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.DetailType;
import uz.pdp.ecommersapp.projection.DetailTypeProjection;

@RepositoryRestResource(path = "detailtype",collectionResourceRel = "detailtype",excerptProjection = DetailTypeProjection.class)
public interface DeteilTypeRepository extends JpaRepository<DetailType,Integer> {
}
