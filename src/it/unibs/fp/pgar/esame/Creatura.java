package it.unibs.fp.pgar.esame;

import java.util.Random;

import it.unibs.fp.mylib.InputDati;

public class Creatura {
	private String nome;
	protected int vita;
	protected int atk;
	protected int def;
	protected Arma arma;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVita() {
		return vita;
	}
	public void setVita(int vita) {
		this.vita = vita;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void attacca(Creatura c) {
		
	}
	
	
}
