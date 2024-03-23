package com.epicode.capstone.Capstone.Backend.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.epicode.capstone.Capstone.Backend.dto.ProductDTO;
import com.epicode.capstone.Capstone.Backend.entities.Product;
import com.epicode.capstone.Capstone.Backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size,
                                        @RequestParam(defaultValue = "id") String sort){
        return this.productService.getProducts(page,size,sort);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO newProduct, @RequestHeader("Authorization") String token){

        DecodedJWT jwt = JWT.decode(token.split(" ")[1]);
        String tokenSub = jwt.getClaim("sub").asString();
        if(!tokenSub.equals("admin@epichw.com")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(this.productService.saveProduct(newProduct));
    }

    @PutMapping("/{id}")
    public Product findByIdAndUpdate(@PathVariable Long id, @RequestBody Product updatedProduct){
        return this.productService.findByIdAndUpdate(id,updatedProduct);
    }

    @GetMapping("/findByCategoryId")
    public Page<Product> findByCategoryId(@RequestParam Long id, Pageable pageable){
        return this.productService.findByCategory(id, pageable);
    }

    @GetMapping("/findByName")
    public Page<Product> findByName(@RequestParam String name, Pageable pageable){
        return this.productService.findByName(name, pageable);
    }

    @GetMapping("/findByNameList")
    public List<Product> findByName(@RequestParam String name){
        return this.productService.findByNameList(name);
    }

   @GetMapping("/findByCategoryName")
    public List<Product> findByCategoryName(@RequestParam String categoryName){
        return this.productService.findByCategory(categoryName);
   }

   @GetMapping("/list")
    public List<Product> getAllProducts(){
        return this.productService.getProductsList();
   }

   @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.findByIdAndDelete(id);
   }


}
