package com.adit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TBL_COUNTRY")
public class Country implements Serializable {

	private static final long serialVersionUID = 2237903394654338796L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private Set<State> state;

	public Country() {
	}

	public Country(Long id) {
		this.id = id;
	}

	public Country(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Set<State> getState() {
		return state;
	}

	public void setState(Set<State> state) {
		this.state = state;
	}
}
