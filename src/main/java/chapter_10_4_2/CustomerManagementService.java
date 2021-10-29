package chapter_10_4_2;

import java.util.List;

public interface CustomerManagementService {
    
    void register(Customer customer);

    List<CustomerDto> list();

    void delete(long userNo);
}
