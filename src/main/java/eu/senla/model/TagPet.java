package eu.senla.model;

public class TagPet {
    private int id;
    private String name;

    public TagPet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagPet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
