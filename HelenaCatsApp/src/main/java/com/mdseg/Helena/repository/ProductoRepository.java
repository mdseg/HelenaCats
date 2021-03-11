
package com.mdseg.Helena.repository;

import com.mdseg.Helena.entity.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
}
