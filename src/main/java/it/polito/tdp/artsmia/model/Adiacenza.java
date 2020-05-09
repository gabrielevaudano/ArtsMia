
package it.polito.tdp.artsmia.model;

public class Adiacenza {
	public ArtObject oa1;
	public ArtObject oa2;
	
	public Integer peso;

	public Adiacenza(ArtObject oa1, ArtObject oa2, Integer peso) {
		super();
		this.oa1 = oa1;
		this.oa2 = oa2;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oa1 == null) ? 0 : oa1.hashCode());
		result = prime * result + ((oa2 == null) ? 0 : oa2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Adiacenza other = (Adiacenza) obj;
		if (oa1 == null) {
			if (other.oa1 != null) {
				return false;
			}
		} else if (!oa1.equals(other.oa1)) {
			return false;
		}
		if (oa2 == null) {
			if (other.oa2 != null) {
				return false;
			}
		} else if (!oa2.equals(other.oa2)) {
			return false;
		}
		return true;
	}

	public ArtObject getOa1() {
		return oa1;
	}

	public ArtObject getOa2() {
		return oa2;
	}

	public Integer getPeso() {
		return peso;
	}
	
	
	
	
}
