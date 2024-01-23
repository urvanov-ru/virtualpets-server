package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.MapAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Refrigerator.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Refrigerator_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Refrigerator#id
	 **/
	public static volatile SingularAttribute<Refrigerator, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Refrigerator#refrigeratorCost
	 **/
	public static volatile MapAttribute<Refrigerator, BuildingMaterial, RefrigeratorCost> refrigeratorCost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Refrigerator
	 **/
	public static volatile EntityType<Refrigerator> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Refrigerator#maxFoodType
	 **/
	public static volatile SingularAttribute<Refrigerator, Integer> maxFoodType;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Refrigerator#version
	 **/
	public static volatile SingularAttribute<Refrigerator, Integer> version;

	public static final String ID = "id";
	public static final String REFRIGERATOR_COST = "refrigeratorCost";
	public static final String MAX_FOOD_TYPE = "maxFoodType";
	public static final String VERSION = "version";

}

