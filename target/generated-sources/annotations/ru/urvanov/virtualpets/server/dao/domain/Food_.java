package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Food.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Food_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Food#code
	 **/
	public static volatile SingularAttribute<Food, FoodType> code;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Food#id
	 **/
	public static volatile SingularAttribute<Food, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Food
	 **/
	public static volatile EntityType<Food> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Food#version
	 **/
	public static volatile SingularAttribute<Food, Integer> version;

	public static final String CODE = "code";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

