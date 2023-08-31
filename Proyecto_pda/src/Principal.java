
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static List<Ciudadano> ciudadanos = new ArrayList<>();
    private static List<Delito> delitos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (opcion) {
                    case 1:
                        añadirCiudadano(scanner);
                        break;
                    case 2:
                        defuncionCiudadano(scanner);
                        break;
                    case 3:
                        añadirBusqueda(scanner);
                        break;
                    case 4:
                        retirarBusqueda(scanner);
                        break;
                    case 5:
                        añadirDelito(scanner);
                        break;
                    case 6:
                        verDelitos();
                        break;
                    case 7:
                        imputarDelito(scanner);
                        break;
                    case 8:
                        retirarDelito(scanner);
                        break;
                    case 9:
                        cobrarDeuda(scanner);
                        break;
                    case 10:
                        verDeudasCiudadano(scanner);
                        break;
                    case 11:
                        verDeudores();
                        break;
                    case 12:
                        imprimirCriminales();
                        break;
                    case 13:
                        imprimirCiudadanos();
                        break;
                    case 14:
                        imprimirDelitos();
                        break;
                    case 15:
                        cargarCiudadanos();
                        break;
                    case 16:
                        cargarDelitos();
                        break;
                    case 17:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Introduce un número del 1 al 17.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Debes ingresar un valor numérico.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        } while (opcion != 17);
    }

    private static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Añadir ciudadano");
        System.out.println("2. Defunción ciudadano");
        System.out.println("3. Añadir búsqueda");
        System.out.println("4. Retirar búsqueda");
        System.out.println("5. Añadir delito");
        System.out.println("6. Ver delitos");
        System.out.println("7. Imputar delito");
        System.out.println("8. Retirar delito");
        System.out.println("9. Cobrar deuda");
        System.out.println("10. Ver deudas ciudadano");
        System.out.println("11. Ver deudores");
        System.out.println("12. Imprimir criminales");
        System.out.println("13. Imprimir ciudadanos");
        System.out.println("14. Imprimir delitos");
        System.out.println("15. Cargar ciudadanos");
        System.out.println("16. Cargar delitos");
        System.out.println("17. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void añadirCiudadano(Scanner scanner) {
        System.out.println("----- Añadir Ciudadano -----");
        System.out.print("Fecha de nacimiento (Formato: dd/mm/aaaa): ");
        String fechaNacimiento = leerFecha(scanner);
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        validarLongitud(nombre, "Nombre", 1, 100);
        System.out.print("Empleo: ");
        String empleo = scanner.nextLine();
        validarLongitud(empleo, "Empleo", 1, 100);
        System.out.print("DNI: ");
        String dni = leerDNI(scanner);
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        validarLongitud(sexo, "Sexo", 1, 10);

       
        List<Delito> delitosImputados = new ArrayList<>();

        
        Ciudadano ciudadano = new Ciudadano(fechaNacimiento, nombre, empleo, dni, delitosImputados,
                true, false, altura, peso, sexo);
        ciudadanos.add(ciudadano);

        System.out.println("Ciudadano añadido correctamente.");
    }

    private static String leerFecha(Scanner scanner) {
        String fecha = scanner.nextLine();
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("El formato de fecha es inválido. Formato esperado: dd/mm/aaaa");
        }
        return fecha;
    }

    private static String leerDNI(Scanner scanner) {
        String dni = scanner.nextLine();
        if (!dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            throw new IllegalArgumentException("El formato de DNI es inválido. Formato esperado: 8 dígitos seguidos de una letra.");
        }
        return dni;
    }

    private static void validarLongitud(String valor, String nombreCampo, int longitudMin, int longitudMax) {
        if (valor.length() < longitudMin || valor.length() > longitudMax) {
            throw new IllegalArgumentException(nombreCampo + " debe tener entre " + longitudMin +
                    " y " + longitudMax + " caracteres.");
        }
    }

    private static void defuncionCiudadano(Scanner scanner) {
    	System.out.println("----- Registrar Defunción -----");
        System.out.print("DNI del ciudadano fallecido: ");
        String dni = scanner.nextLine();

        Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

        if (ciudadano == null) {
            System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
        } else {
            ciudadano.setVivo(false);
            System.out.println("La defunción del ciudadano se ha registrado.");
        }
    }

    private static Ciudadano buscarCiudadanoPorDNI(String dni) {
    	 for (Ciudadano ciudadano : ciudadanos) {
    	        if (ciudadano.getDni().equalsIgnoreCase(dni)) {
    	            return ciudadano;
    	        }
    	    }
    	    return null;
	}

	private static void añadirBusqueda(Scanner scanner) {
    	System.out.println("----- Añadir Búsqueda -----");
        System.out.print("DNI del ciudadano a buscar: ");
        String dni = scanner.nextLine();

        Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

        if (ciudadano == null) {
            System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
        } else if (ciudadano.isBuscado()) {
            System.out.println("El ciudadano ya está en búsqueda.");
        } else {
            ciudadano.setBuscado(true);
            System.out.println("El ciudadano ha sido establecido como buscado.");
        }
    }

    private static void retirarBusqueda(Scanner scanner) {
    	  System.out.println("----- Retirar Búsqueda -----");
    	    System.out.print("DNI del ciudadano a retirar de la búsqueda: ");
    	    String dni = scanner.nextLine();

    	    Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

    	    if (ciudadano == null) {
    	        System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
    	    } else if (!ciudadano.isBuscado()) {
    	        System.out.println("El ciudadano no está en búsqueda.");
    	    } else {
    	        ciudadano.setBuscado(false);
    	        System.out.println("Se ha retirado al ciudadano de la búsqueda.");
    	    }
    }

    private static void añadirDelito(Scanner scanner) {
    	 System.out.println("----- Añadir Delito -----");
    	    
    	    System.out.print("Código del delito: ");
    	    String codigo = scanner.nextLine();
    	    validarLongitud(codigo, "Código del delito", 1, 20);

    	    System.out.print("Nombre del delito: ");
    	    String nombre = scanner.nextLine();
    	    validarLongitud(nombre, "Nombre del delito", 1, 100);

    	    System.out.print("Descripción del delito: ");
    	    String descripcion = scanner.nextLine();
    	    validarLongitud(descripcion, "Descripción del delito", 1, 500);

    	    System.out.print("Costo del delito: ");
    	    double costo = scanner.nextDouble();

    	    System.out.print("Tiempo en prisión (en meses): ");
    	    int tiempoPrision = scanner.nextInt();
    	    scanner.nextLine(); // Consumir la nueva línea después de leer el entero

    	    System.out.print("Gravedad del delito (Leve, Medio, Grave): ");
    	    String gravedad = scanner.nextLine();

    	    // Crear el objeto Delito y añadirlo a la colección
    	    Delito delito = new Delito(codigo, false, nombre, descripcion, costo, tiempoPrision, gravedad);
    	    delitos.add(delito);

    	    System.out.println("Delito añadido correctamente.");
    	    }

    private static void verDelitos() {
    	System.out.println("----- Lista de Delitos -----");
        
        if (delitos.isEmpty()) {
            System.out.println("No hay delitos registrados.");
        } else {
            System.out.printf("%-15s | %-30s | %-15s | %-15s%n", "Código", "Nombre", "Costo", "Gravedad");
            System.out.println("-----------------------------------------------");
            for (Delito delito : delitos) {
                System.out.printf("%-15s | %-30s | %-15.2f | %-15s%n",
                        delito.getCodigoDelito(), delito.getNombre(), delito.getCosto(), delito.getGravedad());
            }
        }
        }

    private static void imputarDelito(Scanner scanner) {
    	System.out.println("----- Imputar Delito -----");
        System.out.print("DNI del ciudadano: ");
        String dni = scanner.nextLine();

        Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

        if (ciudadano == null) {
            System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
        } else {
            System.out.print("Código del delito: ");
            String codigoDelito = scanner.nextLine();

            Delito delito = buscarDelitoPorCodigo(codigoDelito);

            if (delito == null) {
                System.out.println("No se encontró un delito con el código proporcionado.");
            } else {
                // Crear una copia del delito para evitar modificar el delito original en caso de modificaciones futuras
                Delito delitoImputado = new Delito(delito.getCodigoDelito(), false, delito.getNombre(),
                        delito.getDescripcion(), delito.getCosto(), delito.getTiempoPrision(), delito.getGravedad());

                ciudadano.getDelitosImputados().add(delitoImputado);
                System.out.println("Delito imputado al ciudadano.");
            }
        }
        }

    private static Delito buscarDelitoPorCodigo(String codigoDelito) {

    	for (Delito delito : delitos) {
            if (delito.getCodigoDelito().equalsIgnoreCase(codigoDelito)) {
                return delito;
            }
        }
        return null;
	}

	private static void retirarDelito(Scanner scanner) {
    	 System.out.println("----- Retirar Delito Imputado -----");
    	    System.out.print("DNI del ciudadano: ");
    	    String dni = scanner.nextLine();

    	    Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

    	    if (ciudadano == null) {
    	        System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
    	    } else if (ciudadano.getDelitosImputados().isEmpty()) {
    	        System.out.println("El ciudadano no tiene delitos imputados.");
    	    } else {
    	        System.out.print("Código del delito a retirar: ");
    	        String codigoDelito = scanner.nextLine();

    	        Delito delito = buscarDelitoPorCodigo(codigoDelito);

    	        if (delito == null) {
    	            System.out.println("No se encontró un delito con el código proporcionado.");
    	        } else {
    	            boolean retirado = ciudadano.getDelitosImputados().removeIf(d -> d.getCodigoDelito().equals(codigoDelito));

    	            if (retirado) {
    	                System.out.println("Delito retirado del ciudadano.");
    	            } else {
    	                System.out.println("El ciudadano no tenía ese delito imputado.");
    	            }
    	        }
    	    }
    }

    private static void cobrarDeuda(Scanner scanner) {
    	  System.out.println("----- Cobrar Deuda de Delito Imputado -----");
    	    System.out.print("DNI del ciudadano: ");
    	    String dni = scanner.nextLine();

    	    Ciudadano ciudadano = buscarCiudadanoPorDNI(dni);

    	    if (ciudadano == null) {
    	        System.out.println("No se encontró un ciudadano con el DNI proporcionado.");
    	    } else if (ciudadano.getDelitosImputados().isEmpty()) {
    	        System.out.println("El ciudadano no tiene delitos imputados.");
    	    } else {
    	        System.out.print("Código del delito a cobrar: ");
    	        String codigoDelito = scanner.nextLine();

    	        Delito delito = buscarDelitoPorCodigo(codigoDelito);

    	        if (delito == null) {
    	            System.out.println("No se encontró un delito con el código proporcionado.");
    	        } else {
    	            boolean cobrado = ciudadano.getDelitosImputados().removeIf(d -> {
    	                if (d.getCodigoDelito().equals(codigoDelito)) {
    	                    d.setPagado(true);
    	                    return true;
    	                }
    	                return false;
    	            });

    	            if (cobrado) {
    	                System.out.println("Deuda cobrada del ciudadano.");
    	            } else {
    	                System.out.println("El ciudadano no tenía esa deuda pendiente.");
    	            }
    	        }
    	    }
    }

    private static void verDeudasCiudadano(Scanner scanner) {
    	 System.out.println("----- Ver Deudas de Ciudadano -----");
    	    System.out.print("Introduce el nombre o DNI del ciudadano: ");
    	    String consulta = scanner.nextLine();

    	    boolean encontrado = false;

    	    for (Ciudadano ciudadano : ciudadanos) {
    	        if (ciudadano.getNombre().equalsIgnoreCase(consulta) || ciudadano.getDni().equalsIgnoreCase(consulta)) {
    	            System.out.println("Deudas del ciudadano " + ciudadano.getNombre() + ":");
    	            
    	            List<Delito> delitosDeudores = ciudadano.getDelitosImputados().stream()
    	                .filter(delito -> !delito.isPagado())
    	                .collect(Collectors.toList());
    	            
    	            if (delitosDeudores.isEmpty()) {
    	                System.out.println("El ciudadano no tiene deudas pendientes.");
    	            } else {
    	                for (Delito delito : delitosDeudores) {
    	                    System.out.println("Código del delito: " + delito.getCodigoDelito());
    	                    System.out.println("Nombre del delito: " + delito.getNombre());
    	                    System.out.println("Costo del delito: " + delito.getCosto());
    	                    System.out.println("----------------------------------");
    	                }
    	            }
    	            
    	            encontrado = true;
    	            break;
    	        }
    	    }

    	    if (!encontrado) {
    	        System.out.println("No se encontró un ciudadano con el nombre o DNI proporcionado.");
    	    }
    }

    private static void verDeudores() {
    	 System.out.println("----- Lista de Deudores -----");

    	    boolean encontrados = false;

    	    for (Ciudadano ciudadano : ciudadanos) {
    	        double deudaTotal = ciudadano.getDelitosImputados().stream()
    	                .filter(delito -> !delito.isPagado())
    	                .mapToDouble(Delito::getCosto)
    	                .sum();

    	        if (deudaTotal > 0) {
    	            System.out.println("Nombre: " + ciudadano.getNombre());
    	            System.out.println("DNI: " + ciudadano.getDni());
    	            System.out.println("Deuda total: " + deudaTotal);
    	            System.out.println("----------------------------------");
    	            encontrados = true;
    	        }
    	    }

    	    if (!encontrados) {
    	        System.out.println("No hay ciudadanos con deudas pendientes.");
    	    }
    }

    private static void imprimirCriminales() {
    	 System.out.println("----- Imprimir Criminales -----");

    	    List<Ciudadano> criminales = new ArrayList<>(ciudadanos);
    	    criminales.removeIf(ciudadano -> ciudadano.getDelitosImputados().isEmpty());

    	    if (criminales.isEmpty()) {
    	        System.out.println("No hay criminales registrados.");
    	        return;
    	    }

    	    criminales.sort((c1, c2) -> {
    	        double gravedadC1 = c1.getDelitosImputados().stream()
    	                .mapToDouble(delito -> getGravedadValue(delito.getGravedad()))
    	                .sum();
    	        double gravedadC2 = c2.getDelitosImputados().stream()
    	                .mapToDouble(delito -> getGravedadValue(delito.getGravedad()))
    	                .sum();

    	        return Double.compare(gravedadC2, gravedadC1);
    	    });

    	    try (PrintWriter writer = new PrintWriter(new FileWriter("criminales.txt"))) {
    	        for (Ciudadano criminal : criminales) {
    	            writer.println("Nombre: " + criminal.getNombre());
    	            writer.println("DNI: " + criminal.getDni());
    	            writer.println("Peligrosidad: " + calcularPeligrosidad(criminal));
    	            writer.println("----------------------------------");
    	        }
    	        System.out.println("Información de criminales impresa en el archivo 'criminales.txt'");
    	    } catch (IOException e) {
    	        System.out.println("Error al escribir en el archivo.");
    	    }
    	}

    	private static double getGravedadValue(String gravedad) {
    	    switch (gravedad.toLowerCase()) {
    	        case "leve":
    	            return 1;
    	        case "medio":
    	            return 2;
    	        case "grave":
    	            return 3;
    	        default:
    	            return 0;
    	    }
    	}

    	private static double calcularPeligrosidad(Ciudadano ciudadano) {
    	    return ciudadano.getDelitosImputados().stream()
    	            .mapToDouble(delito -> getGravedadValue(delito.getGravedad()))
    	            .sum();
    }

    private static void imprimirCiudadanos() {
    	 System.out.println("----- Imprimir Ciudadanos -----");

    	    if (ciudadanos.isEmpty()) {
    	        System.out.println("No hay ciudadanos registrados.");
    	        return;
    	    }

    	    try (PrintWriter writer = new PrintWriter(new FileWriter("ciudadanos.txt"))) {
    	        for (Ciudadano ciudadano : ciudadanos) {
    	            writer.println("Nombre: " + ciudadano.getNombre());
    	            writer.println("DNI: " + ciudadano.getDni());
    	            writer.println("Fecha de Nacimiento: " + ciudadano.getFechaNacimiento());
    	            writer.println("Empleo: " + ciudadano.getEmpleo());
    	            writer.println("Altura: " + ciudadano.getAltura());
    	            writer.println("Peso: " + ciudadano.getPeso());
    	            writer.println("Sexo: " + ciudadano.getSexo());
    	            writer.println("Vivo: " + (ciudadano.isVivo() ? "Sí" : "No"));
    	            writer.println("Buscado: " + (ciudadano.isBuscado() ? "Sí" : "No"));
    	            writer.println("Delitos imputados:");
    	            
    	            if (ciudadano.getDelitosImputados().isEmpty()) {
    	                writer.println("No tiene delitos imputados.");
    	            } else {
    	                for (Delito delito : ciudadano.getDelitosImputados()) {
    	                    writer.println("- Código del delito: " + delito.getCodigoDelito());
    	                    writer.println("  Nombre del delito: " + delito.getNombre());
    	                    writer.println("  Gravedad: " + delito.getGravedad());
    	                }
    	            }

    	            writer.println("----------------------------------");
    	        }
    	        System.out.println("Información de ciudadanos impresa en el archivo 'ciudadanos.txt'");
    	    } catch (IOException e) {
    	        System.out.println("Error al escribir en el archivo.");
    	    }
    	    
    }

    private static void imprimirDelitos() {
    	 System.out.println("----- Imprimir Delitos -----");

    	    if (delitos.isEmpty()) {
    	        System.out.println("No hay delitos registrados.");
    	        return;
    	    }

    	    try (PrintWriter writer = new PrintWriter(new FileWriter("delitos.txt"))) {
    	        for (Delito delito : delitos) {
    	            writer.println("Código del delito: " + delito.getCodigoDelito());
    	            writer.println("Nombre del delito: " + delito.getNombre());
    	            writer.println("Descripción del delito: " + delito.getDescripcion());
    	            writer.println("Costo del delito: " + delito.getCosto());
    	            writer.println("Tiempo en prisión: " + delito.getTiempoPrision() + " meses");
    	            writer.println("Gravedad: " + delito.getGravedad());
    	            writer.println("----------------------------------");
    	        }
    	        System.out.println("Información de delitos impresa en el archivo 'delitos.txt'");
    	    } catch (IOException e) {
    	        System.out.println("Error al escribir en el archivo.");
    	    }
    }

    private static void cargarCiudadanos() {
    	 System.out.println("----- Cargar Ciudadanos -----");

    	    try (Scanner fileScanner = new Scanner(new File("ciudadanos.txt"))) {
    	        while (fileScanner.hasNextLine()) {
    	            String nombre = fileScanner.nextLine().replace("Nombre: ", "");
    	            String dni = fileScanner.nextLine().replace("DNI: ", "");
    	            String fechaNacimiento = fileScanner.nextLine().replace("Fecha de Nacimiento: ", "");
    	            String empleo = fileScanner.nextLine().replace("Empleo: ", "");
    	            double altura = Double.parseDouble(fileScanner.nextLine().replace("Altura: ", ""));
    	            double peso = Double.parseDouble(fileScanner.nextLine().replace("Peso: ", ""));
    	            String sexo = fileScanner.nextLine().replace("Sexo: ", "");
    	            boolean vivo = fileScanner.nextLine().replace("Vivo: ", "").equals("Sí");
    	            boolean buscado = fileScanner.nextLine().replace("Buscado: ", "").equals("Sí");
    	            
    	            Ciudadano ciudadano = new Ciudadano(fechaNacimiento, nombre, empleo, dni,delitos, vivo, buscado, altura, peso, sexo); 
    	          ciudadano.setBuscado(buscado);
    	            
    	            String delitosImputadosLine = fileScanner.nextLine().replace("Delitos imputados:", "").trim();
    	            
    	            if (!delitosImputadosLine.equals("No tiene delitos imputados.")) {
    	                while (fileScanner.hasNextLine()) {
    	                    String codigoDelito = fileScanner.nextLine().replace("- Código del delito: ", "");
    	                    String nombreDelito = fileScanner.nextLine().replace("  Nombre del delito: ", "");
    	                    String gravedadDelito = fileScanner.nextLine().replace("  Gravedad: ", "");
    	                    Delito delito = new Delito(codigoDelito, buscado, nombreDelito, "", 0, 0, gravedadDelito);
    	                   ciudadano.getDelitosImputados().add(delito);
    	                }
    	            }

    	            ciudadanos.add(ciudadano);
    	            fileScanner.nextLine(); // Leer línea en blanco entre ciudadanos
    	        }
    	        System.out.println("Ciudadanos cargados correctamente.");
    	    } catch (FileNotFoundException e) {
    	        System.out.println("El archivo 'ciudadanos.txt' no se encuentra.");
    	    } catch (Exception e) {
    	        System.out.println("Error al cargar los ciudadanos.");
    	    }
    }

    private static void cargarDelitos() {
    	System.out.println("----- Cargar Delitos -----");

        try (Scanner fileScanner = new Scanner(new File("delitos.txt"))) {
            while (fileScanner.hasNextLine()) {
                String codigoDelito = fileScanner.nextLine().replace("Código del delito: ", "");
                boolean pagado = Boolean.parseBoolean(fileScanner.nextLine().replace("delito pagado: ", ""));
                String nombre = fileScanner.nextLine().replace("Nombre del delito: ", "");
                String descripcion = fileScanner.nextLine().replace("Descripción del delito: ", "");
                double costo = Double.parseDouble(fileScanner.nextLine().replace("Costo del delito: ", ""));
                int tiempoPrision = Integer.parseInt(fileScanner.nextLine().replace("Tiempo en prisión: ", "").split(" ")[0]);
                String gravedad = fileScanner.nextLine().replace("Gravedad: ", "");
                
                Delito delito = new Delito(codigoDelito, pagado, nombre,descripcion, costo,
        			tiempoPrision, gravedad);
                delitos.add(delito);
                fileScanner.nextLine(); // Leer línea en blanco entre delitos
            }
            System.out.println("Delitos cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo 'delitos.txt' no se encuentra.");
        } catch (Exception e) {
            System.out.println("Error al cargar los delitos.");
        }
    }
}
