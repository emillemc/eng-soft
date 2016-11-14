package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="avaliacao_id", sequenceName="avaliacao_seq", allocationSize=1)
public class MedidaAvaliacao extends AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="avaliacao_id")
	private Long id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Avaliacao avaliacao;
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
