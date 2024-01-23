package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BookcaseCost.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class BookcaseCost_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost#cost
	 **/
	public static volatile SingularAttribute<BookcaseCost, Integer> cost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost#buildingMaterial
	 **/
	public static volatile SingularAttribute<BookcaseCost, BuildingMaterial> buildingMaterial;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost#bookcase
	 **/
	public static volatile SingularAttribute<BookcaseCost, Bookcase> bookcase;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost#id
	 **/
	public static volatile SingularAttribute<BookcaseCost, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost
	 **/
	public static volatile EntityType<BookcaseCost> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.BookcaseCost#version
	 **/
	public static volatile SingularAttribute<BookcaseCost, Integer> version;

	public static final String COST = "cost";
	public static final String BUILDING_MATERIAL = "buildingMaterial";
	public static final String BOOKCASE = "bookcase";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

