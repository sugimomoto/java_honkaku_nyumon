package chapter_10_4_2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class FileCustomerServiceManagementTest {
    
    @Test
    public void CustomerServiceCRUDTest(){
        FileCustomerManagementService fileCustomerManagementService = new FileCustomerManagementService();
        Customer customer = new Customer();
        customer.setName("Hello");
        customer.setAge(30);
        customer.setEmail("test@example.com");

        fileCustomerManagementService.register(customer);

        List<CustomerDto> customers = fileCustomerManagementService.list();

        assertEquals(customers.size(), 1);
        assertEquals(customers.get(0).getAge(), 30);
        
    }
}
