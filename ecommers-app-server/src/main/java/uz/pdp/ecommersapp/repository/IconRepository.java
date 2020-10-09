package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.Icon;
import uz.pdp.ecommersapp.projection.IconProjection;

@RepositoryRestResource(path = "icon",collectionResourceRel = "district",excerptProjection = IconProjection.class)
public interface IconRepository extends JpaRepository<Icon,Integer> {
}
