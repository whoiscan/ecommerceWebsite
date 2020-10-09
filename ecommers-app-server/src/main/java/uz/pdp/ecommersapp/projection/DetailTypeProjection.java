package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.Detail;
import uz.pdp.ecommersapp.entity.DetailType;

@Projection(name = "detailtype" ,types = {DetailType.class})
public interface DetailTypeProjection {
    Integer getId();
    String getName();
    Detail getDetail();
}
