package com.example.mgnt_sys.repository;

import com.example.mgnt_sys.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long>{
        
}
