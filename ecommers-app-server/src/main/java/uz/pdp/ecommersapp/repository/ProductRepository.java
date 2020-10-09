package uz.pdp.ecommersapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Product;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:name,'%')")
    List<Product> findProductWithPartOfName(@Param("name") String name);

    @Transactional()
    @Override
    <S extends Product> S save(S s);

    List<Product> getAllByCategoria_Id(Integer id);

    @Query("SELECT p FROM Product p ORDER BY p.insertTimestamp DESC ")
    List<Product> findBySortedDate();
}
