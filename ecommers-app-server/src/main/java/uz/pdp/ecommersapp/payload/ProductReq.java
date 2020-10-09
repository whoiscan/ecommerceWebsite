package uz.pdp.ecommersapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ecommersapp.entity.Categoria;
import uz.pdp.ecommersapp.entity.Detail;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {
    @NotNull
    private String name;
    @NotNull
    private Double price;
    private Categoria categoria;
    private List<Detail> details;
    private List<UUID> attachments;
}
