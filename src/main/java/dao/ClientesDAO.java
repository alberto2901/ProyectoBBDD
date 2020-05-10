/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author Alberto
 */
public class ClientesDAO {
    
    private Connection conexion = null;

    public ClientesDAO() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: " + ex.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
    public Cliente read(Integer id) {
        Cliente cliente = null;
        PreparedStatement stmt = null;

        if (this.conexion == null) {
            return null;
        }

        try {
            String query = "SELECT * FROM clientes WHERE id = ?";
            stmt = conexion.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("codigo"),
                        rs.getString("empresa"),
                        rs.getString("contacto"),
                        rs.getString("cargo_contacto"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("region"),
                        rs.getString("cp"),
                        rs.getString("pais"),
                        rs.getString("telefono"),
                        rs.getString("fax")
                );
            }

            stmt.close();

        } catch (SQLException e) {

            System.err.println("Error en el Select: " + e.getMessage() + "\nQuery: " + stmt.toString());
        }

        return cliente;
    }
    
    public Boolean insert(Cliente cliente) {
        Boolean resultado = false;
        PreparedStatement stmt = null;
        Integer ultimoID = null;

        if (this.conexion == null || cliente == null) {
            return false;
        }

        try {
            /**
             * Inserto en la BBDD un empelado con un código mayor en uno que
             * todos los anteriores. Esta BD no tiene autoincremental en en el
             * campo codito de empleado
             */
            String sql = "INSERT INTO clientes "
                    + "(id, codigo, empresa, contacto, cargo_contacto, direccion, ciudad, region, cp, pais, telefono, fax) "
                    + "VALUES ((SELECT Max(id)+1 FROM `clientes` E), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getCodigo());
            stmt.setString(3, cliente.getEmpresa());
            stmt.setString(4, cliente.getContacto());
            stmt.setString(5, cliente.getCargo_contacto());
            stmt.setString(6, cliente.getDireccion());
            stmt.setString(7, cliente.getCiudad());
            stmt.setString(8, cliente.getRegion());
            stmt.setString(9, cliente.getCp());
            stmt.setString(10, cliente.getPais());
            stmt.setString(11, cliente.getTelefono());
            stmt.setString(12, cliente.getFax());

            if (stmt.executeUpdate() > 0) {
                resultado = true;

            }
        } catch (SQLException e) {
            System.err.println("Error en el Insert: " + e.getMessage()+ " SQL:" + stmt.toString());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;
    }
}
