package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.District;
import uz.pdp.ecommersapp.entity.Region;

import java.util.List;

@Projection(name = "region" ,types = {Region.class})
public interface RegionProjection {
    Integer getId();
    String getName();
    List<District> getDistricts();
}
