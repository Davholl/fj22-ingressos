package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;
	
	@ManyToOne
	private Lugar lugar;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	/**
	 * @depreceated hibernate only
	 */
	public Ingresso(){
		
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar){
		this.sessao = sessao;
		this.setTipoDeIngresso(tipoDeIngresso);
		this.preco = this.getTipoDeIngresso().aplicaDesconto(sessao.getPreco());
		this.setLugar(lugar);
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	
	
}