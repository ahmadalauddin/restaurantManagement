/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmad
 */
public class userData {
    
        userData(String type, String name, boolean status)
        {
            this.type = type;
            this.name = name;
            this.status = status;
        }
        
        private String type;
        private String name;
        private boolean status;
    
    public String getName(){
        
        return name;
        
    }
    
        public String getType(){
        
        return type;
        
    }
        
    public boolean getStatus(){
        
        return status;
        
    }
    
}
