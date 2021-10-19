package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {
	
	
	@Query("select d from Modalidad d where " + "( :e_sede is '' or d.sede = :e_sede ) and "
			+ "( :e_nom is '' or d.nombre like :e_nom )")
public abstract List<Modalidad> listaModalidadSedexNombre(
							 	@Param("e_sede") String sede, 
							 	@Param("e_nom") String nombre);
	
	
	@Query("select d from Modalidad d where " + "( :#{#fil.sede} is '' or d.sede = :#{#fil.sede} ) and "
			+ "( :#{#fil.nombre} is '' or d.nombre like :#{#fil.nombre} )  ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);

	
}
