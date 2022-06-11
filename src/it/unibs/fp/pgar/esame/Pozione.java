package it.unibs.fp.pgar.esame;

public class Pozione extends Oggetto{
	
	public void ripristinaVita(Personaggio p) {
		int vitaPrima = p.getVita();
		int vitaDopo = 10 + vitaPrima;
		if(vitaDopo > 20) vitaDopo = 20;
		p.setVita(vitaDopo);
	}
}
