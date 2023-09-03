package service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exception.ProductNotFoundException;
import exception.ProductsAlreadyExistsException;

import model.ProductoModel;
import repository.ProductoRepository;


@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productRepository;
	
	//agrega un prod
	public ProductoModel create(ProductoModel newProduct) throws ProductsAlreadyExistsException {
		//lo busca por su codigo para ver si existe en la base de datos
		Optional<ProductoModel> productOp= this.productRepository.findByCodigo(newProduct.getCodigo());
		
		if(productOp.isPresent()) {
			throw new ProductsAlreadyExistsException("El producto que intenta agregar ya existe en la bdd");
			
		}else {
			//guarda un prod nuevo
			return this.productRepository.save(newProduct);
		}
		
	}
	
	public ProductoModel update(ProductoModel newProduct, Long id) throws Exception,ProductNotFoundException {
		//corrobora el id
		if(id <=0) {
			throw new Exception ("El id brindado no es valido");
		}
		//crea un objeto model
		Optional<ProductoModel> productOp= this.productRepository.findById(newProduct.getId());
		
		//se fija si existe
		if(productOp.isEmpty()) {
			System.out.println("el prod que intenta modificar no existe ne la bdd" + newProduct);
			throw new ProductNotFoundException("El producto que intenta modificar no existe en la bdd");
			
		}else {
			//si existe lo actualiza
			ProductoModel productBd= productOp.get();
			
			productBd.setCodigo(newProduct.getCodigo());
			productBd.setPrecio(newProduct.getPrecio());
			productBd.setDescripcion(newProduct.getDescripcion());
			
			//usa el save para guardar los datos
			return this.productRepository.save(productBd);
		}
	}
	
	public ProductoModel findBy(Long id) throws Exception {
		//se fija si existe
		if(id <=0) {
			throw new Exception ("El id brindado no es valido");
		}
		Optional<ProductoModel> productOp= this.productRepository.findById(id);
		
		if(productOp.isEmpty()) {
			System.out.println("el prod que no existe en la bdd" + id);
			throw new ProductNotFoundException("El producto que intenta solicitar no existe en la bdd");
			
		}else {
			//trael prod con el id que se le envio
			return productOp.get();
		}
	}
	
	public List<ProductoModel> findAll() {
		
		//trae todos los productos
		return this.productRepository.findAll();
		
	}
	
	
}
