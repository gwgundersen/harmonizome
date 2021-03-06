package edu.mssm.pharm.maayanlab.Harmonizome.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attribute_type")
public class AttributeType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "attribute_group_fk")
	private AttributeGroup attributeGroup;

	@OneToMany(mappedBy = "attributeType")
	private Set<GeneSet> geneSets;

	@OneToMany(mappedBy = "attributeType")
	private Set<Dataset> datasets;
	
	public AttributeType() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public AttributeGroup getAttributeGroup() {
		return attributeGroup;
	}

	public void setAttributeGroup(AttributeGroup attributeGroup) {
		this.attributeGroup = attributeGroup;
	}

	public Set<GeneSet> getAttributes() {
		return geneSets;
	}

	public void setAttributes(Set<GeneSet> geneSets) {
		this.geneSets = geneSets;
	}

	public Set<Dataset> getDatasets() {
		return datasets;
	}

	public void setDatasets(Set<Dataset> datasets) {
		this.datasets = datasets;
	}

	@Transient
	public String getPluralizedName() {
		String name = this.getName();
		if (name.equals("protein complex") || name.equals("virus")) {
			return name + "es";
		} else if (name.equals("ligand (protein)")) {
			return "ligands (proteins)";
		} else {
			return name + "s";
		}
	}
}
