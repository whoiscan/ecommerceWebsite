package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.District;

@Projection(name = "district" ,types = {District.class})
public interface DistrictProjection {
     Integer getId();
     String getName();
}
