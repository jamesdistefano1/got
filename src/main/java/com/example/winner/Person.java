package com.example.winner;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity 
public class Person {

	private @Id @GeneratedValue Long id;
	private String name;
	private int rawScore;

	private Person() {}

	public Person(String name, int rawScore) {
		this.name = name;
		this.rawScore = rawScore;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id) &&
			Objects.equals(name, person.name) &&
			Objects.deepEquals(rawScore, person.rawScore);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, rawScore);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRawScore() {
		return rawScore;
	}

	public void setRawScore(int rawScore) {
		this.rawScore = rawScore;
	}

	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", name='" + name + '\'' +
			", rawScore='" + rawScore + '\'' +
			'}';
	}
}