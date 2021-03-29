package Menu;

public enum OpcionesMenu {
        NUEVO_PROYECTO("Iniciar nuevo proyecto."),
        ALTA_PERSONAS("Dar de alta a las personas que trabajan en el proyecto."),
        ALTA_TAREAS("Dar de alta una tarea."),
        FINALIZAR_TAREA("Marcar una tarea como finalizada."),
        INTRODUCIR_ELIMINAR_PERSONA("Introducir o eliminar una persona de una tarea."),
        MOSTRAR_LISTA_PERSONAS("Mostrar lista de personas asignadas a un proyecto"),
        MOSTRAR_TAREAS_PROYECTO("Mostrar las tareas de un proyecto ()");

        private String descripcion;

        OpcionesMenu(String descripcion){
            this.descripcion = descripcion;
        }
        public String getDescripcion(){
            return descripcion;
        }

        public static OpcionesMenu getOpcion(int posicion){
            return values()[posicion];
        }

        public static String getMenu(){
            StringBuilder sb = new StringBuilder();
            for(OpcionesMenu opcion : OpcionesMenu.values()){
                sb.append(opcion.ordinal()+1);
                sb.append(".-");
                sb.append(opcion.getDescripcion());
                sb.append("\n");
            }
            return sb.toString();
        }


}