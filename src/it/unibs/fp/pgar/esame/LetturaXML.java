package it.unibs.fp.pgar.esame;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LetturaXML {
	
	 
/**
 * Il metodo leggiXML ha la funzione di leggere i documenti xml 
 * L'oggetto di ritorno è una matrice di char
 * @author Teo
 */
public static Piano leggiXML(String filename) {
	 int nRow = 0;
	 int nCol = 0;
	 String stringTemp = "";
	 String tipo = "";
	 ArrayList<String> mappa = new ArrayList<>();
	 
	 
	XMLInputFactory xmlif = null;
	XMLStreamReader xmlr = null;
	try {
	 xmlif = XMLInputFactory.newInstance();
	 xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
	} catch (Exception e) {
	 System.out.println("Errore nell'inizializzazione del reader:");
	 System.out.println(e.getMessage());
	}
	
	//inizio lettura
	try {
		while (xmlr.hasNext()) {
			switch (xmlr.getEventType()) {
			
			case XMLStreamConstants.START_ELEMENT: 
				 if(xmlr.getLocalName().equals("row")) {
					 nRow++; //useless
					 stringTemp = "";
					 nCol=0;
				 	}
				 if(xmlr.getLocalName().equals("cell")) {
					 tipo = "cell";
				 }
				 
				 break;
				 
			case XMLStreamConstants.END_ELEMENT: 
				if(xmlr.getLocalName().equals("row")) {
					
					 mappa.add(stringTemp);
				}
				 break;
				 
			case XMLStreamConstants.CHARACTERS: 	
				if(!xmlr.getText().equals("\n        ") && !xmlr.getText().equals("\n\t\t")) {
					
					switch(tipo) {
					case "cell":
						stringTemp += xmlr.getText();
						tipo = "";
						nCol++;
						break;
					
					case "":
						
						break;
					}
					
					//System.out.print(xmlr.getText()); 
				 }
				break;
			}
			
			 xmlr.next();
		}
	
		
		
	}
	catch (XMLStreamException e) {
		e.printStackTrace();
	}
	
	
	//converte la griglia da array di string a matrice di char
	char[][] mappaC = new char[nRow][nCol];
	
	for(int i=0; i<nRow;i++) {
		for (int j=0; j<nCol; j++) {
			mappaC[i][j]= mappa.get(i).charAt(j);
		}
	}
	
	Piano piano = new Piano();
	piano.setMappaPiano(mappaC);
	piano.setAltezza(nRow);
	piano.setLarghezza(nCol);
	return piano;
}
}
