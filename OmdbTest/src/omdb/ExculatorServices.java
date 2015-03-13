package omdb;


public class ExculatorServices implements Runnable {

	private String filmAdi;
	private String filmTuru;
	public static int sayac=0;
	
	public ExculatorServices(String filmAdi, String filmTuru) {
		
		this.filmAdi=filmAdi;
		this.filmTuru=filmTuru;
		
	}
	
	@Override
	public void run() {
		
			sayac++;
			System.out.println(sayac+".film adý : ");
				
		
	}
	
}