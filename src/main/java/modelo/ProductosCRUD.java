/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.util.*;
import javax.persistence.*;
/**
 *
 * @author DAW2-PROFESOR
 */
public class ProductosCRUD {
    
        public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql,Productos.class);
        List<Productos> productosBD =  q.getResultList();

        return productosBD;
        
    }
    
            
        public static Productos getProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Productos p WHERE p.id=" + id;
        Query q = manager.createQuery(sql,Productos.class);
        Productos productosBD =  ( Productos )q.getSingleResult();

        return productosBD;

        }        
        
        public static void insertaProducto( Productos prod ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = 
                "INSERT INTO productos (id, nombre, imagen, categoria, precio) "
                + "VALUES (NULL, 'Tortas de Alcázar Especiales', '', 'complementos', '6.00');";
        manager.getTransaction().begin();
        Query q = manager.createNativeQuery(sql,Productos.class);
        manager.getTransaction().commit();
        int lineasAfectada=  q.executeUpdate();
  
        
        
    }
}
