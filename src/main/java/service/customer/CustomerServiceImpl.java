package service.customer;

import com.quanli.exception.NotFoundException;
import com.quanli.model.Customer;
import com.quanli.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private IRepo customerRepo;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepo.delete(id);
    }

    @Override
    public Customer findById(Long id) throws NotFoundException{
        Customer customer= customerRepo.findOne(id);
        if (customer != null) {
        return customer;
        }else {

            throw new NotFoundException();
        }
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepo.findAllByFirstNameContaining(firstname, pageable);
    }
}
