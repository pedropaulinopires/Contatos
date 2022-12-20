package com.br.pedro.model.bean.dao;

import com.br.pedro.model.bean.Id;

public class IdDAO {
    public static void salvarID(Integer id){
        Id.setId(id);
    }
    
    public static int pegarID(){
        return Id.getId();
    }
}
