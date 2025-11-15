package pkProblemaRio.Actor;

public abstract class Actor {

    private String nombre;
    
    private Boolean estar;
    
    
    public Actor (String nombre, Boolean estar){
        this.nombre = nombre;
        this.estar = estar;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Boolean getEstar() {
        return estar;
    }

    public void setEstar(Boolean estar) {
        this.estar = estar;
    }
}
