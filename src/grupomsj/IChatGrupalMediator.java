package grupomsj;

//Mediator
public interface IChatGrupalMediator {
    void sendMessage(String message, IUsuario user);
    void addUser(IUsuario user, IUsuario owner);
    void removeUser(IUsuario user);
    void setChatOwner(IUsuario user);
}
