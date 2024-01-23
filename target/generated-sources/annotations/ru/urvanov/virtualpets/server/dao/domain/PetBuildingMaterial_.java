package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PetBuildingMaterial.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PetBuildingMaterial_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial#buildingMaterial
	 **/
	public static volatile SingularAttribute<PetBuildingMaterial, BuildingMaterial> buildingMaterial;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial#id
	 **/
	public static volatile SingularAttribute<PetBuildingMaterial, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial
	 **/
	public static volatile EntityType<PetBuildingMaterial> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial#buildingMaterialCount
	 **/
	public static volatile SingularAttribute<PetBuildingMaterial, Integer> buildingMaterialCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial#version
	 **/
	public static volatile SingularAttribute<PetBuildingMaterial, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetBuildingMaterial#pet
	 **/
	public static volatile SingularAttribute<PetBuildingMaterial, Pet> pet;

	public static final String BUILDING_MATERIAL = "buildingMaterial";
	public static final String ID = "id";
	public static final String BUILDING_MATERIAL_COUNT = "buildingMaterialCount";
	public static final String VERSION = "version";
	public static final String PET = "pet";

}

