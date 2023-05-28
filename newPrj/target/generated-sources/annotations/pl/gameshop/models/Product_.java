package pl.gameshop.models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> requirements;
	public static volatile SingularAttribute<Product, String> imageName;
	public static volatile ListAttribute<Product, Language> languages;
	public static volatile SingularAttribute<Product, Date> releaseDate;
	public static volatile SingularAttribute<Product, BigDecimal> price;
	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, AvailabilityType> availability;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, Platform> platform;

}

