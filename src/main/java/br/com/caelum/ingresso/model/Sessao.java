package br.com.caelum.ingresso.model;

import java.time.LocalTime;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;

public class Sessao {
	private Integer id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;
	
	public Sessao(LocalTime horario, Filme filme, Sala sala){
		this.horario = horario;
		this.filme = filme;
		this.sala =sala;
	}
	
	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}
	
	public Filme getFilme(){
		return filme;
	}
	
	public LocalTime getHorario(){
		return horario;
	}
}