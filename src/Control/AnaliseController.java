/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Model.Sorteio;  
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author denis
 */
public class AnaliseController {
    public List<Sorteio> filtrarProximidade(List<Sorteio> listaCompleta) {
        List<Sorteio> filtrados = new ArrayList<>();
        for (Sorteio s : listaCompleta) {
            int[] n = {s.getN1(), s.getN2(), s.getN3(), s.getN4(), s.getN5(), s.getN6()};
            
            boolean temProximo = false;
            for (int i = 0; i < 5; i++) {
                // Se a diferença entre dois números for 1 ou 2 (ex: 41 e 42 ou 41 e 43)
                if (Math.abs(n[i+1] - n[i]) <= 2) { 
                    temProximo = true;
                    break;
                }
            }
            if (temProximo) filtrados.add(s);
        }
        return filtrados;
    }
    
    public Map<Integer, Integer> calcularFrequencia(List<Sorteio> listaCompleta) {
    Map<Integer, Integer> mapaFrequencia = new HashMap<>();
    
    // Inicializa o mapa com os números de 1 a 60 valendo zero
    for (int i = 1; i <= 60; i++) {
        mapaFrequencia.put(i, 0);
    }

    // Varre cada sorteio e aumenta a contagem de cada dezena encontrada
    for (Sorteio s : listaCompleta) {
        int[] dezenas = {s.getN1(), s.getN2(), s.getN3(), s.getN4(), s.getN5(), s.getN6()};
        for (int num : dezenas) {
            if (num >= 1 && num <= 60) {
                mapaFrequencia.put(num, mapaFrequencia.get(num) + 1);
            }
        }
    }
    return mapaFrequencia;
}
}

