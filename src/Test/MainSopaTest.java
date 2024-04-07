import model.SopaDeLetras;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainSopaTest {


    String cadena = "NASQYCCSOZMRWOIHZNFRZUIFEUWBYTPBFPCSFQQIPYTHONBGVIJPDDBTNEVWGGESOYPYTUFYUILECHAVVBZSHXTAJTDZXLYJAVAQ";
    String buscarPalabra = "PYTHON";
    String palabraNoExistente = "HOLA";
    @Before
    public void setUp() {
        SopaDeLetras sopaDeLetras = new SopaDeLetras(10, 10);
        SopaDeLetras.crearSopadeLetras(cadena);
    }
    @Test
    public void testCrearSopadeLetras() {
        char[][] sopa = SopaDeLetras.crearSopadeLetras(cadena);

        // Verifica que la longitud de la primera fila sea igual al número de columnas esperado.
        assertEquals("La primera fila de la sopa de letras debe tener la longitud esperada.", 10, sopa[0].length);

        // Además, verifica que ninguna fila tenga una longitud inesperadamente incorrecta, por ejemplo, 0.
        for (char[] fila : sopa) {
            assertNotEquals("Ninguna fila de la sopa de letras debe tener una longitud de 0.", 0, fila.length);
        }
    }

    @Test
    public void testComprobarPalabra() {
        // Palabra que sabemos está presente en la sopa de letras.

        // Verifica que la palabra existente sea encontrada.
        assertTrue("La palabra '" + buscarPalabra + "' debería existir en la Sopa de Letras", SopaDeLetras.buscarPalabra(buscarPalabra));

        // Verifica que la palabra no existente no sea encontrada.
        assertFalse("La palabra '" + palabraNoExistente + "' no debería existir en la Sopa de Letras", SopaDeLetras.buscarPalabra(palabraNoExistente));
    }

    @Test
    public void testMarcarLetrasDescubiertas() {
        // Verifica que la palabra exista en la sopa de letras para este test.
        boolean encontrada = SopaDeLetras.buscarPalabra(buscarPalabra);
        assertTrue("palabra no marcada por no encontrarse",encontrada);
    }

    @Test
    public void testBuscarPalabraPresente() {
        boolean resultado = SopaDeLetras.buscarPalabra(buscarPalabra);
        assertTrue("palabra no existente en SopadeLetra",resultado);
    }


}