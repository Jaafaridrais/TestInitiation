package org.lpee.testPFA.entities;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class ActionCorrective implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAction;
	@Temporal(TemporalType.DATE)
	private Date datePrevue;
	@Temporal(TemporalType.DATE)
	private Date dateReel;
	private String description;
	@OneToMany(mappedBy="actionCorrective" )
	private Collection<FicheAnomalie> ficheAnomalies;
	

	
	public ActionCorrective(Date datePrevue, Date dateReel, String description) {
		super();
		this.datePrevue = datePrevue;
		this.dateReel = dateReel;
		this.description = description;
	}
	public ActionCorrective() {
		super();
	}
	public Long getIdAction() {
		return idAction;
	}
	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}
	public Date getDatePrevue() {
		return datePrevue;
	}
	public void setDatePrevue(Date datePrevue) {
		this.datePrevue = datePrevue;
	}
	public Date getDateReel() {
		return dateReel;
	}
	public void setDateReel(Date dateReel) {
		this.dateReel = dateReel;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<FicheAnomalie> getFicheAnomalies() {
		return ficheAnomalies;
	}
	public void setFicheAnomalies(Collection<FicheAnomalie> ficheAnomalies) {
		this.ficheAnomalies = ficheAnomalies;
	}
	public Collection<FicheAnomalie> getFicheAnomalie() {
		return ficheAnomalies;
	}
	public void setFicheAnomalie(Collection<FicheAnomalie> ficheAnomalie) {
		this.ficheAnomalies = ficheAnomalie;
	}

	

}
