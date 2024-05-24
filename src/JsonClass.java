import java.util.Map;
//Clase tipo record que recibe el Json convertido en clase y almacena solo
//la clave conversion_rates en un Map
public record JsonClass(Map<String, Double> conversion_rates) {
}
