package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#pets
	 **/
	public static volatile SetAttribute<User, Pet> pets;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#country
	 **/
	public static volatile SingularAttribute<User, String> country;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#vkontakteKey
	 **/
	public static volatile SingularAttribute<User, String> vkontakteKey;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#unid
	 **/
	public static volatile SingularAttribute<User, String> unid;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#birthdate
	 **/
	public static volatile SingularAttribute<User, Date> birthdate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#role
	 **/
	public static volatile SingularAttribute<User, Role> role;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#city
	 **/
	public static volatile SingularAttribute<User, String> city;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#loginDate
	 **/
	public static volatile SingularAttribute<User, Date> loginDate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#login
	 **/
	public static volatile SingularAttribute<User, String> login;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#twitterKey
	 **/
	public static volatile SingularAttribute<User, String> twitterKey;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#registrationDate
	 **/
	public static volatile SingularAttribute<User, Date> registrationDate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#activeDate
	 **/
	public static volatile SingularAttribute<User, Date> activeDate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#id
	 **/
	public static volatile SingularAttribute<User, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#facebookKey
	 **/
	public static volatile SingularAttribute<User, String> facebookKey;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#recoverPasswordKey
	 **/
	public static volatile SingularAttribute<User, String> recoverPasswordKey;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#sex
	 **/
	public static volatile SingularAttribute<User, Sex> sex;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#version
	 **/
	public static volatile SingularAttribute<User, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#recoverPasswordValid
	 **/
	public static volatile SingularAttribute<User, Date> recoverPasswordValid;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#name
	 **/
	public static volatile SingularAttribute<User, String> name;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.User#comment
	 **/
	public static volatile SingularAttribute<User, String> comment;

	public static final String PETS = "pets";
	public static final String COUNTRY = "country";
	public static final String VKONTAKTE_KEY = "vkontakteKey";
	public static final String UNID = "unid";
	public static final String BIRTHDATE = "birthdate";
	public static final String ROLE = "role";
	public static final String CITY = "city";
	public static final String LOGIN_DATE = "loginDate";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String QUERY_FIND_ONLINE = "findOnline";
	public static final String TWITTER_KEY = "twitterKey";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String ACTIVE_DATE = "activeDate";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String FACEBOOK_KEY = "facebookKey";
	public static final String RECOVER_PASSWORD_KEY = "recoverPasswordKey";
	public static final String SEX = "sex";
	public static final String QUERY_LIST = "list";
	public static final String QUERY_FIND_BY_LOGIN = "findByLogin";
	public static final String VERSION = "version";
	public static final String QUERY_FIND_BY_LOGIN_AND_EMAIL = "findByLoginAndEmail";
	public static final String RECOVER_PASSWORD_VALID = "recoverPasswordValid";
	public static final String NAME = "name";
	public static final String COMMENT = "comment";
	public static final String QUERY_FIND_BY_LOGIN_AND_PASSWORD = "findByLoginAndPassword";

}

