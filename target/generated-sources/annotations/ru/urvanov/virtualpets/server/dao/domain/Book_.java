package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Book.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Book_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Book#id
	 **/
	public static volatile SingularAttribute<Book, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Book
	 **/
	public static volatile EntityType<Book> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Book#version
	 **/
	public static volatile SingularAttribute<Book, Integer> version;

	public static final String ID = "id";
	public static final String VERSION = "version";

}

