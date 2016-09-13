package com.restful.dao.impl;

 
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.restful.dao.AbstractDao;
import com.restful.dao.CustomersDao;
import com.restful.model.Customers;

@Repository("customersDao")
public class CustomersDaoImpl extends AbstractDao implements CustomersDao {

    public List<Customers> findCustomersCriteriaOne( ){
        Criteria criteria = getSession().createCriteria(Customers.class);
        criteria   //this Restrictions meet bigger or equal zero as well since size is always bigger or equal zero      
        .add(Restrictions.sizeLe("orderses", 5) );
        return criteria.list();
    }
    
    public List  findCustomersCriteriaTwo( ){
        
        StringBuffer hql=new StringBuffer(400);
        hql.append("select  c.customerId  , avg(od.quantity * p.price)   ,   c.customerName   from  Customers c, Orders o,  OrderDetails od,   Products p")
        .append(" where  c.customerId=o.customers.customerId and o.orderId=od.orders.orderId and od.products.productId =p.productId")
        .append( " group by   c.customerId  having avg(od.quantity * p.price) >= :threshold " );

         
       return getSession().createQuery(hql.toString()).setParameter("threshold",1000.0).list();
        		 
        
    }
}
