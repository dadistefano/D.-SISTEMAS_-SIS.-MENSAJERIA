package grupomsj;

//Colleague
public interface IUsuario {
    void send(String message);
    void sendPrivate(String message,IUsuario user);
    void receiveMessage(String message);
    String getName();
}
