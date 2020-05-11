/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import dao.ClientesDAO;
import entidades.Cliente;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */


public class menu {
   
    static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    static ClientesDAO clientesdao = new ClientesDAO();
    
    
public static void menu(){
    Integer opcion = null;

        if (ClientesDAO.getConexion() == null) {
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
                        System.out.println("Hasta luego, vuelva pronto!");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("\nBÚSQUEDA");
                        System.out.println("--------");
                        buscarCliente();
                        break;
                    case 2:
                        System.out.println("\nINSERCIÓN");
                        System.out.println("---------");
                        introducirCliente();
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

    public static Cliente existeCliente() {
        Cliente cliente = null;

        System.out.print("Indique el ID del empleado que desea buscar: ");
        cliente = ClientesDAO.read(Integer.parseInt(sc.nextLine()));

        return cliente;
    }

    public static void buscarCliente() {
        Cliente cliente = existeCliente();

        if (cliente != null) {
            System.out.println(cliente.toString());
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
        }
    }

    public static void introducirCliente() {
        Cliente cliente = new Cliente();

        System.out.printf("Indique el codigo del cliente: ");
        cliente.setCodigo(sc.next());

        System.out.printf("Indique la empresa cliente: ");
        cliente.setEmpresa(sc.next());

        System.out.printf("Indique el contacto del cliente: ");
        cliente.setContacto(sc.next());

        System.out.printf("Indique el cargo de contacto del cliente: ");
        cliente.setCargo_contacto(sc.next());

        System.out.printf("Indique la direccion del cliente: ");
        cliente.setDireccion(sc.next());

        System.out.printf("Indique la ciudad del cliente: ");
        cliente.setCiudad(sc.next());
        
        System.out.printf("Indique la region del cliente: ");
        cliente.setRegion(sc.next());
        
        System.out.printf("Indique el codigo postal del cliente: ");
        cliente.setCp(sc.next());
        
        System.out.printf("Indique el pais del cliente: ");
        cliente.setPais(sc.next());

        System.out.printf("Indique el Telefono del cliente: ");
        cliente.setTelefono(sc.next());
        
        System.out.printf("Indique el FAX del cliente: ");
        cliente.setFax(sc.next());


        if (clientesdao.insert(cliente)) {
            System.out.println("El cliente '" + cliente.getId() + " " + cliente.getCodigo() + " " + cliente.getEmpresa() + 
                    " " + cliente.getContacto() + " " + cliente.getCargo_contacto() + " " + cliente.getDireccion() + 
                    " " + cliente.getCiudad() + " " + cliente.getRegion() + " " + cliente.getCp() + " " + cliente.getPais() + 
                    " " + cliente.getTelefono() + " " + cliente.getFax() + "' ha sido añadido satisfactoriamente.");
        } else {
            System.err.println("El cliente que intenta introducir no es válido.\n");
        }
    }

    public static void actualizarEmpleado() {
        Cliente cliente = existeCliente();

        if (cliente == null) {
            System.err.println("El empleado no existe o no se puede leer.");
            return;
        }

        while (true) {
            try {
                System.out.println("\n" + cliente);

                Integer opcion;

                System.out.println("\nELIJA ALGUNA DE LAS OPCIONES QUE SE MUESTRAN A CONTINUACIÓN\n");
                System.out.println("  1. Codigo.");
                System.out.println("  2. Empresa.");
                System.out.println("  3. Contacto.");
                System.out.println("  4. Cargo de Contacto.");
                System.out.println("  5. Direccion.");
                System.out.println("  6. Ciudad.");
                System.out.println("  7. Region.");
                System.out.println("  8. Codigo Postal.");
                System.out.println("  9. Pais.");
                System.out.println("  10. Telefono.");
                System.out.println("  11. Fax.");
                System.out.print("\nSu elección [introduzca 0 para retroceder]: ");
                opcion = Integer.parseInt(sc.nextLine());

                if (opcion > 0 && opcion < 11) {
                    System.out.print("\nIntroduzca la modificación que desea realizar: ");
                }

                switch (opcion) {
                    case 0:
                        return;
                    case 1:
                        cliente.setCodigo(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 2:
                        cliente.setEmpresa(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 3:
                        cliente.setContacto(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 4:
                        cliente.setCargo_contacto(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 5:
                        cliente.setDireccion(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 6:
                        cliente.setCiudad(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 7:
                        cliente.setRegion(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 8:
                        cliente.setCp(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 9:
                        cliente.setPais(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 10:
                        cliente.setTelefono(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    case 11:
                        cliente.setFax(sc.nextLine());
                        clientesdao.update(cliente);
                        break;
                    default:
                        System.out.println("\nIntroduzca alguna de las opciones válidas.\n");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("\nError: " + nfe.getMessage() + "\n");
            }
        }
    }

    public static void borrarEmpleado() {
        Empleado empleado = existeEmpleado();
        String resp = null;

        if (empleado != null) {
                System.out.println("\n¿Está seguro que desea eliminar al siguiente usuario?"
                        + "\n  " + empleado);
                System.out.print("Su respuesta [Y/N]: ");
                resp = sc.nextLine();
                
                if (resp.equalsIgnoreCase("y")) {
                    empleados.delete(empleado.getCodigoEmpleado());
                    System.out.println("Entrada eliminada.");
                } else {
                    System.out.println("Entrada no eliminada.");
                }
        } else {
            System.err.println("El empleado no existe o no se puede leer.");
        }
    }*/
}


        
