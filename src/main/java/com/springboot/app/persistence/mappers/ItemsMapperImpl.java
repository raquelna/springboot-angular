package com.springboot.app.persistence.mappers;


import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ItemsMapperImpl implements ItemsMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = " SELECT * " +
                 " FROM items " +
                 " ORDER BY id DESC ";

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
      
//    Setencias sql para actualizar, insertar y borrar
//    String sql = " UPDATE items "
//    		+ "SET nombre='aaaaa', descripcion='aaaaaaaaa', url='aaa'" +
//    " WHERE id=2 ";
//    
//    sql = " INSERT INTO items "
//    		+ "(nombre, descripcion, url)"
//    		+ "VALUES ('bvhjmnmn', 'ssssssss', 'zazazaza')";
//    
//    sql = " DELETE FROM items";

JdbcTemplate.update(sql);
    
    System.out.println(sql);
    
return null;
    
  }


  @Override
  public List<ItemsModel> searchItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = " SELECT * " +
                 " FROM items " +
                 " WHERE (nombre LIKE '%" + obj.getNombre() + "%') " +
                 " OR (descripcion LIKE '%" + obj.getDescripcion() + "%') " +
                 " ORDER BY id DESC ";

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
  }

}
