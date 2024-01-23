package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MachineWithDrinksCost.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class MachineWithDrinksCost_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost#cost
	 **/
	public static volatile SingularAttribute<MachineWithDrinksCost, Integer> cost;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost#buildingMaterial
	 **/
	public static volatile SingularAttribute<MachineWithDrinksCost, BuildingMaterial> buildingMaterial;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost#machineWithDrinks
	 **/
	public static volatile SingularAttribute<MachineWithDrinksCost, MachineWithDrinks> machineWithDrinks;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost#id
	 **/
	public static volatile SingularAttribute<MachineWithDrinksCost, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost
	 **/
	public static volatile EntityType<MachineWithDrinksCost> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.MachineWithDrinksCost#version
	 **/
	public static volatile SingularAttribute<MachineWithDrinksCost, Integer> version;

	public static final String COST = "cost";
	public static final String BUILDING_MATERIAL = "buildingMaterial";
	public static final String MACHINE_WITH_DRINKS = "machineWithDrinks";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

