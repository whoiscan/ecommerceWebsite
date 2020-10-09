package uz.pdp.ecommersapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.ecommersapp.entity.Categoria;


@Repository
public interface CategoryRepository extends JpaRepository<Categoria,Integer> {
}
