package com.example.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Entity ve Table annatation'lari yuzde yuze yakin kullanilir! 
@Entity

@Table(name = "job_positions") // Veri tabaninda hangi tabloya karsilik geldigini belirtir!
public class JobPosition {
	
	@Id // Primary Key bu ve islemlerini bu id'ye gore yapacak! Bundan dolayi yaziyoruz!!!
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id'ler bir bir elle ya da otomatik olarak artar. Burada id'nin nasil artirilacagini soyledik!  
	@Column(name = "id") // Bu alan veritabaninda hangi kolona karsilik geldigini gosterir. Kolonun adi yazilir.
	private int id;
	
	@Column(name = "position")
	private String position;

	public JobPosition() {

	}

	public JobPosition(int id, String position) {
		super();
		this.id = id;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
