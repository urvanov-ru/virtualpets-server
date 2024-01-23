package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Drink.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Drink_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Drink#drinkType
	 **/
	public static volatile SingularAttribute<Drink, DrinkType> drinkType;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Drink#id
	 **/
	public static volatile SingularAttribute<Drink, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Drink
	 **/
	public static volatile EntityType<Drink> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Drink#version
	 **/
	public static volatile SingularAttribute<Drink, Integer> version;

	public static final String DRINK_TYPE = "drinkType";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

