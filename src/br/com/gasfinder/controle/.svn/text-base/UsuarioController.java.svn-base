package br.com.gasfinder.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.gasfinder.dao.JdbcUsuarioDAO;
import br.com.gasfinder.dao.UsuarioDAO;
import br.com.gasfinder.entidade.Autorizacao;
import br.com.gasfinder.entidade.Usuario;
import br.com.gasfinder.util.BeanFactory;

@ManagedBean(name="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	
    private static final long serialVersionUID = 8763583833687309674L;
	
    private UsuarioDAO usuarioDAO = (UsuarioDAO) BeanFactory.getBean("usuarioDAO", UsuarioDAO.class);
    private JdbcUsuarioDAO jdbcUsuarioDAO = (JdbcUsuarioDAO) BeanFactory.getBean("jdbcUsuarioDAO", JdbcUsuarioDAO.class);
     
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String user;
    private String password;
    private String email;
    
    
    public UsuarioController() {
    	this.user = "";
    	this.password = "";
    	this.email = "";
    	
        usuario = new Usuario();
        SecurityContext context =  SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
            	String username = authentication.getPrincipal().toString();
            	if("anonymousUser".equalsIgnoreCase(username)){
            		usuario.setUsuario("Login");
            	}else{
             		usuario.setUsuario(((User)authentication.getPrincipal()).getUsername());

            	}
                
            }
        }
    }

    public Usuario getUsuario() {
    	 usuario = new Usuario();
         SecurityContext context =  SecurityContextHolder.getContext();
         if (context instanceof SecurityContext){
             Authentication authentication = context.getAuthentication();
             if (authentication instanceof Authentication){
             	String username = authentication.getPrincipal().toString();
             	if("anonymousUser".equalsIgnoreCase(username)){
             		usuario.setUsuario("Login");
             	}else{
             		usuario.setUsuario(((User)authentication.getPrincipal()).getUsername());
             	}
                 
             }
         }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getUsuarios() {
    	this.usuarios =  usuarioDAO.buscarTodos();
    	return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void salvar(){
    	if(!"".equalsIgnoreCase(this.password)){
	    	this.usuario.setId((long) jdbcUsuarioDAO.getMax()+1);
    		this.usuario.setAtivo(true);
	    	this.usuario.setSocial("E");
	    	this.usuario.setSenha(this.password);
	    	this.usuario.setUsuario(this.user);
	    	this.usuario.setEmail(this.email);
	    	
	    	Autorizacao au = new Autorizacao();
	    	au.setNome("ROLE_USER");
	    	
	    	List<Autorizacao> l = new ArrayList<Autorizacao>();
	    	l.add(au);
	    	
	    	this.usuario.setAutorizacoes(l);
	    	
	    	
	    	if(jdbcUsuarioDAO.salvar(usuario) == 1){
	    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem Vindo " + usuario.getUsuario() + "!"));  
	    	}
    	}
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}