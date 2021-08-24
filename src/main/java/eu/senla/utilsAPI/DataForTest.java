package eu.senla.utilsAPI;

import eu.senla.model.Category;
import eu.senla.model.Pet;
import eu.senla.model.TagPet;

import java.util.ArrayList;
import java.util.Collections;

public class DataForTest {
    public final static String JSON_SCHEMA_FILE = "src/test/resources/json/petJson.json";

    public static Pet getPetForPostTet(){
        TagPet tag = new TagPet(25, "Bengal cat");
        Category category = new Category(1, "Cat");
        Pet pet = new Pet(1234, category, "Mouse", new ArrayList<>(), new ArrayList<>(Collections.singletonList(tag)), "available");
    return pet;
    }
    public static Pet getPetForPutTest(){
        TagPet tag = new TagPet(31, "Norwegian cat");
        Category category = new Category(3, "Cat");
        Pet pet = new Pet(1234, category, "Alice", new ArrayList<>(), new ArrayList<>(Collections.singletonList(tag)), "available");
        return pet;
    }
    public static String getIdPetForPutTest(){
        Pet pet = getPetForPutTest();
        return String.valueOf(pet.getId());
    }

}
