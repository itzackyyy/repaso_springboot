package com.zacky.pcfactory.Cliente.Repository;


import com.zacky.pcfactory.Cliente.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteModel, Long> {
}
