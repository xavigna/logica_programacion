import java.util.ArrayList;

public class Examen2parcial_zaldumbide_xavier {

    public static void main(String[] args) {
        int total = 0;
        String[] productos = {"chocolate", "paleta", "gomita", "galleta"};
        String[] precios = {"18", "12", "25", "15"};
        ArrayList<String> personas = new ArrayList<String>();
        ArrayList<Integer> pv = new ArrayList<Integer>();
        ArrayList<Integer> ib = new ArrayList<Integer>();
        for (int i = 0; i < productos.length; i++) {
            pv.add(0);
            ib.add(0);
        }

        int clientes = 0;
        do {
            String nombre = IO.readln("Ingrese el nombre de la persona: ");
            personas.add(nombre);
            for (int i = 0; i < productos.length; i++) {
                IO.println((i + 1) + ". " + productos[i] + " - $" + precios[i]);
            }
            do {
            int opcion = Integer.parseInt(IO.readln("Ingrese el número del producto que desea comprar: ")) -1;
            int cantidad = Integer.parseInt(IO.readln("Ingrese la cantidad que desea comprar: "));
            switch (opcion) {
                case 0:
                    total += Integer.parseInt(precios[opcion]) * cantidad;
                    pv.set(opcion, cantidad + pv.get(opcion));
                    ib.set(opcion, Integer.parseInt(precios[opcion]) * cantidad + ib.get(opcion));
                    break;
                    case 1:
                    total += Integer.parseInt(precios[opcion]) * cantidad;
                    pv.set(opcion, cantidad + pv.get(opcion));
                    ib.set(opcion, Integer.parseInt(precios[opcion]) * cantidad + ib.get(opcion));
                    break;
                    case 2:
                        total += Integer.parseInt(precios[opcion]) * cantidad;
                        pv.set(opcion, cantidad + pv.get(opcion));
                        ib.set(opcion, Integer.parseInt(precios[opcion]) * cantidad + ib.get(opcion));
                        break;
                    case 3:
                        total += Integer.parseInt(precios[opcion]) * cantidad;
                        pv.set(opcion, cantidad + pv.get(opcion));
                        ib.set(opcion, Integer.parseInt(precios[opcion]) * cantidad + ib.get(opcion));
                        break;
                }
            }while (IO.readln("¿Desea comprar otro producto? (s/n): ").equalsIgnoreCase("s"));

            clientes++;
        }while (IO.readln("¿Desea atender a otra persona? (s/n): ").equalsIgnoreCase("s"));
        IO.println("Total de clientes atendidos: " + clientes);
        IO.println("Total de dinero recaudado: $" + total);
        for (int i = 0; i < personas.size(); i++) {
            IO.println("Cliente: " + personas.get(i));
        }
        for (int i = 0; i < productos.length; i++) {
            IO.println("Producto: " + productos[i] + " - Cantidad vendida: " + pv.get(i) + " - Ingresos: $" + ib.get(i));
        }
        IO.print("promedio de venta: $" + (total / clientes));
    }

}
