

public class vta_vivero {
     public static void main(String[] args) {

     double[][] ventas = new double[5][6];
     String[] dias = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
     double[] precios =  {45.5, 35.5, 60.0, 80.0, 30.0};
     String[] productos = {"cactus", "suculentas", "macetas", "tierra", "fertilizantes"};

          for (int i = 0; i < ventas.length; i++) {
               for (int j = 0; j < ventas[i].length; j++) {
               ventas[i][j] = (Double.parseDouble(IO.readln("Ingrese la cantidad vendida de " + productos[i] + " el día " + dias[j] + ": "))) * precios[i]; 
                    
               }
          }

               System.out.print("\t");
          for (int a = 0; a < dias.length; a++) {
               
               System.out.print(dias[a] + "\t");
               if (a == dias.length - 1) {
                  System.out.println();
               }
          }

          for (int i = 0; i < ventas.length; i++) {
                    System.out.print(productos[i] + ":");
               for (int j = 0; j < ventas[i].length; j++) {
                    System.out.print(ventas[i][j]);
                    if (j < ventas[i].length - 1) {
                         System.out.print("\t");
               
                    }else {
                         System.out.println();
                    }
               
               }
          }

     }

     
}
