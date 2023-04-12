package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends BaseEntity {

	@Column
	private String name;
	
	@OneToMany
	@JoinColumn (name="university_id")
	List <Student> students = new ArrayList<>();

	public University(String name) {
		super();
		this.name = name;
	}

}
