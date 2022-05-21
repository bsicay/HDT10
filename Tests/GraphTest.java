import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


/**
 * 
 */

/**
 * @author brand
 *
 */
class GraphTest {

	@Test
	void testShorterRoute() {
		AllPairShortestPath manager = new AllPairShortestPath();
		String[] lines = new String[] {"Mixco Antigua 30", "Antigua Escuintla 25", "Escuintla Santa-Lucia 15", "Santa-Lucia Guatemala 90", "Guatemala Mixco 15", "Guatemala Antigua 40", "Escuintla Guatemala 70"};
		manager.fileToGraph(lines);
		assertEquals(manager.shorterRoute("Mixco", "Antigua"), "Ruta: 30.0 km");
	}

	@Test
	void testgetGraphCenter() {
		AllPairShortestPath manager = new AllPairShortestPath();
		String[] lines = new String[] {"Mixco Antigua 30", "Antigua Escuintla 25", "Escuintla Santa-Lucia 15", "Santa-Lucia Guatemala 90", "Guatemala Mixco 15", "Guatemala Antigua 40", "Escuintla Guatemala 70"};
		manager.fileToGraph(lines);

		assertEquals(manager.getGraphCenter(), "Antigua");
	}

	@Test
	void testBreakRoute() {
		AllPairShortestPath manager = new AllPairShortestPath();
		String[] lines = new String[] {"Mixco Antigua 30", "Antigua Escuintla 25", "Escuintla Santa-Lucia 15", "Santa-Lucia Guatemala 90", "Guatemala Mixco 15", "Guatemala Antigua 40", "Escuintla Guatemala 70"};
		manager.fileToGraph(lines);

		assertEquals(manager.shorterRoute("Mixco", "Antigua"), "Ruta: 30.0 km");
		assertEquals(manager.breakRoute("Mixco", "Antigua"),"Ruta eliminada correctamente, se han recalculado las rutas mas cortas.");
		assertEquals(manager.shorterRoute("Mixco", "Antigua"), "Ruta: 55.0 km\nCiudades intermedias: Guatemala");
		
	}

	@Test
	void testNewRoute() {
		AllPairShortestPath	 manager = new AllPairShortestPath();
		String[] lines = new String[] {"Mixco Antigua 30", "Antigua Escuintla 25", "Escuintla Santa-Lucia 15", "Santa-Lucia Guatemala 90", "Guatemala Mixco 15", "Guatemala Antigua 40", "Escuintla Guatemala 70"};
		manager.fileToGraph(lines);
		manager.newRoute("Guatemala", "Mexico", 70);
		assertEquals(manager.shorterRoute("Antigua", "Mexico"), "Ruta: 110.0 km\nCiudades intermedias: Guatemala");
		
	}

}
