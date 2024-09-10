import java.util.ArrayList;
import java.util.List;

public class CombinarListas {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java CombinarListas <lista1> <lista2>");
            System.out.println("Ejemplo: java CombinarListas \"1,3,5\" \"2,4,6\"");
            return;
        }

        List<Integer> lista1 = parsearLista(args[0]);
        List<Integer> lista2 = parsearLista(args[1]);

        List<Integer> listaCombinada = combinar(lista1, lista2);

        System.out.println("Lista Combinada: " + listaCombinada);
    }

    private static List<Integer> parsearLista(String str) {
        List<Integer> lista = new ArrayList<>();
        String[] elementos = str.split(",");
        for (String elemento : elementos) {
            lista.add(Integer.parseInt(elemento.trim()));
        }
        return lista;
    }

    public static List<Integer> combinar(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> listaCombinada = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                listaCombinada.add(lista1.get(i));
                i++;
            } else {
                listaCombinada.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            listaCombinada.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            listaCombinada.add(lista2.get(j));
            j++;
        }

        return listaCombinada;
    }
}
