
public class Menus {
	public StringBuilder imprimeMenu(String texto){
		StringBuilder builder = new StringBuilder();
		builder.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t-------- ");
		builder.append(texto);
		builder.append(" --------\n");
		return builder;
	}
	public static void esperar(){
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
