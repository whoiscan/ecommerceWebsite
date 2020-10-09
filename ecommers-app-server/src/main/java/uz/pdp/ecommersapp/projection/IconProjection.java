package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.Icon;

@Projection(name = "icon" ,types = {Icon.class})
public interface IconProjection {
     Integer getId();
     byte[] getIcon();
}
