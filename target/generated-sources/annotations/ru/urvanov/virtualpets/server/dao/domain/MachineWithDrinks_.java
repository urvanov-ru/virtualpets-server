package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.MapAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MachineWithDrinks.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class MachineWithDrinks_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinks#id
	 **/
	public static volatile SingularAttribute<MachineWithDrinks, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinks#machineWithDrinksCost
	 **/
	public static volatile MapAttribute<MachineWithDrinks, BuildingMaterial, MachineWithDrinksCost> machineWithDrinksCost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinks
	 **/
	public static volatile EntityType<MachineWithDrinks> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinks#version
	 **/
	public static volatile SingularAttribute<MachineWithDrinks, Integer> version;

	public static final String ID = "id";
	public static final String MACHINE_WITH_DRINKS_COST = "machineWithDrinksCost";
	public static final String VERSION = "version";

}

