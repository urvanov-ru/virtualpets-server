package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.MapAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Bookcase.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Bookcase_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Bookcase#id
	 **/
	public static volatile SingularAttribute<Bookcase, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Bookcase#bookcaseCost
	 **/
	public static volatile MapAttribute<Bookcase, BuildingMaterial, BookcaseCost> bookcaseCost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Bookcase
	 **/
	public static volatile EntityType<Bookcase> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Bookcase#version
	 **/
	public static volatile SingularAttribute<Bookcase, Integer> version;

	public static final String ID = "id";
	public static final String BOOKCASE_COST = "bookcaseCost";
	public static final String VERSION = "version";

}

