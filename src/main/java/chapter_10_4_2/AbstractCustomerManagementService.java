package chapter_10_4_2;

public abstract class AbstractCustomerManagementService implements CustomerManagementService {
    
    protected CustomerDto convertFrom(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setAge(customer.getAge());
        customerDto.setEmail(customer.getEmail());
        customerDto.generateNo();

        return customerDto;
    }
}
