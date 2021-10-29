package chapter_10_4_2;

import java.util.*;

public class FileCustomerManagementService extends AbstractCustomerManagementService {

    private List<CustomerDto> customers;

    public FileCustomerManagementService(){
        this.customers = new ArrayList<CustomerDto>();
    }

    @Override
    public void register(Customer customer) {
        CustomerDto customerDto = this.convertFrom(customer);
        customers.add(customerDto);
    }

    @Override
    public List<CustomerDto> list() {
        return customers;
    }

    @Override
    public void delete(long customerNo) {
        Optional<CustomerDto> customerDto = customers.stream().filter(x -> customerNo == x.getNo()).findFirst();

        if(customerDto.isPresent()){
            customers.remove(customers.indexOf(customerDto.get()));

        }
    }
}
