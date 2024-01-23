package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PetFood.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PetFood_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood#foodCount
	 **/
	public static volatile SingularAttribute<PetFood, Integer> foodCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood#id
	 **/
	public static volatile SingularAttribute<PetFood, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood
	 **/
	public static volatile EntityType<PetFood> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood#version
	 **/
	public static volatile SingularAttribute<PetFood, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood#pet
	 **/
	public static volatile SingularAttribute<PetFood, Pet> pet;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetFood#food
	 **/
	public static volatile SingularAttribute<PetFood, Food> food;

	public static final String FOOD_COUNT = "foodCount";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String PET = "pet";
	public static final String FOOD = "food";

}

