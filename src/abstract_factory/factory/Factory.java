package abstract_factory.factory;

public abstract class Factory {
    public static Factory getFactory(String clasname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(clasname).getDeclaredConstructor().newInstance();
        } catch(ClassNotFoundException e) {
            System.out.println("클래스" + clasname + " 이 별견되지 않음.");
        } catch(Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
