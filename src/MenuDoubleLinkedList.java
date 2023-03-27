import java.util.Scanner;

public class MenuDoubleLinkedList {
    public void exectMenu() {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList LinkedList = new DoubleLinkedList();

        int opcion;
        do {
            System.out.println("\n--- Menú Lista de Alumnos ---");
            System.out.println("1. Agregar alumno a la lista");
            System.out.println("2. Agregar alumno al inicio de la lista");
            System.out.println("3. Eliminar alumno por posición en la lista");
            System.out.println("4. Eliminar alumno por por nombre");
            System.out.println("5. Agregar un alumno en una posición específica");
            System.out.println("6. Mostrar tamaño de la lista de alumnos");
            System.out.println("7. Reemplazar un alumno de la lista");
            System.out.println("8. Imprimir lista de alumnos");
            System.out.println("9. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Agregar alumno a la lista ---");
                    System.out.print("Ingrese un valor tipo String: ");
                    String valorFinal = scanner.nextLine();
                    LinkedList.pushLast(valorFinal.trim());
                    System.out.println("Valor agregado al final.");
                    break;
                case 2:
                    System.out.println("\n--- Agregar alumno al inicio de la lista ---");
                    System.out.print("Ingrese un valor tipo String: ");
                    String valorInicio = scanner.nextLine();
                    LinkedList.pushFirst(valorInicio.trim());
                    System.out.println("Valor agregado al inicio.");
                    break;
                case 3:
                    System.out.println("\n--- Eliminar alumno por posición ---");
                    System.out.print("Ingrese la posicion a eliminar: ");
                    String valorEliminar = scanner.nextLine();
                    LinkedList.deleteElementByIndex(Integer.parseInt(valorEliminar));
                    break;
                case 4:
                    System.out.println("\n--- Eliminar alumno por por valor ---");
                    System.out.print("Ingrese la posicion a eliminar: ");
                    String valorSEliminar = scanner.nextLine();
                    LinkedList.deleteElementByValue(valorSEliminar);
                    break;
                case 5:
                    System.out.println("\n--- Agregar un alumno en una posición específica ---");
                    System.out.print("Ingrese la posicion en la que se va a agregar: ");
                    String indexIngresar = scanner.nextLine();
                    System.out.print("Ingrese el valor para la posicion: ");
                    String valorIngresar = scanner.nextLine();
                    LinkedList.addElement(Integer.parseInt(indexIngresar), valorIngresar);
                    break;
                case 6:
                    System.out.println("\n--- Mostrar tamaño de la lista de alumnos ---");
                    System.out.println("el tamaño de la lista es: " + LinkedList.getSize());
                    break;
                case 7:
                    System.out.println("\n--- Reemplazar un alumno de la lista ---");
                    System.out.print("Ingrese la posicion en la que se va a reemplazar: ");
                    String indexReplace = scanner.nextLine();
                    System.out.print("Ingrese el valor para la posicion: ");
                    String valorReplace = scanner.nextLine();
                    LinkedList.replaceValueInIndex(Integer.parseInt(indexReplace), valorReplace);;
                    break;
                case 8:
                    System.out.println("\n--- Imprimir lista de alumnos ---");
                    LinkedList.displayList();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 9);
        scanner.close();
    }
}