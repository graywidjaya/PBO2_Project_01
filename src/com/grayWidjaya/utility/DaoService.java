package com.grayWidjaya.utility;

import java.util.List;

/**
 *
 * @author G'ray
 */
public interface DaoService<E> {
    int addData (E object);
    
    int deleteData (E object);
    
    int updateData (E object);
    
    List<E> showAllData();
    
}
