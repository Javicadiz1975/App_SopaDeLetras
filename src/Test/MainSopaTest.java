import model.SopaDeLetras;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainSopaTest {

    SopaDeLetras sopaDeLetras;
    String cadena = "testotestotestotestotesto";
    @Before
    public void setUp() {
        sopaDeLetras = new SopaDeLetras(5, 5);
        sopaDeLetras.crearSopadeLetras(cadena);
    }
    @Test
    public void testCrearSopaDeLetras() {
        // sopa de izquierda a derecha y de arriba a abajo,
        char[][] esperado = {
                {'t', 'e', 's', 't', 'o'},
                {'t', 'e', 's', 't', 'o'},
                {'t', 'e', 's', 't', 'o'},
                {'t', 'e', 's', 't', 'o'},
                {'t', 'e', 's', 't', 'o'},
        };

        // Llamamos al método para crear la sopa de letras con nuestra cadena de prueba
        sopaDeLetras.crearSopadeLetras(cadena);

        // Verificar que cada posición de la sopa de letras contiene el caracter esperado
        for (int i = 0; i < esperado.length; i++) {
            assertArrayEquals("La fila " + (i + 1) + " no coincide con lo esperado.", esperado[i], sopaDeLetras.getSopa()[i]);
        }
    }


    @Test
    public void testComprobarPalabraHorizontalmente() {

        //palabra "test" se espera encontrarla empezando en la posición (0, 0) y extendiéndose horizontalmente hasta la posición (0, 3).
        int[][] resultadoEsperado = new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}};

        // Llama al método 'comprobarPalabra' con los parámetros necesarios para buscar
        int[][] coords = sopaDeLetras.comprobarPalabra("test", 0, 0, false);

        // Verifica que el resultado de 'comprobarPalabra' no sea null, lo que indicaría
        assertNotNull("Debería haber encontrado la palabra 'test' horizontalmente.", coords);

        // Comprueba que las coordenadas devueltas por 'comprobarPalabra' coincidan exactamente con el resultado esperado
        assertArrayEquals("Las coordenadas de la palabra 'test' no son las esperadas.", resultadoEsperado, coords);
    }

    @Test
    public void testComprobarPalabraVerticalmente() {

        //palabra "tttt" cuando se espera encontrarla empezando en la posición (0, 0)  y extendiéndose verticalmente hasta la posición (3, 0).
        int[][] resultadoEsperado = new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}};

        // Llama al método 'comprobarPalabra' con los parámetros necesarios para buscar
        int[][] coords = sopaDeLetras.comprobarPalabra("tttt", 0, 0, true);

        // Verifica que el resultado de 'comprobarPalabra' no sea null
        assertNotNull("Debería haber encontrado la palabra 'test' verticalmente.", coords);

        // Comprueba que las coordenadas devueltas por 'comprobarPalabra' coincidan exactamente con el resultado esperado. .
        assertArrayEquals("Las coordenadas de la palabra 'test' no son las esperadas.", resultadoEsperado, coords);
    }

    @Test
    public void testPalabraNoEncontrada() {

        // Llama al método comprobarPalabra
        int[][] coords = sopaDeLetras.comprobarPalabra("xyz", 0, 0, true);

        // Verifica que el resultado de 'comprobarPalabra' sea null, lo cual indicaría que la palabra "xyz" no fue encontrada en la sopa de letras.
        assertNull("No debería haber encontrado la palabra 'xyz'.", coords);
    }

    @Test
    public void testMarcarLetrasDescubiertas() {
        //Definir un conjunto de coordenadas para marcar como descubiertas
        int[][] coordenadas = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}};

        //Ejecutar el método marcarLetrasDescubiertas con el conjunto de coordenadas definido
        SopaDeLetras.marcarLetrasDescubiertas(coordenadas);

        //Verificar que cada una de estas coordenadas ahora está marcada como descubierta en la matriz descubiertas
        for (int[] coord : coordenadas) {
            assertTrue("La coordenada en (" + coord[0] + ", " + coord[1] + ") debería estar marcada como descubierta.", sopaDeLetras.getDescubiertas()[coord[0]][coord[1]]);
        }
    }

    @Test
    public void testBuscarPalabraPresente() {
        //Asumiendo que 'test' está en la primera fila o columna
        assertTrue("La palabra 'test' debería estar presente en la sopa.", sopaDeLetras.buscarPalabra("test"));
    }

    @Test
    public void testBuscarPalabraNoPresente() {
        //Asumiendo que 'm05' no está en la sopa de letras
        assertFalse("La palabra 'java' no debería estar presente en la sopa.",sopaDeLetras.buscarPalabra("m05"));
    }



}