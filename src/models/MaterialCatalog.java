
package models;

import java.util.TreeMap;

public class MaterialCatalog {
    private TreeMap<String, Material> materialMap;
    
    public MaterialCatalog(){
        materialMap = new TreeMap<>();
    }
    
    public void addMaterial(Material newMaterial){
        materialMap.put(newMaterial.getID(), newMaterial);
    }
    
    public TreeMap<String, Material> getMap(){
        return materialMap;
    }
    
    public Material findMaterial(String title) throws MaterialNotFoundException {
        title = title.trim();

        for (Material nextMaterial : materialMap.values()) {
            if (nextMaterial.getTitle().equalsIgnoreCase(title)) {
                return nextMaterial;
            }
        }

        throw new MaterialNotFoundException();
    }
    
    public int getNumberOfMaterials(){
        return materialMap.size();
    }
}
