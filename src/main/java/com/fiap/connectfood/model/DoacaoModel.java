package com.fiap.connectfood.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_DOACAO")
public class DoacaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_rest")
	private UserModel restaurante;

	@ManyToOne
	@JoinColumn(name = "id_inst")
	private UserModel instituicao;

	@Column(name = "dt_agendamento")
	@Temporal(TemporalType.DATE)
	private Date dataAgendamento;

	@Column(name = "finalizada")
	private boolean doacaoFinalizada;

	@Column(name = "dt_finalizado")
	@Temporal(TemporalType.DATE)
	private Date dataFinalizado;

	public DoacaoModel() {

	}

	public DoacaoModel(int id, UserModel restaurante, UserModel instituicao) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(UserModel restaurante) {
		this.restaurante = restaurante;
	}

	public UserModel getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(UserModel instituicao) {
		this.instituicao = instituicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public boolean isDoacaoFinalizada() {
		return doacaoFinalizada;
	}

	public void setDoacaoFinalizada(boolean doacaoFinalizada) {
		this.doacaoFinalizada = doacaoFinalizada;
	}

	@Override
	public String toString() {
		return "DoacaoModel [id=" + id + ", restaurante=" + restaurante + ", instituicao=" + instituicao + "descricao"
				+ descricao +"]";
	}

	public Date getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(Date dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}
}