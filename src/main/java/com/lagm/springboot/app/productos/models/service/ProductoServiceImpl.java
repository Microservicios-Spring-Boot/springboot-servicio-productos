package com.lagm.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagm.springboot.app.productos.models.dao.ProductoDao;
import com.lagm.springboot.app.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		// return productoDao.findById(id).get(); // Si no existe el objeto, lanzará una excepción
		return productoDao.findById(id).orElse(null);
	}

}
