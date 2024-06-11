package com.turf_time.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turfTypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurfType {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer turfTypeId;
	
    private String turfTypeName;

    @ManyToMany(mappedBy = "turfTypes",cascade = CascadeType.ALL)
    private List<Turf> turfs;
}
