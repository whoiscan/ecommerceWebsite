package uz.pdp.ecommersapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.ecommersapp.entity.Categoria;
import uz.pdp.ecommersapp.payload.CategoryReq;
import uz.pdp.ecommersapp.payload.Result;
import uz.pdp.ecommersapp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/category")
public class CategoriaController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/take")
    public ResponseEntity<List<Categoria>> takeCategories() {
        List<Categoria> categorias = categoryRepository.findAll();
        if (categorias != null) {
            return ResponseEntity.ok(categorias);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Result> saveCategory(@RequestBody CategoryReq categoryReq) {
        Categoria categoria = new Categoria();
        categoria.setName(categoryReq.getName());
        if (categoryReq.getParent_id() == null) {
            categoria.setParent_id(0);
        } else {
            categoria.setParent_id(categoryReq.getParent_id());
        }
      Categoria savedCategoria=  categoryRepository.save(categoria);
        if (savedCategoria!=null){
            Result result=new Result();
        result.setSuccess(true);
        result.setMessage(categoryReq.getName()+"successfully saved");
            return ResponseEntity.ok(result);
        }
            else{
            Result result=new Result();
            result.setSuccess(false);
            result.setMessage(categoryReq.getName()+"not saved.Server Error");
                return ResponseEntity.status(500).body(result);
        }
    }
@PutMapping("/edit/{id}")
public ResponseEntity<Result> editCategory(@PathVariable Integer id, @RequestBody CategoryReq categoryReq){
    Optional<Categoria> optional = categoryRepository.findById(id);
    if (optional.isPresent()){
        Categoria categoria=optional.get();
    categoria.setName(categoryReq.getName());
    if (categoryReq.getParent_id() == null) {
        categoria.setParent_id(0);
    } else {
        categoria.setParent_id(categoryReq.getParent_id());
    }
    Categoria savedCategoria=  categoryRepository.save(categoria);
    if (savedCategoria!=null){
        Result result=new Result();
        result.setSuccess(true);
        result.setMessage(categoryReq.getName()+"successfully saved");
        return ResponseEntity.ok(result);
    }
    else{
        Result result=new Result();
        result.setSuccess(false);
        result.setMessage(categoryReq.getName()+"not saved.Server Error");
        return ResponseEntity.status(500).body(result);
    }

}else {
        Result result=new Result();
        result.setSuccess(false);
        result.setMessage(categoryReq.getName()+"not saved.Id not sended in response");
        return ResponseEntity.status(400).body(result);
    }
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Result> deleteCategory(@PathVariable Integer id){
        categoryRepository.deleteById(id);
        Categoria categoria=categoryRepository.getOne(id);
        if (categoria==null){
            Result result=new Result();
            result.setSuccess(true);
            result.setMessage("successfully deleted");
            return ResponseEntity.ok(result);

        }
        else{
            Result result=new Result();
            result.setSuccess(false);
            result.setMessage(categoria.getName()+"not deleted.Server Error");
            return ResponseEntity.status(500).body(result);
        }
    }

}
