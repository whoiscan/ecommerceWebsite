package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.Discount;

import java.util.Date;

@Projection(name = "discount" ,types = {Discount.class})
public interface DiscountProjection {
    Integer getId();
    Double getPercentage();
    Date getStartDate();
    Date getExpireDate();
}
