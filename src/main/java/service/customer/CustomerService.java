package service.customer;

import com.quanli.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IService;

public interface CustomerService extends IService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
