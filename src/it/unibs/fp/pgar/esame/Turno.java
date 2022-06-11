package it.unibs.fp.pgar.esame;
import it.unibs.fp.mylib.MyMenu;
import java.util.ArrayList;

public class Turno {
	
	/*
	 * il metodo procedi presenta la scelta della mossa all'utente e aggiorna la mappa con gli spostamenti
	 */
	public static char procedi() {
		String titolo = "Inventario:";
		String[] voci = {"Inventario", "Statistiche"};
		MyMenu menu = new MyMenu(titolo, voci);
	    String mossa = Personaggio.azione();
		int x = Personaggio.getPosizione()[0];
		int y = Personaggio.getPosizione()[1];
		int x1 = Personaggio.getPosizione()[0]; //salvo due volte le coordinate
		int y1 = Personaggio.getPosizione()[1];
		Piano piano = Mappa.getPiani().get(Personaggio.pianoCorrente); //prende in considerazione il piano corrente
		
	switch(mossa) {
		case "W":
			y--;
			break;
			
		case "A":
			x--;
			break;
			
		case "S":
			y++;
			break;
			
		case "D":
			x++;
			break;
			
		case "M":
			int scelta = menu.scegli();
			switch(scelta) {
			case 1:
				System.out.println(Personaggio.getInventario());
				break;
			case 2:
				
				break;
			}
			break;
			
		case "E":
			//apri chest
			break;
		
	}
	int[] z = new int[2];
	z[0] = x; z[1] = y;
	
	if(y < piano.getAltezza() && y >= 0 && x < piano.getLarghezza() && x >= 0 && piano.getMappaPiano()[y][x] != '#') {
	char[][] mappa = piano.getMappaPiano();
	mappa[x1][y1] = '.';
	mappa[x][y] = 'O';
	piano.setMappaPiano(mappa);
	piano.stampaPiano();
	
	Personaggio.setPosizione(z);
	
	if(piano.getMappaPiano()[y][x] == 'T') {
		Personaggio.pianoCorrente ++;
	}
	
	if(piano.getMappaPiano()[y][x] == 't') 
		Personaggio.pianoCorrente --;
	
	if(piano.getMappaPiano()[y][x] == 'M')
		return 'M';
	if(piano.getMappaPiano()[y][x] == 'B')
		return 'B';
	if(piano.getMappaPiano()[y][x] == 'K')
		return 'K';
	
	if(piano.getMappaPiano()[y][x] == 'C') {
		Chest chest = new Chest();
		chest.generaChest();
		chest.daiOggetto();
	}
	}
	else
		System.out.println("Non puoi andare qui!");
	
	return ' ';
	}
}
