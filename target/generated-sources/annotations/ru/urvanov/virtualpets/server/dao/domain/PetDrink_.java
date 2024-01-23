package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PetDrink.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PetDrink_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink#drinkCount
	 **/
	public static volatile SingularAttribute<PetDrink, Integer> drinkCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink#id
	 **/
	public static volatile SingularAttribute<PetDrink, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink
	 **/
	public static volatile EntityType<PetDrink> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink#version
	 **/
	public static volatile SingularAttribute<PetDrink, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink#pet
	 **/
	public static volatile SingularAttribute<PetDrink, Pet> pet;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetDrink#drink
	 **/
	public static volatile SingularAttribute<PetDrink, Drink> drink;

	public static final String DRINK_COUNT = "drinkCount";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String PET = "pet";
	public static final String DRINK = "drink";

}

