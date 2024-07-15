package com.abctechnologies.procurementmanagementsystem.mapper;

import com.abctechnologies.procurementmanagementsystem.pojo.Supplier;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> list(String supplierName);

    /**
     * delete a supplier by id
     * @param id
     */
    @Delete("delete from tb_supplier where id = #{id}")
    void deleteById(Integer id);

    /**
     * insert a supplier
     * @param supplier
     */
    @Insert("insert into tb_supplier(supplier_name, address, contact_person, email, comment, create_time) " +
            "values(#{supplierName}, #{address}, #{contactPerson}, #{email}, #{comment}, #{createTime})")
    void insert(Supplier supplier);

    /**
     * Update a supplier
     * @param supplier
     */
    void update(Supplier supplier);
}
