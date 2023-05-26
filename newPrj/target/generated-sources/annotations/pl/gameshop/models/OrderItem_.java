package pl.gameshop.models;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderItem.class)
public abstract class OrderItem_ {

	public static volatile SingularAttribute<OrderItem, BigDecimal> price;
	public static volatile SingularAttribute<OrderItem, String> name;
	public static volatile SingularAttribute<OrderItem, Long> id;

}

