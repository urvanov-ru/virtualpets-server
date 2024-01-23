package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RefrigeratorCost.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class RefrigeratorCost_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost#cost
	 **/
	public static volatile SingularAttribute<RefrigeratorCost, Integer> cost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost#buildingMaterial
	 **/
	public static volatile SingularAttribute<RefrigeratorCost, BuildingMaterial> buildingMaterial;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost#id
	 **/
	public static volatile SingularAttribute<RefrigeratorCost, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost
	 **/
	public static volatile EntityType<RefrigeratorCost> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost#refrigerator
	 **/
	public static volatile SingularAttribute<RefrigeratorCost, Refrigerator> refrigerator;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.RefrigeratorCost#version
	 **/
	public static volatile SingularAttribute<RefrigeratorCost, Integer> version;

	public static final String COST = "cost";
	public static final String BUILDING_MATERIAL = "buildingMaterial";
	public static final String ID = "id";
	public static final String REFRIGERATOR = "refrigerator";
	public static final String VERSION = "version";

}

