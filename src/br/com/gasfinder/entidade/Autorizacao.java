/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gasfinder.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jose.macedo
 */
@Entity
public class Autorizacao implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2713952192913640272L;
	
	@Id
    private String nome;

    public Autorizacao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
