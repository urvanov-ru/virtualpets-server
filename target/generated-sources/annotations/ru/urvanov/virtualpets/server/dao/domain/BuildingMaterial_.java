package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BuildingMaterial.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class BuildingMaterial_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BuildingMaterial#code
	 **/
	public static volatile SingularAttribute<BuildingMaterial, BuildingMaterialType> code;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BuildingMaterial#id
	 **/
	public static volatile SingularAttribute<BuildingMaterial, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BuildingMaterial
	 **/
	public static volatile EntityType<BuildingMaterial> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BuildingMaterial#version
	 **/
	public static volatile SingularAttribute<BuildingMaterial, Integer> version;

	public static final String CODE = "code";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

