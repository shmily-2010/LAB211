/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0105;

/**
 *
 * @author kinhd
 */
public class Storekeeper {
    
    private int id;
    private String storekeeper;

    public Storekeeper() {
    }

    public Storekeeper(int id, String storekeeper) {
        this.id = id;
        this.storekeeper = storekeeper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(String storekeeper) {
        this.storekeeper = storekeeper;
    }
    
    
    
}
