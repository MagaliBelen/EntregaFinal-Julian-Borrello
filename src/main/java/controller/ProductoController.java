package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import exception.ProductNotFoundException;
import exception.ProductsAlreadyExistsException;
import model.ProductoModel;
import service.ProductoService;


@RestController
@RequestMapping(path = "/api/product" )
public class ProductoController {

	@Autowired
	private ProductoService productService;
	
	@PostMapping(path = "/")
	public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel product) throws ProductsAlreadyExistsException{
		return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);
	}
	

	@PutMapping(path = "/{id}")
	public ResponseEntity<ProductoModel> update(@RequestBody ProductoModel product, @PathVariable Long id) throws ProductNotFoundException, Exception{
		return new ResponseEntity<>(this.productService.update(product, id), HttpStatus.OK);
	}
	

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductoModel> findById(@PathVariable Long id ) throws Exception{
		return new ResponseEntity<>(this.productService.findBy(id), HttpStatus.OK);
	}
	

	@GetMapping(path = "/")
	public ResponseEntity<List<ProductoModel>> findAll(){
		return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
	}
}
