package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.PayType;

@Projection(name = "paytype", types = {PayType.class})
public interface PayTypeProjection {
    Integer getId();
    String getName();
}
