
package models;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface MaterialCatalogInterface {
    public void addMaterial(Material newMaterial);
    public Map<String,Material> getMaterialMap();
    public Material findMaterial(String title) throws MaterialNotFoundException;
    public int getNumberOfMaterials();
    public List<Material> findItemsSoundLike(String title);
}
