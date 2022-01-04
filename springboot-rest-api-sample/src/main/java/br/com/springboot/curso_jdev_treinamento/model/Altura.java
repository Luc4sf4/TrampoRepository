package br.com.springboot.curso_jdev_treinamento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator (name= "seq_alt", sequenceName = "seq_alt", allocationSize = 1,initialValue = 1)

public class Altura  implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	
	@Id
	@GeneratedValue (strategy =  GenerationType.SEQUENCE, generator = "seq_alt")
	private Long id;

	private String description;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
