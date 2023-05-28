package pl.gameshop.models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, BigDecimal> total;
	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, Date> orderDate;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile ListAttribute<Order, OrderItem> items;

}

