package uz.pdp.ecommersapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReq {
    @NotNull
    private  String name;
    private  Integer parent_id;
}
