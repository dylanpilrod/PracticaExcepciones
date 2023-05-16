/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaexcepciones;
import java.util.ArrayList;
/**
 *
 * @author dylanpilrod
 */
public class Parking {
    private String parking;
    private ArrayList<String> matriculas;

    public Parking(String parking, int numeroPlazas) {
        this.parking = parking;
        this.matriculas = new ArrayList<>(numeroPlazas);
        for (int i = 0; i < numeroPlazas; i++) {
            this.matriculas.add(null);
        }
    }

    public String getParking() {
        return parking;
    }

    public void entrada(String matricula, int plaza) throws Exception {
        if (matricula == null || matricula.length() < 4) {
            throw new Exception("La matricula es incorrecta");
        }
        if (matriculas.get(plaza) != null) {
            throw new Exception("La plaza esta ocupada");
        }
        if (matriculas.contains(matricula)) {
            throw new Exception("La matrícula esta repetida");
        }
        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws Exception {
        if (!matriculas.contains(matricula)) {
            throw new Exception("La matricula introducida no existe");
        }
        int plazaLibre = matriculas.indexOf(matricula);
        matriculas.set(plazaLibre, null);
        return plazaLibre;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int count = 0;
        for (String matricula : matriculas) {
            if (matricula != null) {
                count++;
            }
        }
        return count;
    }

    public int getPlazasLibres() {
        return matriculas.size() - getPlazasOcupadas();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(parking).append("\n");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("Plaza ").append(i).append(": ");
            String matricula = matriculas.get(i);
            if (matricula != null) {
                sb.append(matricula);
            } else {
                sb.append("(vacio)");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
