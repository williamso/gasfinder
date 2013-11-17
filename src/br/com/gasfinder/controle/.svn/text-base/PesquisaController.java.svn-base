package br.com.gasfinder.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.com.gasfinder.dao.JdbcPostoBuscaDAO;
import br.com.gasfinder.entidade.PostoBusca;
import br.com.gasfinder.util.BeanFactory;
import br.com.gasfinder.util.LongLatService;

@ManagedBean(name="pesquisaController")
@ViewScoped
public class PesquisaController {
	
	List<PostoBusca> resultado;
	
	String palavras;
	
	private JdbcPostoBuscaDAO postoBuscaDAO = (JdbcPostoBuscaDAO) BeanFactory.getBean("jdbcPostoBuscaDAO", JdbcPostoBuscaDAO.class);
	
	private MapModel simpleModel; 
	
	private Marker marker; 
    
	private String lat;
	
	private String lon;
	
	private String id;
	
	private int idxTab;
	
	public PesquisaController(){
		LongLatService tDirectionService = new LongLatService();
		tDirectionService.getLongitudeLatitude(this.palavras);
		
		this.lat = tDirectionService.getLagitude();
		this.lon = tDirectionService.getLongitude();
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public List<PostoBusca> buscar() throws ParseException{
		Session session = BeanFactory.getSessionFactory().openSession();
		
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();

		// create native Lucene query
		String[] fields = new String[]{"nomePosto", "endereco", "bandeira", "cidade", "uf", "combustivel", "valor"};
		MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
		Query query = parser.parse( this.palavras );

		// wrap Lucene query in a org.hibernate.Query
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, PostoBusca.class);

		List<PostoBusca> result = hibQuery.list();
		return result;
		// execute search
		//List<PostoBusca> result = hibQuery.list();
		
		/*for(PostoBusca postoBusca:result){
			System.out.println(" Buscou: "+postoBusca.getNomePosto()+" Cidade: "+postoBusca.getCidade()+" UF: "+postoBusca.getUf()+" Bandeira: "+postoBusca.getBandeira());
		}
		tx.commit();
		session.close();
		return false; */
	}
	
	public void buscarMaps() throws ParseException{
		//LongLatService tDirectionService = new LongLatService();
		
		for(PostoBusca posto: this.buscar()){
			//tDirectionService.getLongitudeLatitude(posto.getEndereco()+" - "+ posto.getCidade()+" - "+ posto.getUf());
			//System.out.println(posto.getNomePosto()+"  Latitude: "+tDirectionService.getLagitude()+ "  Longitude: "+ tDirectionService.getLongitude());
			this.marker(posto);
		}
	}
	
	public List<PostoBusca> getResultado() throws ParseException {
		this.resultado = new ArrayList<PostoBusca>();
		this.resultado = this.buscar();
		//this.buscarMaps();
		return resultado;
	}

	public void setResultado(List<PostoBusca> resultado) {
		this.resultado = resultado;
	}

	public String getPalavras() {
		return palavras;
	}

	public void setPalavras(String palavras) {
		this.palavras = palavras;
	}
	
    public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public void marcar(ActionEvent actionEvent) throws ParseException{
		this.id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"); 
		this.idxTab = 1;
		simpleModel = new DefaultMapModel(); 
		List<PostoBusca> posto = this.postoBuscaDAO.buscarPorId(new Long(this.id));
		this.marker(posto.get(0));
	}
	
	public void marker(PostoBusca posto) throws ParseException {  
        //LongLatService tDirectionService = new LongLatService();
		
		//for(PostoBusca posto: this.buscar()){
			//tDirectionService.getLongitudeLatitude(posto.getEndereco()+" - "+ posto.getCidade()+" - "+ posto.getUf());
			try {
				//LatLng coord1 = new LatLng(new Double(tDirectionService.getLagitude()), new Double(tDirectionService.getLongitude()));  
				LatLng coord1 = new LatLng(posto.getLatitude(), posto.getLongitude());  
				simpleModel.addOverlay(new Marker(coord1, posto.getNomePosto(),posto,"images/gazstation.png"));  
			} catch (Exception e) {
				System.out.println("Erro: "+posto.getNomePosto());
				e.printStackTrace();
			}
		//}
    }  
  
    public MapModel getSimpleModel() throws ParseException {  
    	if(simpleModel == null){
    		simpleModel = new DefaultMapModel(); 
        	this.buscarMaps();
    	}
    	
        return simpleModel;  
    }
    
	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdxTab() {
		return idxTab;
	}

	public void setIdxTab(int idxTab) {
		this.idxTab = idxTab;
	}  
	
	
}
