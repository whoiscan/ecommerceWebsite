package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.ecommersapp.entity.PayType;
import uz.pdp.ecommersapp.projection.PayTypeProjection;

@RepositoryRestResource(path = "paytype",collectionResourceRel = "paytype",excerptProjection = PayTypeProjection.class)
public interface PayTypeRepository  extends JpaRepository<PayType,Integer> {
}
