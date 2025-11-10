
package com.mz.bibliteca_api.iservice;

import java.util.List;
import java.util.Optional;
import com.mz.bibliteca_api.entity.Editorial;

public interface IEditorialService {
    List<Editorial> findAll();
    Editorial save(Editorial editorial);
    Optional<Editorial> findById(Integer id);
    void deleteById(Integer id);
}