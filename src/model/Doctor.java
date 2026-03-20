package model;

public class Doctor {
    private int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String especialidad;
    private String licencia;

    public Doctor(int id, String nombre, String apellido, String fechaNacimiento,
                  String telefono, String especialidad, String licencia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.licencia = licencia;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getTelefono() { return telefono; }
    public String getEspecialidad() { return especialidad; }
    public String getLicencia() { return licencia; }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }
}