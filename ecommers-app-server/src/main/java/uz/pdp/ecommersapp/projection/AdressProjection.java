package uz.pdp.ecommersapp.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.ecommersapp.entity.Adress;
import uz.pdp.ecommersapp.entity.District;
import uz.pdp.ecommersapp.entity.Region;

@Projection(name = "adress" ,types = {Adress.class})
public interface AdressProjection {
   Integer getId();
  Region getRegion();
  District getDistrict();
  String getStreet();
  String getHomeNumber();
  Integer getFloor();
  Integer getPodyezd();
  String getHouse();
}
