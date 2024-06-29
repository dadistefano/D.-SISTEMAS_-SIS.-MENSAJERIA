package grupomsj;
import java.util.ArrayList;
import java.util.List;

public class ChatGrupal implements IChatGrupalMediator {
	private List<IUsuario> users;
	private IUsuario chatOwner;

    public ChatGrupal() {
    	this.users = new ArrayList<>();
    }
    
	@Override
	public void setChatOwner(IUsuario user) {
		this.chatOwner = user;
		users.add(user);
		System.out.println("Se asigno a " + user.getName() + " como propietario del grupo");
	}
    
	@Override
	public void addUser(IUsuario user, IUsuario owner) {
        if (owner.equals(chatOwner)) {
            users.add(user);
            System.out.println(user.getName() + " ha sido agregado al chat por " + owner.getName());
        } else {
            System.out.println("Solo el propietario del chat puede agregar usuarios.");
        }
    }
        
    @Override
    public void sendMessage(String message, IUsuario user) {
    	for (IUsuario u : users) {
    		// Asegúrese de que el remitente no reciba su propio mensaje
    		if (!u.equals(user)) {
    			u.receiveMessage(message);
    		}
    	}
    }

	@Override
	public void removeUser(IUsuario user) {
        users.remove(user);
        System.out.println(user.getName() + " ha salido del chat.");
		
	}






					
    
}



