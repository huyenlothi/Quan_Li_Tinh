package service.province;

import com.quanli.model.Customer;
import com.quanli.model.Province;
import com.quanli.repository.IProvinceRepo;
import com.quanli.repository.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProvinceServiceImpl implements IProvinceService{
    @Autowired
    private IProvinceRepo iProvinceRepo;


    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepo.findAll();
    }

    @Override
    public Province save(Province province) {
        return iProvinceRepo.save(province);
    }

    @Override
    public void delete(Long id) {
        iProvinceRepo.delete(id);
    }

    @Override
    public Province findById(Long id) {
        return iProvinceRepo.findOne(id);
    }
}
