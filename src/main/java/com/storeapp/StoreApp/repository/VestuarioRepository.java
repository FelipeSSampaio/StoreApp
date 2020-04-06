package com.storeapp.StoreApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.storeapp.StoreApp.models.Vestuario;

public interface VestuarioRepository extends CrudRepository<Vestuario, String>{
	Vestuario findByCodigo(long codigo);
}
