package br.com.gasfinder.controle;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import br.com.gasfinder.dao.ComentarioDAO;
import br.com.gasfinder.dao.JdbcComentarioDAO;
import br.com.gasfinder.dao.JdbcPostoBuscaDAO;
import br.com.gasfinder.dao.JdbcValorCombustivel2DAO;
import br.com.gasfinder.dao.ValorCombustivel2DAO;
import br.com.gasfinder.entidade.Comentario;
import br.com.gasfinder.entidade.Posto;
import br.com.gasfinder.entidade.PostoBusca;
import br.com.gasfinder.entidade.Usuario;
import br.com.gasfinder.entidade.ValorCombustivel2;
import br.com.gasfinder.util.BeanFactory;


@ManagedBean(name="postoController")
public class PostoController {

	private JdbcPostoBuscaDAO postoBuscaDAO = (JdbcPostoBuscaDAO) BeanFactory.getBean("jdbcPostoBuscaDAO", JdbcPostoBuscaDAO.class);
	private ComentarioDAO comentarioDAO = (ComentarioDAO) BeanFactory.getBean("comentarioDAO", ComentarioDAO.class);
	private ValorCombustivel2DAO valorCombustivel2DAO = (ValorCombustivel2DAO) BeanFactory.getBean("valorCombustivel2DAO", ValorCombustivel2DAO.class);
	private JdbcValorCombustivel2DAO jdbcValorCombustivel2DAO = (JdbcValorCombustivel2DAO) BeanFactory.getBean("jdbcValorCombustivel2DAO", JdbcValorCombustivel2DAO.class);
	private JdbcComentarioDAO jdbcComentarioDAO = (JdbcComentarioDAO) BeanFactory.getBean("jdbcComentarioDAO", JdbcComentarioDAO.class);
	
	private String nome;
	private String endereco;
	private String bandeira;
	private String cidade;
	private String uf;
	private String comentario;
	private BigDecimal valorGasolina;
	private BigDecimal valorEtanol;
	private BigDecimal valorGLP;
	private BigDecimal valorGNV;
	private int idvc;
	private BigDecimal valorDiesel;
	private BigDecimal lastValorGasolina;
	private BigDecimal lastValorEtanol;
	private BigDecimal lastValorGLP;
	private BigDecimal lastValorGNV;
	private BigDecimal lastValorDiesel;
	private List<Comentario> comentarios;
	private String usuario;
	private List<ValorCombustivel2> historicos;
	
	@ManagedProperty(value="#{param.code}")
    private Long code;
	
	
	@PostConstruct
    public void init() {
		List<PostoBusca> posto = this.postoBuscaDAO.buscarPorIdAprovado(this.code);
		
		for(PostoBusca p:posto){
			this.nome = p.getNomePosto();
			this.endereco = p.getEndereco();
			this.bandeira = p.getBandeira();
			this.cidade = p.getCidade();
			this.uf = p.getUf();
			this.valorGasolina = p.getValorGasolina();
			this.valorEtanol = p.getValorEtanol();
			this.valorGLP = p.getValorGLP();
			this.valorGNV = p.getValorGNV();
			this.valorDiesel = p.getValorDiesel();
			
			this.lastValorDiesel = this.valorDiesel;
			this.lastValorEtanol = this.valorEtanol;
			this.lastValorGasolina = this.valorGasolina;
			this.lastValorGLP = this.valorGLP;
			this.lastValorGNV = this.valorGNV;
			
		}
    }
	
	public List<ValorCombustivel2> getHistoricos(){
		this.historicos = this.valorCombustivel2DAO.buscarPorFiltroHistoricos(this.code);
		return this.historicos;
	}
	
	public List<Comentario> getComentarios(){
		this.comentarios = this.comentarioDAO.buscarPorFiltroAprovador(this.code);
		return this.comentarios;
	}
	
	public void salvar(){
		ValorCombustivel2 vc = new ValorCombustivel2();
		Posto p = new Posto();
		p.setId(this.code);
		vc.setPosto(p);
		vc.setId(new Long(this.jdbcValorCombustivel2DAO.getMax()+1));
		vc.setDataAlteracao(new Timestamp(new Date().getTime()));
		Usuario u = new Usuario();
		u.setId(new Long(1));
		vc.setUsuario(u);
		vc.setValorDiesel(this.valorDiesel);
		vc.setValorEtanol(this.valorEtanol);
		vc.setValorGasolina(this.valorGasolina);
		vc.setValorGNV(this.valorGNV);
		vc.setValorGLP(new BigDecimal(0));
		vc.setStatus("P");
		
		if(this.jdbcValorCombustivel2DAO.salvar(vc) == 1){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Valor Será Submetido à Aprovação!"));  
    	}
	}
	
	public void salvarComentarios(){
		Comentario c = new Comentario();
		c.setId(new Long(this.jdbcComentarioDAO.getMax()+1));
		Posto p = new Posto();
		p.setId(this.code);
		c.setPosto(p);
		Usuario u = new Usuario();
		u.setId(new Long(1));
		c.setUsuario(u);
		c.setComentario(this.comentario);
		c.setData(new Date());
		c.setStatus("P");
		
		if(this.jdbcComentarioDAO.salvar(c) == 1){
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Comentario Será Submetido à Aprovação!"));  
    	}

	}

	public Long getCode() {
		return code;
	}


	public void setCode(Long code) {
		this.code = code;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getBandeira() {
		return bandeira;
	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public BigDecimal getValorGasolina() {
		return valorGasolina;
	}


	public void setValorGasolina(BigDecimal valorGasolina) {
		this.valorGasolina = valorGasolina;
	}


	public BigDecimal getValorEtanol() {
		return valorEtanol;
	}


	public void setValorEtanol(BigDecimal valorEtanol) {
		this.valorEtanol = valorEtanol;
	}


	public BigDecimal getValorGLP() {
		return valorGLP;
	}


	public void setValorGLP(BigDecimal valorGLP) {
		this.valorGLP = valorGLP;
	}


	public BigDecimal getValorDiesel() {
		return valorDiesel;
	}


	public void setValorDiesel(BigDecimal valorDiesel) {
		this.valorDiesel = valorDiesel;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public BigDecimal getValorGNV() {
		return valorGNV;
	}


	public void setValorGNV(BigDecimal valorGNV) {
		this.valorGNV = valorGNV;
	}

	public BigDecimal getLastValorGasolina() {
		return lastValorGasolina;
	}

	public void setLastValorGasolina(BigDecimal lastValorGasolina) {
		this.lastValorGasolina = lastValorGasolina;
	}

	public BigDecimal getLastValorEtanol() {
		return lastValorEtanol;
	}

	public void setLastValorEtanol(BigDecimal lastValorEtanol) {
		this.lastValorEtanol = lastValorEtanol;
	}

	public BigDecimal getLastValorGLP() {
		return lastValorGLP;
	}

	public void setLastValorGLP(BigDecimal lastValorGLP) {
		this.lastValorGLP = lastValorGLP;
	}

	public BigDecimal getLastValorGNV() {
		return lastValorGNV;
	}

	public void setLastValorGNV(BigDecimal lastValorGNV) {
		this.lastValorGNV = lastValorGNV;
	}

	public BigDecimal getLastValorDiesel() {
		return lastValorDiesel;
	}

	public void setLastValorDiesel(BigDecimal lastValorDiesel) {
		this.lastValorDiesel = lastValorDiesel;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setHistoricos(List<ValorCombustivel2> historicos) {
		this.historicos = historicos;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdvc() {
		return idvc;
	}

	public void setIdvc(int idvc) {
		this.idvc = idvc;
	}
	
	
		
}
