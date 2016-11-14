package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name="avaliacao_id", sequenceName="avaliacao_seq", allocationSize=1)
public class Avaliacao extends AbstractEntity{

	@Transient
	private Aluno aluno;
	
	@OneToMany(mappedBy="avaliacao", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<MedidaAvaliacao> medidasAvaliacao;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="avaliacao_id")
	private Long id;
	@Override
	public void setId(Long id) {
		this.id =id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<MedidaAvaliacao> getMedidasAvaliacao() {
		return medidasAvaliacao;
	}

	public void setMedidasAvaliacao(List<MedidaAvaliacao> medidasAvaliacao) {
		this.medidasAvaliacao = medidasAvaliacao;
	}

}
