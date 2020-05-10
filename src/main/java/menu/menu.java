/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import dao.ClientesDAO;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */


public class menu {
   

    static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    static ClientesDAO empleados = new ClientesDAO();
    
        Integer opcion = null;

        if (empleados.getConexion() == null) {
            System.err.println("Programa terminado. Error en la conexión.");
            System.exit(1);
        }

        System.out.println("\t\tBIENVENIDO");
        System.out.println("\t\t-----------");
        while (true) {
            try {
                System.out.println("ELIJA ALGUNA DE LAS OPCIONES QUE SE MUESTRAN A CONTINUACIÓN\n");
                System.out.println("  1. Buscar datos de empleados.");
                System.out.println("  2. Insertar datos de un empleado.");
                System.out.println("  3. Actualizar datos de un empleado.");
                System.out.println("  4. Eliminar datos de un empleado.\n");
                System.out.print("Su elección [introduzca 0 para salir]: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 0:
                        System.out.println("\nHasta pronto.\n");
                        System.out.println("\t    -------------");
                        System.out.println("\t\tFIN\n");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("\nBÚSQUEDA");
                        System.out.println("--------");
                        //buscarEmpleado();
                        break;
                    case 2:
                        System.out.println("\nINSERCIÓN");
                        System.out.println("---------");
                        //introducirEmpleado();
                        break;
                    case 3:
                        System.out.println("\nACTUALIZAR");
                        System.out.println("----------");
                        //actualizarEmpleado();
                        break;
                    case 4:
                        System.out.println("\nBORRADO");
                        System.out.println("-------");
                        //borrarEmpleado();
                        break;
                    default:
                        System.out.println("\nIntroduzca alguna de las opciones válidas.");
                }
                System.out.println();
            } catch (NumberFormatException nfe) {
                System.err.println("\nError: Entrada no válida." + nfe.getMessage() + "\n");
            }
        }
    }

    

