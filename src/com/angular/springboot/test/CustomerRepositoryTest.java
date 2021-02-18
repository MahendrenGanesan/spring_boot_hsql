package com.angular.springboot.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.angular.springboot.entity.Customer;
import com.angular.springboot.repository.CustomerRepository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class CustomerRepositoryTest {
     
    @Autowired
    private CustomerRepository customerRepository;
     
   // @Test
    public void whenFindingCustomerById_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        //assertThat(customerRepository.findById(1L)).isInstanceOf(Optional.class);
        //assertThat(actual, matcher);
    }
     
    // @Test
    public void whenFindingAllCustomers_thenCorrect() {
        customerRepository.save(new Customer("John", "john@domain.com"));
        customerRepository.save(new Customer("Julie", "julie@domain.com"));
        // assertThat(customerRepository.findAll()).isInstanceOf(List.class);
        // assertThat(customerRepository.findAll()).isInstanceOf(List.class);
    }
    
    @Test
    public void whenSavingCustomer_thenCorrect() {
        customerRepository.save(new Customer("Bob", "bob@domain.com"));
        Customer customer = customerRepository.findById(1L).orElseGet(() 
          -> new Customer("john", "john@domain.com"));
        // assertThat(customer.getName());
        assertEquals("","Bob", customer.getName());
    }
    
}