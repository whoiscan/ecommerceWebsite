package uz.pdp.ecommersapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartAdressSetReq {
    private boolean deliverType;
    private Integer regionId;
    private Integer districtId;
    private String street;
    private String homeNumber;
    private Integer floor;
    private  Integer podyezd;
    private  String house;
}
