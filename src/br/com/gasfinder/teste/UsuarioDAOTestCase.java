package br.com.gasfinder.teste;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.gasfinder.dao.UsuarioDAO;
import br.com.gasfinder.entidade.Usuario;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springTeste.xml" })
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
public class UsuarioDAOTestCase {

	private ApplicationContext ctx;
	private UsuarioDAO usuarioDAO;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("springTeste.xml");
		usuarioDAO = (UsuarioDAO) ctx.getBean("usuarioDAO");
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testGetUsuarioPorId(){
		Usuario usuario = new Usuario();
		Long id = (long) 1;
		
		try {
			usuario = usuarioDAO.buscarPorId(id);
			assertNotNull(usuario.getId());
			assertEquals(1, usuario.getId().intValue());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
