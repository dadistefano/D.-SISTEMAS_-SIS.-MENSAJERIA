package grupomsj;

public class UsuarioChat implements IUsuario  {
    private IChatGrupalMediator mediator;
    private String name;

    public UsuarioChat(IChatGrupalMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    

    @Override
    public void send(String message) {
        System.out.println(name + " - Enviar: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " - Recibido: " + message);
    }

    @Override
    public String getName() {
        return name;
    }


	@Override
	public void sendPrivate(String message, IUsuario user) {
        System.out.println(name + " - Enviar privado a " + user.getName() + " :"+ message);
        mediator.sendMessage(message, this);
		
	}
}
