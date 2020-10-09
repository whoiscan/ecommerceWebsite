package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.Region;
import uz.pdp.ecommersapp.projection.RegionProjection;

@RepositoryRestResource(path = "region",collectionResourceRel = "region" ,excerptProjection = RegionProjection.class)
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
