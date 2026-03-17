package model;

public class Person {
/*
se definen las variables y se usa protected para usar las variables en
otras calses y clases hijos
 */
        protected int id;
        protected String nombre;
        protected String apellido;
        protected String fechaNacimiento;
        protected String telefono;

        public Person(int id, String nombre, String apellido, String fechaNacimiento, String telefono) {
                this.id = id;
                this.nombre = nombre;
                this.apellido = apellido;
                this.fechaNacimiento = fechaNacimiento;
                this.telefono = telefono;
        }

        public int getId() {
                return id;
        }

        public String getNombre() {
                return nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public String getFechaNacimiento() {
                return fechaNacimiento;
        }

        public String getTelefono() {
                return telefono;
        }

        @Override
        public String toString() {
                return "ID: " + id +
                        "\nNombre: " + nombre +
                        "\nApellido: " + apellido +
                        "\nFecha de nacimiento: " + fechaNacimiento +
                        "\nTeléfono: " + telefono;
        }
}