package grupomsj;

public class Main {

	public static void main(String[] args) {
        IChatGrupalMediator chatRoom = new ChatGrupal();

        IUsuario propietario = new UsuarioChat(chatRoom, "Juan");
        
        // Inicializar a Juan como propietario (owner) y usuario 
        chatRoom.setChatOwner(propietario);
             
        IUsuario maria = new UsuarioChat(chatRoom, "Maria");
        IUsuario luis = new UsuarioChat(chatRoom, "Luis");
        IUsuario pedro = new UsuarioChat(chatRoom, "Pedro");
        
        // El propietario "Juan" agrega a Maria y Luis
        chatRoom.addUser(maria, propietario);
        chatRoom.addUser(luis, propietario);
        
        propietario.send("Bienvenidos al Grupo!! ");
        maria.send("Hola, todos.");
        luis.send("¡Hola, como esta grupo??");
        
        //Mensaje privado a Maria (lo puede ver todo el grupo)
        luis.sendPrivate("¡Hola, Maria! como estas hoy??", maria);

        // Intento de Luis de agregar a Pedro (solo el propietario puede agregar)
        luis.send("Intenta agregar a Pedro...");
        chatRoom.addUser(pedro, luis);

        // Se elimino a Maria del grupo
        chatRoom.removeUser(maria);
	}
}
