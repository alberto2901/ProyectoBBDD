/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ClientesDAO;
import entidades.Cliente;
import java.awt.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import menu.menu;

/**
 *
 * @author Alberto
 */
public class main {
   static ClientesDAO clientes = new ClientesDAO();
   static Cliente cliente2 = new Cliente(99,"JJPO","Real Rondo","Seryu Gomes","Gerente de Mon","Calle El Peligro","Madrid","ESP","566689","España","56668798462","22553356");
   static menu menu = new menu();
   
    public static void main(String[] args) {
        
        if (clientes.getConexion() == null) {
            System.err.println("Programa terminado. Error en la conexión.");
            System.exit(1);
        } else{
            System.out.println("Conexion realizada correctamente\n");
        }
        menu.menu();
        
        /*Cliente cliente1 = clientes.read(1);
        System.out.println(cliente1);
        
        clientes.insert(cliente2);*/
    }
}
