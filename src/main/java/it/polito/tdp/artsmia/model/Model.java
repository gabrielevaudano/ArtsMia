package it.polito.tdp.artsmia.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.artsmia.db.ArtsmiaDAO;

public class Model {
	
	private Graph<ArtObject, DefaultWeightedEdge> grafo;
	private Map<Integer, ArtObject> artObjectIdMap;
	
	public Model() {
		artObjectIdMap = new HashMap<>();
		
	}
	
	public void creaGrafoMetodoUno() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ArtsmiaDAO dao = new ArtsmiaDAO();
		// Aggiunta vertici
		dao.listObjects(artObjectIdMap);
		Graphs.addAllVertices(this.grafo, artObjectIdMap.values());
		
		
	}
	public void creaGrafo() {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ArtsmiaDAO dao = new ArtsmiaDAO();
		// Aggiunta vertici
		dao.listObjects(artObjectIdMap);
		Graphs.addAllVertices(this.grafo, artObjectIdMap.values());
		
		// Aggiunta di archi tra i vertici
		// Tre strategie principali
		
		// APPROCCIO 1 -> doppio ciclo for sui vertici, dati due vertici controllo se sono colelgati

		List<Adiacenza> adiacenze = dao.getAdiacenze(artObjectIdMap);

		for (Adiacenza a: adiacenze)
			Graphs.addEdge(this.grafo, a.getOa1(), a.getOa2(), a.getPeso());
		
		System.out.format("Grafo creato. %d vertici e %d archi.", this.grafo.vertexSet().size(), this.grafo.edgeSet().size());

	}
	
}
