package br.com.springboot.curso_jdev_treinamento.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator (name= "seq_paramet", sequenceName = "seq_paramet", allocationSize = 1,initialValue = 1)
public class Parametros implements Serializable {
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue (strategy =  GenerationType.SEQUENCE, generator = "seq_paramet")
	private Long id;

	private String sitetitle;
	
	private String subtitle1;
	
	private String status;

	private String txt1;
	
	private String title_album;
	
	private String title_video;
	
	
	
	
	
	public String getTitle_video() {
		return title_video;
	}

	public void setTitle_video(String title_video) {
		this.title_video = title_video;
	}

	public String getTitle_album() {
		return title_album;
	}

	public void setTitle_album(String title_album) {
		this.title_album = title_album;
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSitetitle() {
		return sitetitle;
	}

	public void setSitetitle(String sitetitle) {
		this.sitetitle = sitetitle;
	}


	public String getSubtitle1() {
		return subtitle1;
	}

	public void setSubtitle1(String subtitle1) {
		this.subtitle1 = subtitle1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
