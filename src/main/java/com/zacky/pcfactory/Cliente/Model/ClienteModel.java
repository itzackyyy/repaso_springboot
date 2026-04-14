package com.zacky.pcfactory.Cliente.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.boot.registry.selector.StrategyRegistration;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Cliente")
public class ClienteModel {
    /**
     * no hace falta ponerles name = "id_cliente" por ejemplo, pues
     * ya se traduce de esa forma por defecto hacia la base de datos
     * **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Jakarta
    private Long idCliente;

    @Column(nullable = false, length = 50)
    private String nombreCliente;

    @Column(nullable = false, name = "primer_apellido", length = 50)
    private String priApeCliente;

    @Column(name="segundo_apellido", length = 50)
    private String secApeCliente; //nullable por defecto



}
