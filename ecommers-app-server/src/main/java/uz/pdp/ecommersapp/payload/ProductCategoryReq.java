package uz.pdp.ecommersapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategoryReq {
    @NotNull
    private Integer id;
   private String name;
}
